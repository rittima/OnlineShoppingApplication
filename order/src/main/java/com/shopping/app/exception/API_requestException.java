package com.shopping.app.exception;

public class API_requestException extends RuntimeException {

	public API_requestException(String message, Throwable cause){
        super(message, cause);
    }

    public API_requestException(String message){
        super(message);
    }
}
