package com.lhb.barber.serverImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lhb.barber.dao.SystemDao;
import com.lhb.barber.dao.UserDao;
import com.lhb.barber.model.User;
import com.lhb.barber.server.UserServer;
import com.lhb.barber.util.PagerUtil;

@Service("userServer")
@Transactional
public class UserServerImpl implements UserServer {
	@Autowired
	private UserDao userDao;
	@Autowired
	private SystemDao systemDao;

	@Override
	public User checkUser(String name, String password) {
		// TODO Auto-generated method stub
		User user = userDao.getUserByNameAndPassword(name, password);
		return user;
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.getUserById(id);
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		PagerUtil pager = new PagerUtil();
		pager.setCurPage(1);
		if (userDao.getUserByName(user.getUser_name(), pager) != null) {
			return false;
		}

		userDao.addUser(user);
		return true;
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		PagerUtil pager = new PagerUtil();
		pager.setCurPage(1);
		if (userDao.getUserByName(user.getUser_name(), pager) == null) {
			return false;
		}
		userDao.deleteUser(user);
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		PagerUtil pager = new PagerUtil();
		pager.setCurPage(1);
		if (userDao.getUserByName(user.getUser_name(), pager) == null) {
			return false;
		}
		userDao.updateUser(user);
		return true;
	}

	@Override
	public List<User> getAllUser(int curPage) {
		// TODO Auto-generated method stub
		PagerUtil pager = new PagerUtil();
		pager.setCurPage(curPage);
		return userDao.getAllUser(pager);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userDao.getAllUser();
	}

}
