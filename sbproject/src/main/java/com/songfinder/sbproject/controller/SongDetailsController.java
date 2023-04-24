package com.songfinder.sbproject.controller;

import com.songfinder.sbproject.domain.RequestDTO;
import com.songfinder.sbproject.domain.Response;
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
       return service.getSong(request.getSearchTerm());
    }
}
