package com.songfinder.sbproject.service;

import com.songfinder.sbproject.domain.Response;
import com.songfinder.sbproject.proxy.SongDetailsProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class SongDetailsService {

    @Autowired
    private SongDetailsProxy proxy;


    public Response getSong(String term) throws ExecutionException, InterruptedException {
      return  proxy.getSongsDetails(term);
    }
}
