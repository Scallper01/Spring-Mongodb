package com.webAppMongoDB.demo.documents;

import com.webAppMongoDB.demo.utils.TestResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "test_records")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TestRecord {

    @Id
    private String id;

    @Field("testId")
    @Indexed
    private String testId;

    @Field("testDate")
    @Indexed
    private Date date;

    @Field("result")
    private TestResult result;

}
