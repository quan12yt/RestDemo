package com.example.demo.services;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Project;
import com.example.demo.model.Users;
import com.example.demo.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;
   
	@Override
	public List<Project> findAllProject() {
		return projectRepository.findAll();
	}

	@Override
	public boolean saveProject(Project project) {
		projectRepository.save(project);
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean deleteProject(String project_id) {
		Optional<Project> projectRoot = projectRepository.findById(project_id); 
		projectRepository.delete(projectRoot.get());
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updateProject(Project project, String project_id) {
		// TODO Auto-generated method stub
		Optional<Project> projectRoot = projectRepository.findById(project_id);
		projectRoot.get().setProject_name(project.getProject_name());
		projectRoot.get().setProject_status(project.getProject_status());
		projectRoot.get().setEstimate_start_date(project.getEstimate_start_date());
		projectRoot.get().setActual_start_date(project.getActual_start_date());
		projectRoot.get().setLeader(project.getLeader());
		projectRepository.save(projectRoot.get());
		return true;
	}

	@Override
	public Project findProjectByID(String id) {
		// TODO Auto-generated method stub
		Optional<Project> p =projectRepository.findById(id);
		return p.get();
	}

//	 public Users updateUser(Users user, Long userId) {
//	        return userRepository.findById(userId).map(users -> {
//	            users.setAddress(user.getAddress());
//	            users.setBirthday(user.getBirthday());
//	            users.setName(user.getName());
//	            return userRepository.save(users);
//	        }).orElseGet(() -> {
//	            return userRepository.save(user);
//	        });
//	    }

}
