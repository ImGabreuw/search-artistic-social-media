package me.gabreuw.search_artistic_social_media.service.exception.details;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@SuperBuilder
public class ExceptionDetails implements Serializable {

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",
            timezone = "GMT"
    )
    protected LocalDateTime timestamp;

    protected Integer status;

    protected String title;
    protected String details;
    protected String developerMessage;

}
