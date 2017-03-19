

package com.lhb.barber.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lhb.barber.MyHibernateDaoSupport;
import com.lhb.barber.dao.EmployeeDao;
import com.lhb.barber.model.Employee;
import com.lhb.barber.model.User;
import com.lhb.barber.util.PagerUtil;

@Repository("employeeDao")
public class EmployeeDaoImpl extends MyHibernateDaoSupport implements EmployeeDao {

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(employee);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee e=getEmployeeById(employee.getEmployee_id());
		e.setCommoditySet(employee.getCommoditySet());
		e.setDescription(employee.getDescription());
		e.setEmployee_age(employee.getEmployee_age());
		e.setEmployee_birth(employee.getEmployee_birth());
		e.setEmployee_card(employee.getEmployee_card());
		e.setEmployee_entry(employee.getEmployee_entry());
		e.setHeadurl(employee.getHeadurl());
		e.setEmployee_id(employee.getEmployee_id());
		e.setEmployee_identity(employee.getEmployee_identity());
		e.setEmployee_name(employee.getEmployee_name());
		e.setEmployee_number(employee.getEmployee_number());
		e.setEmployee_phone(employee.getEmployee_phone());
		e.setEmployee_post(employee.getEmployee_post());
		e.setEmployee_sex(employee.getEmployee_sex());
		e.setEmployeeStatus(employee.getEmployeeStatus());
		getHibernateTemplate().update(e);
	}

	@Override
	public List<Employee> getEmployeeByNumber(String e_number, PagerUtil pager) {
		// TODO Auto-generated method stub
		String hql = "from Employee e where e.Employee_number =?";
		return getListByPage(hql,pager,e_number);
	}

	@Override
	public List<Employee> getEmployeeByIdentity(String e_identity, PagerUtil pager) {
		// TODO Auto-generated method stub
		String hql = "from Employee e where e.Employee_identity =?";
		return getListByPage(hql,pager,e_identity);
	}

	@Override
	public List<Employee> getEmployeeByName(String e_name, PagerUtil pager) {
		// TODO Auto-generated method stub
		String hql = "from Employee e where e.Employee_name =?";
		return getListByPage(hql,pager,e_name);
	}

	@Override
	public List<Employee> getAllEmployee(PagerUtil pager) {
		// TODO Auto-generated method stub
		String hql = "from Employee";		
		List list=super.getListByPage(hql,pager);
		
		
		
		return getListByPage(hql,pager);
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Employee.class, id);
	}

	@Override
	public List<Employee> getEmployeeByMessage(String message, PagerUtil pager) {
		// TODO Auto-generated method stub
		String hql = "from Employee e where e.Employee_name =? or Employee_identity=? or Employee_phone=?";
		return getListByPage(hql,pager,message,message,message);
	}
	@Override
	public List<Employee> getEmployeeByPhone(String Employee_phone, PagerUtil pager) {
		// TODO Auto-generated method stub
		String hql = "from Employee e where e.Employee_phone =?";
		return getListByPage(hql,pager,Employee_phone);
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		String hql = "from Employee";
		return (List<Employee>) getHibernateTemplate().find(hql);
	}

	@Override
	public Integer getAllEmployeeAmount() {
		// TODO Auto-generated method stub
		String hql = "from Employee";
		return getCount(hql);
	}


}
