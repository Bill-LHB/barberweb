
package com.lhb.barber.model;

import java.util.Set;

import javax.persistence.Entity;

/**
 * 用户
 * @author Administrator
 *
 */
@Entity
public class User {
private int user_id;//用户ID
private String user_name;//用户名
private String password;//用户密码

private Role role;//用户角色
private String description;//用户描述
private int state;//用户状态 0:待审核 1：审核通过
private Set<Order> orderSet;//订单

public User(int user_id, String user_name, String password) {
	super();
	this.user_id = user_id;
	this.user_name = user_name;
	this.password = password;
}
public User() {
	super();
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
public Set<Order> getOrderSet() {
	return orderSet;
}
public void setOrderSet(Set<Order> orderSet) {
	this.orderSet = orderSet;
}


}
