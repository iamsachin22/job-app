package com.sachin.jobapp.model

data class JobPost(
    val id : String,
    val jobtitle:String,
    val experiance:Int,
    val description:String,
    val techstack:List<String>
    )
