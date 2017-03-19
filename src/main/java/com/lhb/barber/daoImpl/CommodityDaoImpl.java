package com.lhb.barber.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lhb.barber.MyHibernateDaoSupport;
import com.lhb.barber.dao.CommodityDao;
import com.lhb.barber.model.Commodity;
import com.lhb.barber.model.User;
import com.lhb.barber.util.PagerUtil;

@Repository("commodityDao")
public class CommodityDaoImpl extends MyHibernateDaoSupport implements CommodityDao {

	@Override
	public void addCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(commodity);
	}

	@Override
	public void deleteCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(commodity);
	}

	@Override
	public void updateCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		Commodity c=getCommodityById(commodity.getCommodity_id());
		c.setCommodity_category(commodity.getCommodity_category());
		c.setCommodity_commission(commodity.getCommodity_commission());
		c.setCommodity_id(commodity.getCommodity_id());
		c.setCommodity_mindiscount(commodity.getCommodity_mindiscount());
		c.setCommodity_name(commodity.getCommodity_name());
		c.setCommodity_number(commodity.getCommodity_number());
		c.setCommodity_purchase(commodity.getCommodity_purchase());
		c.setCommodity_quantity(commodity.getCommodity_quantity());
		c.setCommodity_ratio(commodity.getCommodity_ratio());
		c.setCommodity_selling(commodity.getCommodity_selling());
		c.setDescription(commodity.getDescription());
		c.setEmployeeSet(commodity.getEmployeeSet());
		c.setOrderSet(commodity.getOrderSet());
		getHibernateTemplate().update(c);
	}

	@Override
	public List<Commodity> getCommodityByName(String c_name, PagerUtil pager) {
		// TODO Auto-generated method stub
		String hql = "from Commodity c where c.Commodity_name =?";
		return getListByPage(hql,pager,c_name);
	}

	@Override
	public List<Commodity> getCommodityByNumber(String c_number, PagerUtil pager) {
		// TODO Auto-generated method stub
		String hql = "from Commodity c where c.Commodity_number =?";
		return getListByPage(hql,pager,c_number);
	}

	@Override
	public List<Commodity> getAllCommodity(PagerUtil pager) {
		// TODO Auto-generated method stub
		String hql = "from Commodity";
		return getListByPage(hql,pager);
	}

	@Override
	public Commodity getCommodityById(int id) {
		return getHibernateTemplate().get(Commodity.class, id);
	}

	@Override
	public List<Commodity> getAllCommodity() {
		// TODO Auto-generated method stub
		String hql = "from Commodity";
		return (List<Commodity>) getHibernateTemplate().find(hql);
	}

	@Override
	public Integer getAllCommodityAmount() {
		// TODO Auto-generated method stub
		String hql = "from Commodity";
		return getCount(hql);
	}

}
