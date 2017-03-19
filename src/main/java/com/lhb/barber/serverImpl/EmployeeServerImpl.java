package com.lhb.barber.serverImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lhb.barber.dao.EmployeeDao;
import com.lhb.barber.dao.SystemDao;
import com.lhb.barber.model.Employee;
import com.lhb.barber.server.EmployeeServer;
import com.lhb.barber.util.PagerUtil;

@Service("employeeServer")
@Transactional
public class EmployeeServerImpl  implements EmployeeServer {

	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private SystemDao systemDao;
	
	@Override
	public boolean addEmployee(Employee employee) {
		PagerUtil pager =new PagerUtil();
		// TODO Auto-generated method stub
		pager.setCurPage(1);
		if(employeeDao.getEmployeeByIdentity(employee.getEmployee_identity(), pager)!=null){
			return false;
		}
		if(employeeDao.getEmployeeByPhone(employee.getEmployee_phone(), pager)!=null){
			return false;
		}
		employeeDao.addEmployee(employee);
		return true;
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		PagerUtil pager =new PagerUtil();
		// TODO Auto-generated method stub
		pager.setCurPage(1);
		if(employeeDao.getEmployeeById(employee.getEmployee_id())==null){
			return false;
		}
		employeeDao.deleteEmployee(employee);
		return true;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		PagerUtil pager =new PagerUtil();
		// TODO Auto-generated method stub	
		pager.setCurPage(1);
		if(employeeDao.getEmployeeById(employee.getEmployee_id())==null){
			return false;
		}
		employeeDao.updateEmployee(employee);
		return true;
	}

	@Override
	public List<Employee> getEmployeeByMessage(int curPage,String message) {
		// TODO Auto-generated method stub
		PagerUtil pager =new PagerUtil();
		pager.setCurPage(curPage);
		return employeeDao.getEmployeeByMessage(message, pager);
	}

	@Override
	public List<Employee> getAllEmployee(int curPage) {
		// TODO Auto-generated method stub
		PagerUtil pager =new PagerUtil();
		pager.setCurPage(curPage);
		return employeeDao.getAllEmployee(pager);
	}

	@Override
	public Employee getEmployeeById(int Employee_id) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeeById(Employee_id);
	}
}
