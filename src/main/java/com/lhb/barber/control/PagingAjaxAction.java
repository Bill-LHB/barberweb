package com.lhb.barber.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.lhb.barber.model.Modules;
import com.lhb.barber.server.SystemServer;
import com.lhb.barber.util.PagerUtil;
/** 
 * 列表分页控制器 
 * @author 
 * @date 
 */  
@Controller  
@RequestMapping
public class PagingAjaxAction {
	
	  
	
	
	@Autowired
	private SystemServer systemServer;
	
	
	
	 /** 
     * 
     * @param  
     * @param request 
     * @param model 
     * @return 
	 * @throws Exception 
     */  
    @RequestMapping(value="/page")  
     public void page(HttpServletRequest request,HttpServletResponse response) throws Exception{	  
    	Map<String, Object> resMap = new HashMap<String, Object>();  	
    	String handle=request.getParameter("handle");
    	Integer pcount=0;
		Integer pageIndex=Integer.valueOf(request.getParameter("pageIndex"));
		Integer pageSize=Integer.valueOf(request.getParameter("pageSize"));
		List pageList=null;
		switch(handle){
			case "modules":	
				pcount=systemServer.getAllModulesAmount();			
				pageList=getModulesByPage(pcount,pageIndex,pageSize);
				break;
			case "function":
				pcount=systemServer.getAllFunctionAmount();
				pageList=getModulesByPage(pcount,pageIndex,pageSize);
				break;
		}
		
		
		
		
		 List<Map> pageMap=getFieldVlaueList(pageList);
		
		 
    

		response.setContentType("text/html;charset=UTF-8");//指定响应内容类型，避免<pre...
		try {
			 PrintWriter out = response.getWriter(); 
			 resMap.put("pageMap", pageMap);
				resMap.put("pcount", pcount);
				Gson gson = new Gson(); 
		        String gsonStr = gson.toJson(resMap);
		        System.out.println("gsonStr"+gsonStr+"!!!!!!!!!!!!!!!!1");
	         out.write(gsonStr);  
	         out.flush(); 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    }  
   
    
    
    private List<Modules> getModulesByPage(Integer iCount,Integer pageIndex,Integer pageSize){
    	return systemServer.getAllModulesByPager(getPager(iCount, pageIndex, pageSize)); 	
    }
 
    /**
     * 获取PagerUtil对象
     * @param iCount
     * @param pageIndex
     * @param pageSize
     * @return
     */
    private PagerUtil getPager(Integer iCount,Integer pageIndex,Integer pageSize){
    	PagerUtil pager=new PagerUtil();
    	pager.setICount(iCount);
    	pager.setCurPage(pageIndex);
    	pager.setIStep(pageSize);
    	return pager;
    	
    }

    
    /* 
     * 将object转换为Map，不包含object继承属性 
     */  
    public static Map<String, String> getFieldVlaue(Object obj) throws Exception {    
        Map<String, String> mapValue = new HashMap<String, String>();    
        Class<?> cls = obj.getClass();    
        Field[] fields = cls.getDeclaredFields();    
        for (Field field : fields) {    
            String name = field.getName();    
            String strGet = "get" + name.substring(0, 1).toUpperCase() + name.substring(1, name.length());    
            Method methodGet = cls.getDeclaredMethod(strGet);    
            Object object = methodGet.invoke(obj);    
            String value = object != null ? object.toString() : "";    
            mapValue.put(name, value);    
        }    
        return mapValue;    
    }   
    
    
    /* 
     * 将List<object>转换为List<Map> 
     *   解决可能出现Java.lang.StackOverflowError：
     */  
    public static List<Map> getFieldVlaueList(List<?> objects)throws Exception{        
        List<Map> mapList = new ArrayList<Map>();  
        for(Object obj:objects){  
            mapList.add(getFieldVlaue(obj));  
        }  
          
        return mapList;  
    }  

    
}
