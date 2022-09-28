package com.javatpoint.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (HttpStatus.NOT_FOUND)
public class BooksNotFoundException extends Exception{
    public BooksNotFoundException() {
        super();
    }

    public BooksNotFoundException(String message) {
        super(message);
    }

    public BooksNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BooksNotFoundException(Throwable cause) {
        super(cause);
    }

    protected BooksNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
