package com.lhb.barber.dao;

import java.util.List;

import com.lhb.barber.model.User;
import com.lhb.barber.util.PagerUtil;

public interface UserDao {

	void addUser(User user);// 添加用户

	void deleteUser(User user);// 删除用户

	void updateUser(User user);// 更新用户
	
	User getUserById(int id);// 通过Id获取用户

	User getUserByNameAndPassword(String name, String password);// 通过用户名及密码获取用户

	List<User> getUserByName(String name, PagerUtil pager);// 分页通过用户名获取用户

	List<User> getAllUser();// 获取所有用户
	
	Integer getAllUserAmount();//获取所有用户条目数

	List<User> getAllUser(PagerUtil pager);// 分页获取所有用户

}
