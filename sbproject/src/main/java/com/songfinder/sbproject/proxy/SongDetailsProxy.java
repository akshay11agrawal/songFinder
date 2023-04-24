package com.songfinder.sbproject.proxy;

import com.songfinder.sbproject.domain.Response;
import com.songfinder.sbproject.domain.exception.APIErrorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.concurrent.ExecutionException;

@Component
@Slf4j
public class SongDetailsProxy {

    @Autowired
    private WebClient webClient;

    @Value("${song-details.host}")
    private String host;

    @Value("${song-details.key}")
    private String key;

    @Value("${song-details.limit}")
    private String limit;

    @Value("${song-details.offset}")
    private String offset;

    @Value("${song-details.rhost}")
    private String rHost;


    public Response getSongsDetails(String searchTerm) throws ExecutionException, InterruptedException {

        URI uri = UriComponentsBuilder.fromHttpUrl(host)
                .queryParam("term",searchTerm)
                .queryParam("locale","en-US")
                .queryParam("offset",offset)
                .queryParam("limit",limit)
                .build().toUri();
        log.info("getSongsDetails : "+uri);
        ResponseEntity<Response> responseEntity =
         webClient.get()
                .uri(uri)
                 .headers(httpHeaders -> {
                     httpHeaders.set("X-RapidAPI-Key",key);
                     httpHeaders.set("X-RapidAPI-Host",rHost);
                 })
                .retrieve()
                 .onStatus(HttpStatusCode::isError, clientResponse -> {
                     if(clientResponse.statusCode().is4xxClientError()){
                         return Mono.error(new APIErrorException(clientResponse.statusCode().value()
                         ,"Error while calling the song details service"));
                     }else{
                         return Mono.error(new APIErrorException(HttpStatus.INTERNAL_SERVER_ERROR.value()
                         ,"Internal Server error occurred while calling song details service"));
                     }
                 })
                 .toEntity(Response.class)
                 .toFuture().get();

        return responseEntity.getBody();
    }
}
