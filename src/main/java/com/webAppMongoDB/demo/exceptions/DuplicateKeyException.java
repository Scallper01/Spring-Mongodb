package com.webAppMongoDB.demo.exceptions;

public class DuplicateKeyException extends CustomException {

    public DuplicateKeyException(String id) {
        super("Un test avec l'id " + id + " existe déjà", "TEST_DUPLICATE");
    }
}
