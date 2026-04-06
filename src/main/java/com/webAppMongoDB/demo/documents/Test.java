package com.webAppMongoDB.demo.documents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "tests")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Test {

    @Id
    private String id;

    @Indexed
    @Field("name")
    private String name;

}
