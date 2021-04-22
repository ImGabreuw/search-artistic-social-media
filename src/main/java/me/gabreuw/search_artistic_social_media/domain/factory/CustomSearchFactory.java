package me.gabreuw.search_artistic_social_media.domain.factory;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.customsearch.Customsearch;
import com.google.api.services.customsearch.CustomsearchRequestInitializer;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Component
public class CustomSearchFactory {

    @Value("${application.name}")
    private String applicationName;
    @Value("${application.api-key}")
    private String apiKey;


    @SneakyThrows({GeneralSecurityException.class, IOException.class})
    public Customsearch create() {
        return new Customsearch.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), null)
                .setApplicationName(applicationName)
                .setGoogleClientRequestInitializer(new CustomsearchRequestInitializer(apiKey))
                .build();
    }

}
