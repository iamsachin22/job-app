package com.sachin.jobapp.repository;

import com.sachin.jobapp.model.JobPost;

import java.util.List;

public interface SearchRepository {

    List<JobPost> searchByText(String text);
}
