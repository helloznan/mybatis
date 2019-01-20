/**
 * 
 */
package com.zn.demo.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhengnan
 *
 */
public class User implements Serializable{
	private static final long serialVersionUID = -301947045092719646L;
	
	private Long id;
	private String name;
	private String pwd;
	
	private List<Role> roles;
	private School school;
	
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	
}
