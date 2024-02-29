package com.wsCorp.dsGameList.Resource.Exceptions;

import com.wsCorp.dsGameList.Service.Exceptions.DatabaseException;
import com.wsCorp.dsGameList.Service.Exceptions.GameNotFoundException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.xml.crypto.Data;
import java.time.Instant;

@ControllerAdvice
public class ResourceHandlerException {

    @ExceptionHandler(GameNotFoundException.class)
    public ResponseEntity<StandartError> gameNotFound(HttpServletRequest request, GameNotFoundException e) {
        StandartError stdErr = new StandartError();
        stdErr.setError(e.getMessage());
        stdErr.setPath(request.getServletPath());
        stdErr.setStatus(HttpStatus.NOT_FOUND.value());
        stdErr.setTimeStamp(Instant.now());
        stdErr.setMessage("Data not Found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(stdErr);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandartError> gameNotFound(HttpServletRequest request, DatabaseException e) {
        StandartError stdErr = new StandartError();
        stdErr.setError(e.getMessage());
        stdErr.setPath(request.getServletPath());
        stdErr.setStatus(HttpStatus.BAD_REQUEST.value());
        stdErr.setTimeStamp(Instant.now());
        stdErr.setMessage("Item exists");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(stdErr);
    }

}
