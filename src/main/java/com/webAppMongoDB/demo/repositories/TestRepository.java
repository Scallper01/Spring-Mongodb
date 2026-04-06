package com.webAppMongoDB.demo.repositories;

import com.webAppMongoDB.demo.documents.Test;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestRepository extends MongoRepository<Test, String> {
    Optional<Test> findByName(String name);
}
