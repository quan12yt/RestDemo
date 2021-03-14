package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Project;
import com.example.demo.services.ProjectService;

@RestController
@RequestMapping("api/project/read")
public class ProjectController {
	@Autowired
	ProjectService projectService;
	
	@GetMapping("")
	public List<Project> findAllProject(){
		return projectService.findAllProject();
	}
}
