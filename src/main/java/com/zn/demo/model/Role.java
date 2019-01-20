package com.zn.demo.model;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable{
	private static final long serialVersionUID = -4131457043785076058L;

	private Long id;
	private String name;
	private List<Privilege> privileges;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
	
	
	
	
	
}
