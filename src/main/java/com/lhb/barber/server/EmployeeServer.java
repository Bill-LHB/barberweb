package com.lhb.barber.server;

import java.util.List;

import com.lhb.barber.model.Employee;
import com.lhb.barber.util.PagerUtil;

public interface EmployeeServer {
	boolean addEmployee(Employee employee);//添加员工
	
	boolean deleteEmployee(Employee employee);// 删除员工

	boolean updateEmployee(Employee employee);// 更新员工

	List<Employee> getEmployeeByMessage(int curPage,String message);// 通过员工信息获取员工
	Employee getEmployeeById(int Employee_id);// 通过员工ID获取员工

	List<Employee> getAllEmployee(int curPage);// 获取所有员工
	
	

}
