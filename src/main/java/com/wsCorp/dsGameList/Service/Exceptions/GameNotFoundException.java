package com.wsCorp.dsGameList.Service.Exceptions;

import java.util.function.Supplier;

public class GameNotFoundException extends RuntimeException {
    public GameNotFoundException(String message) {
        super(message);
    }


}
