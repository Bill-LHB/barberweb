package com.lhb.barber.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lhb.barber.MyHibernateDaoSupport;
import com.lhb.barber.dao.SystemDao;
import com.lhb.barber.dao.UserDao;
import com.lhb.barber.model.Role;
import com.lhb.barber.model.User;
import com.lhb.barber.util.PagerUtil;

@Repository("userDao")
public class UserDaoImpl extends MyHibernateDaoSupport implements UserDao {
	@Override
	public User getUserByNameAndPassword(String name, String password) {
		// TODO Auto-generated method stub
		User user=null;
		String hql = "from User u where u.user_name =? and u.password =?";
		// find("from Person p where p.name like ?" , name);
		List<User> list=(List<User>) getHibernateTemplate().find(hql, name, password);
		if(list!=null &&list.size()>0){
			user=list.get(0);
		}
		return  user;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(user);
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		User u=getUserById(user.getUser_id());
		u.setDescription(user.getDescription());
		u.setOrderSet(user.getOrderSet());
		u.setPassword(user.getPassword());
		u.setRole(user.getRole());
		u.setState(user.getState());
		u.setUser_id(user.getState());
		u.setUser_name(user.getUser_name());	
		getHibernateTemplate().update(u);
	}

	@Override
	public List<User> getUserByName(String name, PagerUtil pager) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.user_name =?";
		return getListByPage(hql,pager,name);
	}

	@Override
	public List<User> getAllUser(PagerUtil pager) {
		// TODO Auto-generated method stub
		String hql = "from User";
		return getListByPage(hql,pager);
	}
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		String hql = "from User";
		return (List<User>) getHibernateTemplate().find(hql);
	}
	@Override
	public Integer getAllUserAmount() {
		// TODO Auto-generated method stub
		String hql = "from User";
		return getCount(hql);
	}
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		String hql = "from User u where u.user_id =?";
		return getHibernateTemplate().get(User.class, id);
	}	
}
