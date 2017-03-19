package com.lhb.barber;

import org.osgi.service.component.annotations.Component;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
@Component
public class MyApplicationContext implements ApplicationContextAware {
	private static ApplicationContext context;
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		// TODO Auto-generated method stub
		MyApplicationContext.context=context;
	}
	public static <T> T getBeanByApplicationContext(Class<T> name){
		T result =null;
		if(context.getBean(name)!=null){
			result=(T) context.getBean(name);
		}
		return result;
	}
	
	public static Object getBeanByApplicationContext(String name){
		Object result =null;
		if(context.getBean(name)!=null){
			result= context.getBean(name);
		}
		return result;
	}
}
