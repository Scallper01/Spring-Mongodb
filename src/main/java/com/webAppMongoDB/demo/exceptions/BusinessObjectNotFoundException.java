package com.webAppMongoDB.demo.exceptions;

public class BusinessObjectNotFoundException extends CustomException {

    public BusinessObjectNotFoundException(String id) {
        super("l'object avec l'id " + id + " n'existe pas", "OBJECT_NOT_FOUND");
    }
}
