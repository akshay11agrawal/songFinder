package com.songfinder.sbproject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Track {
    private String key;
    private String title;
    private String subtitle;
    private String url;
}
