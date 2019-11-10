package com.code.javabasic.exception.defined;

import java.io.IOException;

public class MyIOException extends IOException {
    public MyIOException() {
    }

    public MyIOException(String message) {
        super(message);
    }
}
