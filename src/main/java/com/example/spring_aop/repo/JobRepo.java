package com.example.spring_aop.repo;

import com.example.spring_aop.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepo extends JpaRepository<JobPost, Integer> {
    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postDesc);

}
