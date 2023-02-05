package com.sachin.jobapp.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "JobPost")
public class JobPost {
    String jobtitle;
    String experiance;
    String description;
    String techstack[];

    public JobPost() {
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getExperiance() {
        return experiance;
    }

    public void setExperiance(String experiance) {
        this.experiance = experiance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getTechstack() {
        return techstack;
    }

    public void setTechstack(String[] techstack) {
        this.techstack = techstack;
    }

    @Override
    public String toString() {
        return "JobPost{" +
                "jobtitle='" + jobtitle + '\'' +
                ", experiance='" + experiance + '\'' +
                ", description='" + description + '\'' +
                ", techstack=" + Arrays.toString(techstack) +
                '}';
    }
}
