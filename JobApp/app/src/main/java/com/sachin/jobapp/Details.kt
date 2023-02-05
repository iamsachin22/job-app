package com.sachin.jobapp

import com.sachin.jobapp.model.JobPost

object Details {
    val JobDetailsList = listOf(
        JobPost(
            id = "1",
            jobtitle = "java developer",
            experiance = 4,
            description = "Senior software engineer with spring boot and java experience.",
            techstack = arrayListOf("Java","Android","Java","Android",),
        ),
        JobPost(
            id = "2",
            jobtitle = "android developer",
            experiance = 3,
            description = "Senior android engineer with android  and java experience.",
            techstack = arrayListOf("android","xml"),
        ),
        JobPost(
            id = "3",
            jobtitle = "software developer",
            experiance = 5,
            description = "Senior software engineer with spring boot and java experience.",
            techstack = arrayListOf("Java","Android"),
        ),
        JobPost(
            id = "4",
            jobtitle = "ios developer",
            experiance = 4,
            description = "Senior software engineer with ios and swift experience.",
            techstack = arrayListOf("ios","swift"),
        ),
        JobPost(
            id = "5",
            jobtitle = "python developer",
            experiance = 4,
            description = "Senior software engineer with python and java experience.",
            techstack = arrayListOf("python","java"),
        ),
        JobPost(
            id = "6",
            jobtitle = "unity developer",
            experiance = 4,
            description = "Senior software engineer with unity and 3d experience.",
            techstack = arrayListOf("unity","3d"),
        ),
        JobPost(
            id = "7",
            jobtitle = "php developer",
            experiance = 4,
            description = "Senior software engineer with php experience.",
            techstack = arrayListOf("php","javascript"),
        ),
        JobPost(
            id = "8",
            jobtitle = "rust developer",
            experiance = 4,
            description = "Senior software engineer with rust and java experience.",
            techstack = arrayListOf("rust","java"),
        ),
        JobPost(
            id = "9",
            jobtitle = "go lang developer",
            experiance = 6,
            description = "Senior software engineer with go and java experience.",
            techstack = arrayListOf("go","java"),
        ),
        JobPost(
            id = "10",
            jobtitle = "software tester",
            experiance = 2,
            description = "software tester with manual and automation experience.",
            techstack = arrayListOf("testing","manual"),
        ),
    )
}