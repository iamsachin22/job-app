package com.sachin.jobapp.data.repository

import com.sachin.jobapp.di.ApiService
import com.sachin.jobapp.model.JobPost
import com.sachin.jobapp.model.JobPostModalItem
import javax.inject.Inject

class JobAppRepository @Inject constructor(
    private val apiService: ApiService
){
    suspend fun getAllPosts():List<JobPostModalItem>{
        return apiService.getAllPosts()
    }
}