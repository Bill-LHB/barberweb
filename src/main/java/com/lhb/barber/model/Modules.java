package com.lhb.barber.model;

import java.util.Set;

import javax.persistence.Entity;

/**
 * 模块bean
 * @author Administrator
 *
 */
@Entity
public class Modules {
private int modules_id;//模块ID
private String name;//模块名
private String description;//模块描述
private Set<Function> functionSet;//功能
public Modules() {
	
}
public Modules(int modules_id, String name) {
	
	this.modules_id = modules_id;
	this.name = name;
}
public Modules(String name) {

	this.name = name;
}
public int getModules_id() {
	return modules_id;
}
public void setModules_id(int modules_id) {
	this.modules_id = modules_id;
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


public Set<Function> getFunctionSet() {
	return functionSet;
}
public void setFunctionSet(Set<Function> functionSet) {
	this.functionSet = functionSet;
}
@Override
public String toString() {
	return "Modules [modules_id=" + modules_id + ", name=" + name + ", description=" + description + 
			 "]";
}


}
