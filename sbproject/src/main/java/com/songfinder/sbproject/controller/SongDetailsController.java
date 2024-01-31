package com.songfinder.sbproject.controller;

import com.songfinder.sbproject.domain.RequestDTO;
import com.songfinder.sbproject.domain.Response;
import com.songfinder.sbproject.domain.exception.APIErrorException;
import com.songfinder.sbproject.service.SongDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.songfinder.sbproject.service.SongDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class SongDetailsController {

    @Autowired
    private SongDetailsService service;

    @GetMapping("/song")
    public Response printSongInformation(@RequestBody RequestDTO request) throws ExecutionException, InterruptedException {

        if(request.getSearchTerm().equals(""))
            throw new APIErrorException(HttpStatus.BAD_REQUEST.value(), "Please put correct search term");

        return service.getSong(request.getSearchTerm());

       return service.getSong(request.getSearchTerm());

    }
}
