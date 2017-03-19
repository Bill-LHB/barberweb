package com.lhb.barber.model;

import java.util.Set;

import javax.persistence.Entity;
@Entity
public class Department{
private int department_id;
private String name;//部门名称
private String description;//部门描述
private Set<Post> postSet;//员工职位
public Department(int department_id, String name) {
	this.department_id = department_id;
	this.name = name;
}
public Department(String name) {
	this.name = name;
}
public Department() {

}

public int getDepartment_id() {
	return department_id;
}

public void setDepartment_id(int department_id) {
	this.department_id = department_id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Set<Post> getPostSet() {
	return postSet;
}

public void setPostSet(Set<Post> postSet) {
	this.postSet = postSet;
}






}
