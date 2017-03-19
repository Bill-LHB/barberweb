package com.lhb.barber.dao;

import java.util.Date;
import java.util.List;

import com.lhb.barber.model.Order;
import com.lhb.barber.util.PagerUtil;

public interface OrderDao {
	 void addOrder(Order order);// 添加订单

	 void deleteOrder(Order order);// 删除订单

	 void updateOrder(Order order);// 更新订单

	 List<Order> getAllOrder(PagerUtil pager);// 获取所有订单
	 
	 List<Order> getAllOrder();// 获取所有订单
	 
	 Order getOrderById(int id);// 通过Id获取订单
	 
	 List<Order> getOrderByDate(Date oldDate,Date newDate ,PagerUtil pager);// 通过时间段获取订单
}
