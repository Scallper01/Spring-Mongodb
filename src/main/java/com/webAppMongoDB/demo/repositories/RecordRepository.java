package com.webAppMongoDB.demo.repositories;

import com.webAppMongoDB.demo.documents.TestRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface RecordRepository extends MongoRepository<TestRecord, String> {

}
