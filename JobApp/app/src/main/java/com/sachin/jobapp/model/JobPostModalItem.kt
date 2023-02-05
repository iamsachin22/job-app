package com.sachin.jobapp.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class JobPostModalItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("experiance")
    val experiance: Int,
    @SerializedName("jobtitle")
    val jobtitle: String,
    @SerializedName("techstack")
    val techstack: List<String>
)