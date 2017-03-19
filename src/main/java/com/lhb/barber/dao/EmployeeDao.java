

package com.lhb.barber.dao;

import java.util.List;

import com.lhb.barber.model.Employee;
import com.lhb.barber.model.Post;
import com.lhb.barber.util.PagerUtil;

public interface EmployeeDao {
	void addEmployee(Employee employee);// 添加员工

	void deleteEmployee(Employee employee);// 删除员工

	void updateEmployee(Employee employee);// 更新员工

	List<Employee> getEmployeeByNumber(String e_number, PagerUtil pager);// 通过员工编号获取员工
	
	List<Employee> getEmployeeByPhone(String Employee_phone, PagerUtil pager);// 通过员工编号获取员工

	List<Employee> getEmployeeByIdentity(String e_identity, PagerUtil pager);// 通过员工身份证获取员工

	List<Employee> getEmployeeByName(String e_name, PagerUtil pager);// 通过员工姓名获取员工

	List<Employee> getAllEmployee(PagerUtil pager);// 获取所有员工
	
	List<Employee> getAllEmployee();// 获取所有员工
	
	Integer getAllEmployeeAmount();//获取所有员工条目数

	Employee getEmployeeById(int id);// 通过Id获取员工

	List<Employee> getEmployeeByMessage(String message, PagerUtil pager);// 通过员工信息获取员工
	
}
