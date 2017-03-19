
package com.lhb.barber.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
/**
 * 订单bean类
 * @author Administrator
 *
 */
@Entity
public class Order {
	private int Order_id;
	private Date Order_Date;//订单时间
	private String Order_money;//订单金额
	private String Order_cash;//现金支付
	private Member member;//会员支付
	private User user;//操作员
	private String description;//订单描述
	
	private Set<Commodity> commoditySet;//产品服务
	private Set<Employee> employeeSet;//员工	

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Order(int order_id, Date order_Date, String order_money, String order_cash) {
		super();
		Order_id = order_id;
		Order_Date = order_Date;
		Order_money = order_money;
		Order_cash = order_cash;
	}
	public Order() {
		super();
	}
	public Order(Date order_Date, String order_money, String order_cash) {
		super();
		Order_Date = order_Date;
		Order_money = order_money;
		Order_cash = order_cash;
	}
	public int getOrder_id() {
		return Order_id;
	}
	public void setOrder_id(int order_id) {
		Order_id = order_id;
	}
	public Date getOrder_Date() {
		return Order_Date;
	}
	public void setOrder_Date(Date order_Date) {
		Order_Date = order_Date;
	}
	public String getOrder_money() {
		return Order_money;
	}
	public void setOrder_money(String order_money) {
		Order_money = order_money;
	}
	public String getOrder_cash() {
		return Order_cash;
	}
	public void setOrder_cash(String order_cash) {
		Order_cash = order_cash;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<Commodity> getCommoditySet() {
		return commoditySet;
	}
	public void setCommoditySet(Set<Commodity> commoditySet) {
		this.commoditySet = commoditySet;
	}
	public Set<Employee> getEmployeeSet() {
		return employeeSet;
	}
	public void setEmployeeSet(Set<Employee> employeeSet) {
		this.employeeSet = employeeSet;
	}


	
}
