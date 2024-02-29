package com.wsCorp.dsGameList.Resource.Exceptions;

import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class StandartError {
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant timeStamp;
    private String path;
    private Integer status;
    private String message;
    private String error;

    public StandartError() {
    }

    public StandartError(Instant timeStamp, String path, Integer status, String message, String error) {
        this.timeStamp = timeStamp;
        this.path = path;
        this.status = status;
        this.message = message;
        this.error = error;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
