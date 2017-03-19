package com.lhb.barber.server;

import java.util.Date;
import java.util.List;

import com.lhb.barber.model.Order;
import com.lhb.barber.util.PagerUtil;

public interface OrderServer {
	boolean addOrder(Order order);// 添加订单

	boolean deleteOrder(Order order);// 删除订单

	boolean updateOrder(Order order);// 更新订单

	List<Order> getAllOrder(int curPage);// 获取所有订单
	 
	List<Order> getOrderByDate(int curPage,Date oldDate,Date newDate );// 通过时间段获取订单
}
