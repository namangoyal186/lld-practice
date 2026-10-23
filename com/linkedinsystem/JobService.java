package com.linkedinsystem;
import java.util.*;

import java.util.concurrent.CopyOnWriteArrayList;

public class JobService {
    private List<JobPosting> jobs = new CopyOnWriteArrayList<>();

    public void postJob(JobPosting job){
        jobs.add(job);
    }

    public List<JobPosting> getAllJobs(){
        return new ArrayList<>(jobs);
    }

    public List<JobPosting> searchJobs(String keyword){
        List<JobPosting> result = new ArrayList<>();
        for(JobPosting job:jobs){
            if(job.getTitle().toLowerCase().contains(keyword.toLowerCase()) || job.getDescription().toLowerCase().contains(keyword.toLowerCase())){
                result.add(job);
            }
        }
        return result;
    }
}
