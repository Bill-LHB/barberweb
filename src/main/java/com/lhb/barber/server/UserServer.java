package com.lhb.barber.server;

import java.util.List;

import com.lhb.barber.model.User;

public interface UserServer {
	User checkUser(String name, String password);// 获取登陆用户信息

	User getUserById(int id);// 通过Id获取用户

	boolean addUser(User user);// 添加用户

	boolean deleteUser(User user);// 删除用户

	boolean updateUser(User user);// 更新用户

	List<User> getAllUser(int curPage);// 获取所有用户

	List<User> getAllUser();// 获取所有用户

	/*List<User> getUserByMessage(int curPage, String message);// 通过用户信息获取用户
*/
	
	
	
}
