package com.lhb.barber.model;

import java.util.Set;

import javax.persistence.Entity;

@Entity
public class Category {
private int category_id;
private String category_number;//类别编号
private String category_name;//类别名称
private String description;//描述
private Set<Commodity> commoditySet;//商品

public Category(int category_id, String category_number, String category_name) {

	this.category_id = category_id;
	this.category_number = category_number;
	this.category_name = category_name;
}
public Category() {
	
}
@Override
public String toString() {
	return "Category [category_id=" + category_id + ", category_number=" + category_number + ", category_name="
			+ category_name + "]";
}
public int getCategory_id() {
	return category_id;
}
public void setCategory_id(int category_id) {
	this.category_id = category_id;
}
public String getCategory_number() {
	return category_number;
}
public void setCategory_number(String category_number) {
	this.category_number = category_number;
}
public String getCategory_name() {
	return category_name;
}
public void setCategory_name(String category_name) {
	this.category_name = category_name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Set<Commodity> getCommoditySet() {
	return commoditySet;
}
public void setCommoditySet(Set<Commodity> commoditySet) {
	this.commoditySet = commoditySet;
}


}
