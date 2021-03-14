package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ROLE",schema = "public")
public class Roles implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String role_id;

    private String role_name;
    private String remmark;
   

    public Roles(){}


    public String getRole_id() {
		return role_id;
	}


	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}


	public String getRole_name() {
		return role_name;
	}


	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}


	public String getRemmark() {
		return remmark;
	}


	public void setRemmark(String remmark) {
		this.remmark = remmark;
	}


	@Override
    public int hashCode() {
        return super.hashCode();
    }
}
