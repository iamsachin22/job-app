package com.sachin.jobapp.repository;

import com.sachin.jobapp.model.JobPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobPostRepository extends MongoRepository<JobPost,String> {

}
