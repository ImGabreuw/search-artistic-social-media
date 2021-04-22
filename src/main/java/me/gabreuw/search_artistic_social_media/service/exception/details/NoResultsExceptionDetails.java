package me.gabreuw.search_artistic_social_media.service.exception.details;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class NoResultsExceptionDetails extends ExceptionDetails {

    private final String query;

}
