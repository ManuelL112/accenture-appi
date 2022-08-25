package org.accenture.api.pruebaApi.commons;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class Message {

    @JsonProperty("code")
    protected String code;

    @JsonProperty("message")
    protected String text;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    protected LocalDateTime timestamp = LocalDateTime.now();

    protected Message(String code, String text) {
        this.code = code;
        this.text = text;
    }
}
