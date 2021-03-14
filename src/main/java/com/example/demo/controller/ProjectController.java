package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@PostMapping("/add")
	public boolean saveProject(@RequestBody Project project) {
		return projectService.saveProject(project);
	}
	@PutMapping("/update-project/{id}")
	public boolean updateProject(@RequestBody Project project, @PathVariable String id) {
		return projectService.updateProject(project, id);
	}
	@DeleteMapping("/delete-project/{id}")
	public boolean deleteProject(@PathVariable String id) {
		return projectService.deleteProject(id);
	}
	@GetMapping("/find-by-id/{id}")
	public Project findProjectByID(@PathVariable String id) {
		return projectService.findProjectByID(id);
	}
}
 