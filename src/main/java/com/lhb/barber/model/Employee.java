package com.lhb.barber.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
@Entity
public class Employee {
	private int employee_id;
	private String employee_name;//员工姓名
	private String employee_number;//员工编号
	private String headurl;//员工头像
	private String employee_identity;//员工身份证号
	private String employee_phone;//员工电话
	private String employee_sex;//员工性别
	private String employee_age;//员工年龄
	private Date employee_birth;//员工出生日期
	
	private Date employee_entry;//员工入职日期
	
	private String employee_card;//员工工资卡
	private String description;//备注
	private Post employee_post;//员工职位
	private int employeeStatus;//员工状态 0：离职  1：在职

	private Set<Commodity> commoditySet;//产品
	private Set<Order> orderSet;//订单

	public Employee(int employee_id, String employee_name, String employee_number, String headurl,
			String employee_identity, String employee_phone, String employee_sex, String employee_age, Date employee_birth,
			Date employee_entry) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.employee_number = employee_number;
		this.headurl = headurl;
		this.employee_identity = employee_identity;
		this.employee_phone = employee_phone;
		this.employee_sex = employee_sex;
		this.employee_age = employee_age;
		this.employee_birth = employee_birth;
		this.employee_entry = employee_entry;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", employee_name=" + employee_name + ", employee_number="
				+ employee_number + ", headurl=" + headurl + ", employee_identity="
				+ employee_identity + ", employee_phone=" + employee_phone + ", employee_sex=" + employee_sex + ", employee_age="
				+ employee_age + ", employee_birth=" + employee_birth + ", employee_entry=" + employee_entry + "]";
	}

	public Employee() {
		super();
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmployee_number() {
		return employee_number;
	}

	public void setEmployee_number(String employee_number) {
		this.employee_number = employee_number;
	}

	public String getHeadurl() {
		return headurl;
	}

	public void setHeadurl(String employee_headurl) {
		this.headurl = employee_headurl;
	}

	public String getEmployee_identity() {
		return employee_identity;
	}

	public void setEmployee_identity(String employee_identity) {
		this.employee_identity = employee_identity;
	}

	public String getEmployee_phone() {
		return employee_phone;
	}

	public void setEmployee_phone(String employee_phone) {
		this.employee_phone = employee_phone;
	}

	public String getEmployee_sex() {
		return employee_sex;
	}

	public void setEmployee_sex(String employee_sex) {
		this.employee_sex = employee_sex;
	}

	public String getEmployee_age() {
		return employee_age;
	}

	public void setEmployee_age(String employee_age) {
		this.employee_age = employee_age;
	}

	public Date getEmployee_birth() {
		return employee_birth;
	}

	public void setEmployee_birth(Date employee_birth) {
		this.employee_birth = employee_birth;
	}

	public Date getEmployee_entry() {
		return employee_entry;
	}

	public void setEmployee_entry(Date employee_entry) {
		this.employee_entry = employee_entry;
	}

	public String getEmployee_card() {
		return employee_card;
	}

	public void setEmployee_card(String employee_card) {
		this.employee_card = employee_card;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public int getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(int employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public Set<Order> getOrderSet() {
		return orderSet;
	}

	public void setOrderSet(Set<Order> orderSet) {
		this.orderSet = orderSet;
	}

	public Post getEmployee_post() {
		return employee_post;
	}

	public void setEmployee_post(Post employee_post) {
		this.employee_post = employee_post;
	}

	public Set<Commodity> getCommoditySet() {
		return commoditySet;
	}

	public void setCommoditySet(Set<Commodity> commoditySet) {
		this.commoditySet = commoditySet;
	}




	


	
}
