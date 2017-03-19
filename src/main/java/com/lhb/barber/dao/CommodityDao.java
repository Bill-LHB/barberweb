
package com.lhb.barber.dao;

import java.util.List;

import com.lhb.barber.model.Commodity;
import com.lhb.barber.util.PagerUtil;

public interface CommodityDao {
	void addCommodity(Commodity commodity);// 添加商品

	void deleteCommodity(Commodity commodity);// 删除商品

	void updateCommodity(Commodity commodity);// 更新商品

	List<Commodity> getCommodityByName(String c_name, PagerUtil pager);// 通过商品名获取职位

	List<Commodity> getCommodityByNumber(String c_number, PagerUtil pager);// 通过商品编号获取职位

	List<Commodity> getAllCommodity(PagerUtil pager);// 获取所有商品

	List<Commodity> getAllCommodity();// 获取所有商品
	
	Integer getAllCommodityAmount();//获取所有用户条目数
	
	Commodity getCommodityById(int id);// 通过Id获取商品

}
