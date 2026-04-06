package com.webAppMongoDB.demo.service;

import com.webAppMongoDB.demo.documents.Test;
import com.webAppMongoDB.demo.exceptions.BusinessObjectNotFoundException;
import com.webAppMongoDB.demo.exceptions.DuplicateKeyException;
import com.webAppMongoDB.demo.repositories.RecordRepository;
import com.webAppMongoDB.demo.repositories.TestRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TestService {
    private TestRepository testRepository;
    private RecordRepository recordRepository;

    public Test saveTest(Test test) throws DuplicateKeyException {

        Optional<Test> tests = testRepository.findById(test.getId());
        if (test.getId() != null && testRepository.existsById(test.getId())) {
            throw new DuplicateKeyException(test.getId());
        }
        return testRepository.save(test);
    }

    public List<Test> findTestAll() {
        return testRepository.findAll();
    }

    public Optional<Test> findTestById(String id) throws BusinessObjectNotFoundException {

        if (id != null && !testRepository.existsById(id)){
            throw new BusinessObjectNotFoundException(id);
        }
        return testRepository.findById(id);
    }

    public Optional<Test> findTestByName(String name) {
        return testRepository.findByName(name);
    }
}
