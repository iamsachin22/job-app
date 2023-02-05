package com.sachin.jobapp.di

import com.sachin.jobapp.model.JobPost
import com.sachin.jobapp.model.JobPostModalItem
import com.sachin.jobapp.util.Constants
import retrofit2.http.GET

interface ApiService {
    @GET(Constants.GET_ALL_JOB)
    suspend fun getAllPosts():List<JobPostModalItem>
}