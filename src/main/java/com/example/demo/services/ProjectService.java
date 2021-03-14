package com.example.demo.services;

import java.util.List;
import com.example.demo.model.Project;

public interface ProjectService {
	List<Project> findAllProject(); 
	boolean saveProject(Project project);
	boolean updateProject(Project project, String project_id);
	boolean deleteProject(String project_id);
	Project findProjectByID(String id);
}
