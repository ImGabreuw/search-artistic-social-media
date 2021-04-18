package me.gabreuw.search_artistic_social_media.service;

import com.google.api.services.customsearch.Customsearch;
import com.google.api.services.customsearch.model.Result;
import com.google.api.services.customsearch.model.Search;
import lombok.SneakyThrows;
import me.gabreuw.search_artistic_social_media.domain.factory.CustomSearchFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    private CustomSearchFactory customSearchFactory;

    @SneakyThrows(IOException.class)
    public String searchArtisticInstagram(String username) {
        Customsearch.Cse.List request = customSearchFactory.create()
                .cse()
                .list(username + " instagram")
                .setCx("002845322276752338984:vxqzfa86nqc");

        Search response = request.execute();
        List<Result> items = response.getItems();

        return !items.isEmpty() ?
                items.get(0).getLink() :
                "Username not found";
    }

}
