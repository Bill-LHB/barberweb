package com.lhb.barber.model;

import java.util.Set;

import javax.persistence.Entity;
@Entity
public class Post {
private int post_id;
private String post_name;//职位名称
private String post_wage;//职位基本工资
private Set<Employee> employeeSet;//职位员工
private Department department;//部门
private String description;//职位描述

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Post(int post_id, String post_name, String post_wage) {
	
	this.post_id = post_id;
	this.post_name = post_name;
	this.post_wage = post_wage;
}

public Post(String post_name, String post_wage) {
	this.post_name = post_name;
	this.post_wage = post_wage;
}
public Post() {
	
}

public int getPost_id() {
	return post_id;
}

public void setPost_id(int post_id) {
	this.post_id = post_id;
}

public String getPost_name() {
	return post_name;
}

public void setPost_name(String post_name) {
	this.post_name = post_name;
}

public String getPost_wage() {
	return post_wage;
}

public void setPost_wage(String post_wage) {
	this.post_wage = post_wage;
}


public Set<Employee> getEmployeeSet() {
	return employeeSet;
}

public void setEmployeeSet(Set<Employee> employeeSet) {
	this.employeeSet = employeeSet;
}

public Department getDepartment() {
	return department;
}

public void setDepartment(Department department) {
	this.department = department;
}

}
