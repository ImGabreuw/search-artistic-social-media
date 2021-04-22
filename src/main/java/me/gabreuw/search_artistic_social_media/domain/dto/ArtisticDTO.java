package me.gabreuw.search_artistic_social_media.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ArtisticDTO implements Serializable {

    private final String instagram;
    private final String soundcloud;

}
