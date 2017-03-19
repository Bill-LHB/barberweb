package com.lhb.barber.serverImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lhb.barber.dao.OrderDao;
import com.lhb.barber.dao.SystemDao;
import com.lhb.barber.model.Order;
import com.lhb.barber.server.OrderServer;
import com.lhb.barber.util.PagerUtil;

@Service("orderServer")
@Transactional
public class OrderServerImpl  implements OrderServer {
	
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private SystemDao systemDao;
	
	private PagerUtil pager  =new PagerUtil();
	
	
	@Override
	public boolean addOrder(Order order) {
		// TODO Auto-generated method stub
		pager.setCurPage(1);
		orderDao.addOrder(order);
		return true;
	}

	@Override
	public boolean deleteOrder(Order order) {
		// TODO Auto-generated method stub
		pager.setCurPage(1);
		if(orderDao.getOrderById(order.getOrder_id())==null){
			return false;	
		}
		orderDao.deleteOrder(order);
		return true;
	}

	@Override
	public boolean updateOrder(Order order) {
		// TODO Auto-generated method stub
		pager.setCurPage(1);
		if(orderDao.getOrderById(order.getOrder_id())==null){
			return false;	
		}
		orderDao.updateOrder(order);
		return true;
	}

	@Override
	public List<Order> getAllOrder(int curPage) {
		// TODO Auto-generated method stub
		pager.setCurPage(curPage);
		return orderDao.getAllOrder(pager);
	}


	@Override
	public List<Order> getOrderByDate(int curPage,Date oldDate, Date newDate) {
		// TODO Auto-generated method stub
		pager.setCurPage(curPage);
		return orderDao.getOrderByDate(oldDate, newDate, pager);
	}


}
