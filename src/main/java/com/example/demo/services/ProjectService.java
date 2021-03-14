package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Project;

public interface ProjectService {
	List<Project> findAllProject();
}
