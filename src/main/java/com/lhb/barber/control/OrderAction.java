package com.lhb.barber.control;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lhb.barber.model.Order;
@Controller
@RequestMapping("/order")
public class OrderAction {
	/**
	 * 添加订单
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/addorder",method=RequestMethod.POST)
	public String addOrder(Order order,Model model){	
		return null;	
	}
	
	/**
	 * 删除订单
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/deletorder",method=RequestMethod.POST)
	public String deleteOrder(Order order,Model model){		
		return null;	
	}
	
	/**
	 * 更新订单
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/updatorder",method=RequestMethod.POST)
	public String updateOrder(Order order,Model model){	
		return null;	
	}
}
