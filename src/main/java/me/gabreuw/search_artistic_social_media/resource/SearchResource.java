package me.gabreuw.search_artistic_social_media.resource;

import lombok.extern.log4j.Log4j2;
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
        String link = searchService.searchArtisticInstagram(username);
        log.info("{} - {}", username, link);

        return ResponseEntity
                .ok()
                .build();
    }

}
