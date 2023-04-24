package controller;

import com.songfinder.sbproject.controller.SongDetailsController;
import com.songfinder.sbproject.domain.*;
import com.songfinder.sbproject.service.SongDetailsService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SongDetailsControllerTest {

    @InjectMocks
    private SongDetailsController controller;

    @Mock
    private SongDetailsService service;


    @Test
    void checkControllerPrintSong() throws ExecutionException, InterruptedException {
        when(service.getSong(Mockito.any())).thenReturn(getSampleSong());
        Response response = controller.printSongInformation(RequestDTO.builder().searchTerm("demo song").build());
        assertNotNull(response);
        assertEquals(response.getTracks().getHits().stream()
                .filter(song -> song.getTrack().getTitle().equals("Kal Ho Naa Ho"))
                .findAny().orElse(Hits.builder().build()).getTrack().getTitle(),"Kal Ho Naa Ho");
    }

    private Response getSampleSong(){
        Track track = Track.builder().title("Kal Ho Naa Ho").build();
        List<Hits> hits = Lists.newArrayList(Hits.builder().track(track).build());

        return Response.builder()
                .tracks(Tracks.builder().hits(hits).build()).build();
    }
}
