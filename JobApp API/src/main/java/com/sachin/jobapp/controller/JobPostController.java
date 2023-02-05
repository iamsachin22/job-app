package com.sachin.jobapp.controller;

import com.sachin.jobapp.model.JobPost;
import com.sachin.jobapp.repository.JobPostRepository;
import com.sachin.jobapp.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobPostController {

    @Autowired
    JobPostRepository repository;

    @Autowired
    SearchRepository searchRepository;

    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/allJobPosts")
    @CrossOrigin
    public List<JobPost> getAllPosts(){
        return repository.findAll();
    }
    @GetMapping("jobPostsSearch/{text}")
    @CrossOrigin
    public List<JobPost> search(@PathVariable String text){
       return searchRepository.searchByText(text);
    }

    @PostMapping("/addJobPost")
    @CrossOrigin
    public JobPost addPost(@RequestBody JobPost jobPost){
        return repository.save(jobPost);
    }
}
