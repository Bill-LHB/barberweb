package com.lhb.barber.model;

import java.util.Set;

import javax.persistence.Entity;
/**
 * 功能bean
 * @author Administrator
 *
 */
@Entity
public class Function{
private int function_id;//功能ID
private String function_code;//功能编码
private String description;//功能描述
private String name;//功能名称
private Modules modules;//模块
private Set<Role> roleSet;//权限
public Function() {
}
public Function(int function_id, String name) {
	
	this.function_id = function_id;
	this.name = name;
}
public Function(String name) {
	
	this.name = name;
}
public int getFunction_id() {
	return function_id;
}
public void setFunction_id(int function_id) {
	this.function_id = function_id;
}
public String getFunction_code() {
	return function_code;
}
public void setFunction_code(String function_code) {
	this.function_code = function_code;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Modules getModules() {
	return modules;
}



public Set<Role> getRoleSet() {
	return roleSet;
}
public void setRoleSet(Set<Role> roleSet) {
	this.roleSet = roleSet;
}
public void setModules(Modules modules) {
	this.modules = modules;
}
@Override
public String toString() {
	return "Function [function_id=" + function_id + ", function_code=" + function_code + ", description=" + description
			+ ", name=" + name + ", modules=" + modules +  "]";
}



}
