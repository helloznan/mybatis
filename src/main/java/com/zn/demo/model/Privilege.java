package com.zn.demo.model;

import java.io.Serializable;

public class Privilege implements Serializable{
	private static final long serialVersionUID = -8279154497835067719L;

	private Long id;
	private String name;
	
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
	
	
}
