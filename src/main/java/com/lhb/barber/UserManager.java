package com.lhb.barber;

import java.util.Set;

import com.lhb.barber.dao.UserDao;
import com.lhb.barber.model.Function;
import com.lhb.barber.model.Role;
import com.lhb.barber.model.User;

public class UserManager  {
	private static UserDao userDao;
	
	private static UserManager UMG = null;
	public static UserManager getInstance(){
		if(UMG==null){
			UMG = new UserManager();
			initUserManager();
		}
		return UMG;
	}
	
	public  boolean getGroupPermission(User presentUser, String action) {
		boolean results = false;
		User user = (User) userDao.getUserById(presentUser.getUser_id());
		Role role = user.getRole();
		
		Set<Function> functionList = role.getFunctionSet();
		for(Function fuction : functionList){
			if(fuction.getFunction_code().equals(action)){
				results = true;
				break;
			}
		}

		return results;
	}
	public static void initUserManager(){
		//userDao =(UserDao) MyApplicationContext.getBeanByApplicationContext("userDao");
		userDao =MyApplicationContext.getBeanByApplicationContext(UserDao.class);
		
	}

}
