package com.lhb.barber.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome")
public class Welcome {
	@RequestMapping(value ="")
	public String init(){	
		return "welcome";		
	}
	@RequestMapping(value ="/login")
	public String loginout(){	
		return "user/login";		
	}
	@RequestMapping(value ="/main")
	public String main(){	
		return "main";
		
	}
}
