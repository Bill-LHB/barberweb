package com.lhb.barber.model;

import java.util.Set;

import javax.persistence.Entity;

/**
 * 角色
 * @author Administrator
 *
 */
@Entity
public class Role {
private int role_id;//角色ID
private String name;//角色名
private String description;//角色描述
private Set<User> userSet;//用户
private Set<Function> functionSet;//功能
public Role() {

}

public Role(String name) {
	
	this.name = name;
}

public Role(int role_id, String name) {

	this.role_id = role_id;
	this.name = name;
}
public int getRole_id() {
	return role_id;
}
public void setRole_id(int role_id) {
	this.role_id = role_id;
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



public Set<User> getUserSet() {
	return userSet;
}

public void setUserSet(Set<User> userSet) {
	this.userSet = userSet;
}

public Set<Function> getFunctionSet() {
	return functionSet;
}

public void setFunctionSet(Set<Function> functionSet) {
	this.functionSet = functionSet;
}

@Override
public String toString() {
	return "Role [role_id=" + role_id + ", name=" + name + ", description=" + description + "]";
}


}
