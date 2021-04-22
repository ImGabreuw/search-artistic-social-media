package me.gabreuw.search_artistic_social_media.service.exception.handler;

import me.gabreuw.search_artistic_social_media.service.exception.NoResultsException;
import me.gabreuw.search_artistic_social_media.service.exception.details.NoResultsExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ApplicationHandler {

    @ExceptionHandler(NoResultsException.class)
    public ResponseEntity<NoResultsExceptionDetails> handlerNoResultsException(
            NoResultsException exception,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        NoResultsExceptionDetails exceptionDetails = NoResultsExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .title(exception.getClass().getName())
                .details(exception.getMessage())
                .developerMessage(exception.getLocalizedMessage())
                .query(request.getRequestURI())
                .build();

        return ResponseEntity
                .status(status)
                .body(exceptionDetails);
    }

}
