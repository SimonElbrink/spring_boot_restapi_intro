package se.lexicon.simon.spring_boot_restapi_intro.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class MyExceptionResponse {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;

    private Integer status;
    private String value;
    private String message;
    private String path;

    public MyExceptionResponse(LocalDateTime timestamp, Integer status, String value, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.value = value;
        this.message = message;
        this.path = path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}
