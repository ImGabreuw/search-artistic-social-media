package me.gabreuw.search_artistic_social_media.resource;

import lombok.extern.log4j.Log4j2;
import me.gabreuw.search_artistic_social_media.domain.dto.ArtisticDTO;
import me.gabreuw.search_artistic_social_media.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/search")
@Log4j2
public class SearchResource {

    @Autowired
    private SearchService searchService;

    @GetMapping(path = "/instagram/{username}")
    public ResponseEntity<Void> searchArtisticInstagram(
            @PathVariable String username
    ) {
        String instagramLink = searchService.searchArtisticInstagram(username);
        log.info("{} - {}", username, instagramLink);

        return ResponseEntity
                .ok()
                .build();
    }

    @GetMapping(path = "/soundcloud/{username}")
    public ResponseEntity<Void> searchArtisticSoundCloud(
            @PathVariable String username
    ) {
        String soundCloudLink = searchService.searchArtisticSoundCloud(username);
        log.info("{} - {}", username, soundCloudLink);

        return ResponseEntity
                .ok()
                .build();
    }

    @GetMapping(path = "/all/{username}")
    public ResponseEntity<ArtisticDTO> searchArtisticAllSocialMedia(
            @PathVariable String username
    ) {
        String instagramLink = searchService.searchArtisticInstagram(username);
        String soundCloudLink = searchService.searchArtisticSoundCloud(username);

        ArtisticDTO artisticDTO = new ArtisticDTO(instagramLink, soundCloudLink);

        return ResponseEntity
                .ok()
                .body(artisticDTO);
    }

}
