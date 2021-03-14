package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="project",schema="public")
public class Project {
	@Id
	private String project_id;
	private String project_name;
	private Date estimate_start_date;
	private Date actual_start_date;
	private String project_status;
	private String leader;
	public String getProject_id() {
		return project_id;
	}
	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public Date getEstimate_start_date() {
		return estimate_start_date;
	}
	public void setEstimate_start_date(Date estimate_start_date) {
		this.estimate_start_date = estimate_start_date;
	}
	public Date getActual_start_date() {
		return actual_start_date;
	}
	public void setActual_start_date(Date actual_start_date) {
		this.actual_start_date = actual_start_date;
	}
	public String getProject_status() {
		return project_status;
	}
	public void setProject_status(String project_status) {
		this.project_status = project_status;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	
	
}
