package com.sachin.jobapp.repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.sachin.jobapp.model.JobPost;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImpl implements SearchRepository{

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter converter;
    @Override
    public List<JobPost> searchByText(String text) {
        final List<JobPost> postList = new ArrayList();
        MongoDatabase database = mongoClient.getDatabase("jobappdb");
        MongoCollection<Document> collection = database.getCollection("JobPost");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text", new Document("query", text).append("path", Arrays.asList("techstack", "description", "jobtitle")))),
                        new Document("$sort",
                        new Document("experiance", 1L)),
                        new Document("$limit", 5L)));

        result.forEach(doc -> postList.add(converter.read(JobPost.class,doc)));
        return postList;
    }
}
