
package com.lhb.barber.daoImpl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lhb.barber.MyHibernateDaoSupport;
import com.lhb.barber.dao.OrderDao;
import com.lhb.barber.model.Order;
import com.lhb.barber.model.User;
import com.lhb.barber.util.PagerUtil;

@Repository("orderDao")
public class OrderDaoImpl extends MyHibernateDaoSupport implements OrderDao {

	@Override
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(order);
	}

	@Override
	public void deleteOrder(Order order) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(order);
	}

	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		Order o=getOrderById(order.getOrder_id());
		o.setCommoditySet(order.getCommoditySet());
		o.setDescription(order.getDescription());
		o.setMember(order.getMember());
		o.setOrder_cash(order.getOrder_cash());
		o.setOrder_Date(order.getOrder_Date());
		o.setOrder_id(order.getOrder_id());
		o.setOrder_money(order.getOrder_money());
		o.setUser(order.getUser());	
		getHibernateTemplate().update(o);
	}



	@Override
	public List<Order> getAllOrder(PagerUtil pager) {
		// TODO Auto-generated method stub
		String hql = "from Order";
		return getListByPage(hql,pager);
	}

	@Override
	public Order getOrderById(int id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Order.class, id);
	}

	@Override
	public List<Order> getOrderByDate(Date oldDate, Date newDate, PagerUtil pager) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		String hql = "from Order";
		return (List<Order>) getHibernateTemplate().find(hql);
	}

}
