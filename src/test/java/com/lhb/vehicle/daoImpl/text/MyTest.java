package com.lhb.vehicle.daoImpl.text;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lhb.barber.dao.CommodityDao;
import com.lhb.barber.dao.EmployeeDao;
import com.lhb.barber.dao.MemberDao;
import com.lhb.barber.dao.OrderDao;
import com.lhb.barber.dao.SystemDao;
import com.lhb.barber.dao.UserDao;
import com.lhb.barber.model.Department;
import com.lhb.barber.model.Post;

@Service
@Transactional(readOnly=false)
public class MyTest {
	
	private  UserDao userDao;
	private CommodityDao commodityDao;
	private EmployeeDao employeeDao;
	private MemberDao memberDao;
	private OrderDao orderDao;
	private SystemDao systemDao;
	@Before
	public void a(){
		ApplicationContext c=new ClassPathXmlApplicationContext("appcontext.xml");
		userDao=(UserDao) c.getBean("userDao");	
		commodityDao=(CommodityDao) c.getBean("commodityDao");
		employeeDao=(EmployeeDao) c.getBean("employeeDao");	
		memberDao=(MemberDao) c.getBean("memberDao");
		orderDao=(OrderDao) c.getBean("orderDao");
		systemDao=(SystemDao) c.getBean("systemDao");
	}
	
	@Test
	public void test() {
		Post p=new Post("sad","sad");
		Department department=new Department("kaifa ");
		systemDao.addDepartment(department);
		
		Department d=systemDao.getDepartmentByName("kaifa").get(0);
		p.setDepartment(d);
		systemDao.addPost(p);
		Department s=systemDao.getPostByName("sad").get(0).getDepartment();
		
		System.out.println(s+"##############");
		/*String name="qq";
		String password="123456";
		User user=new User(name,password);
		userDao.getUserById(1);
		//userDao.addUser(user);
		functionDao.getFunctionById(1);
		modulesDao.getModulesById(1);
		roleDao.getRoleById(1);*/
		/*Order order=new Order();
		orderDao.addOrder(order);*/
	}

}
