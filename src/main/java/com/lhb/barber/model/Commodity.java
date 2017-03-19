
package com.lhb.barber.model;

import java.util.Set;

import javax.persistence.Entity;

@Entity
public class Commodity{
	private int commodity_id;
	private String commodity_number;//产品编号
	private String commodity_name;//产品名称
	private float commodity_purchase;//单品进价
	private int commodity_quantity;//产品数量
	private float commodity_selling;//单品售价
	private float commodity_mindiscount;//最低折扣
	private String commodity_ratio;//提成比例
	private String commodity_commission ;//提成金额
	private Category commodity_category;//产品类别
	
	private String description;//产品描述
	private Set<Employee> employeeSet;//员工	
	private Set<Order> orderSet;//订单
	
	public Commodity(int commodity_id, String commodity_number, String commodity_name, float commodity_purchase,
			int commodity_quantity, float commodity_selling, float commodity_mindiscount, String commodity_ratio,
			String commodity_commission, Category commodity_category) {
		super();
		this.commodity_id = commodity_id;
		this.commodity_number = commodity_number;
		this.commodity_name = commodity_name;
		this.commodity_purchase = commodity_purchase;
		this.commodity_quantity = commodity_quantity;
		this.commodity_selling = commodity_selling;
		this.commodity_mindiscount = commodity_mindiscount;
		this.commodity_ratio = commodity_ratio;
		this.commodity_commission = commodity_commission;
		this.commodity_category = commodity_category;
	}

	public Commodity() {
		super();
	}

	@Override
	public String toString() {
		return "Commodity [commodity_id=" + commodity_id + ", commodity_number=" + commodity_number
				+ ", commodity_name=" + commodity_name + ", commodity_purchase=" + commodity_purchase
				+ ", commodity_quantity=" + commodity_quantity + ", commodity_selling=" + commodity_selling
				+ ", commodity_mindiscount=" + commodity_mindiscount + ", commodity_ratio=" + commodity_ratio
				+ ", commodity_commission=" + commodity_commission + ", commodity_category=" + commodity_category + "]";
	}

	public int getCommodity_id() {
		return commodity_id;
	}

	public void setCommodity_id(int commodity_id) {
		this.commodity_id = commodity_id;
	}

	public String getCommodity_number() {
		return commodity_number;
	}

	public void setCommodity_number(String commodity_number) {
		this.commodity_number = commodity_number;
	}

	public String getCommodity_name() {
		return commodity_name;
	}

	public void setCommodity_name(String commodity_name) {
		this.commodity_name = commodity_name;
	}

	public float getCommodity_purchase() {
		return commodity_purchase;
	}

	public void setCommodity_purchase(float commodity_purchase) {
		this.commodity_purchase = commodity_purchase;
	}

	public int getCommodity_quantity() {
		return commodity_quantity;
	}

	public void setCommodity_quantity(int commodity_quantity) {
		this.commodity_quantity = commodity_quantity;
	}

	public float getCommodity_selling() {
		return commodity_selling;
	}

	public void setCommodity_selling(float commodity_selling) {
		this.commodity_selling = commodity_selling;
	}

	public float getCommodity_mindiscount() {
		return commodity_mindiscount;
	}

	public void setCommodity_mindiscount(float commodity_mindiscount) {
		this.commodity_mindiscount = commodity_mindiscount;
	}

	public String getCommodity_ratio() {
		return commodity_ratio;
	}

	public void setCommodity_ratio(String commodity_ratio) {
		this.commodity_ratio = commodity_ratio;
	}

	public String getCommodity_commission() {
		return commodity_commission;
	}

	public void setCommodity_commission(String commodity_commission) {
		this.commodity_commission = commodity_commission;
	}

	public Category getCommodity_category() {
		return commodity_category;
	}

	public void setCommodity_category(Category commodity_category) {
		this.commodity_category = commodity_category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Employee> getEmployeeSet() {
		return employeeSet;
	}

	public void setEmployeeSet(Set<Employee> employeeSet) {
		this.employeeSet = employeeSet;
	}

	public Set<Order> getOrderSet() {
		return orderSet;
	}

	public void setOrderSet(Set<Order> orderSet) {
		this.orderSet = orderSet;
	}

	

	
}
