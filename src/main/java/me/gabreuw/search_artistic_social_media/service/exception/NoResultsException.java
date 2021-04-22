package me.gabreuw.search_artistic_social_media.service.exception;

public class NoResultsException extends RuntimeException {

    public NoResultsException(String query) {
        super(String.format(
                "No resulto for : %s",
                query
        ));
    }

}
