package com.webAppMongoDB.demo.controllers;

import com.webAppMongoDB.demo.documents.Test;

import com.webAppMongoDB.demo.exceptions.BusinessObjectNotFoundException;
import com.webAppMongoDB.demo.exceptions.DuplicateKeyException;
import com.webAppMongoDB.demo.service.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TestRestController {

    private TestService testService;

    public TestRestController(TestService testService){
        this.testService = testService;
    }

    @PostMapping("/test")
    public ResponseEntity<Test> createTest(@RequestBody Test test) throws DuplicateKeyException {

        Test saved = testService.saveTest(test);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(saved);
    }

    @GetMapping("/test/{id}")
    public ResponseEntity<Optional<Test>> getTestDetails(@PathVariable(name="id", required = true) String id) throws BusinessObjectNotFoundException {

        Optional<Test> test = testService.findTestById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(test);
    }
}
