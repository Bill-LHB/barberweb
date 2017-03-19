package com.lhb.barber.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lhb.barber.model.MessageBean;


@Controller
@RequestMapping("/dispatcher")
public class DispatcherAction {
	@Autowired
	private SystemAction systemAction;
	@RequestMapping(value = "", method ={RequestMethod.POST})
    @ResponseBody
    public <T> String operation(@RequestBody MessageBean messageBean)
            throws Exception{
		String operation=messageBean.getOperation();
		String result="";
		switch(operation){
		case "addrole":
			
			
			break;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
    
        return result;
    }
}
