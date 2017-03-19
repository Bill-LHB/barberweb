package com.lhb.barber.control;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lhb.barber.model.Category;
import com.lhb.barber.model.Combination;
import com.lhb.barber.model.Commodity;
import com.lhb.barber.model.Department;
import com.lhb.barber.model.Function;
import com.lhb.barber.model.MenmberMode;
import com.lhb.barber.model.Modules;
import com.lhb.barber.model.Post;
import com.lhb.barber.model.Role;
import com.lhb.barber.server.SystemServer;
import com.lhb.barber.util.SetUtil;
@Controller
@RequestMapping("/system")
public class SystemAction {
	@Autowired
	private SystemServer systemServer;
	
	/**
	 * 添加角色
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/addrole")
	public String addRole(Model model){	
		List<Function> allFunctionList=systemServer.getAllFunction();
		List<Function> optFunctionList=null;	
		model.addAttribute("role", null);
		model.addAttribute("operation", "addRole");
		model.addAttribute("allFunctionList", allFunctionList);
		model.addAttribute("optFunctionList", optFunctionList);
		return "system/add_role";	
	}
	/**
	 * 更新角色
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/updaterole/{roleId}",method=RequestMethod.GET)
	public String updateRole(@PathVariable Integer roleId,Model model){			
		Role role=(Role) systemServer.getRoleById(roleId);
		List<Modules> allModulesList=systemServer.getAllModules();
		List<Function> optFunctionList=SetUtil.setToList(role.getFunctionSet());
		
		model.addAttribute("role", role);
		model.addAttribute("operation", "updateRole");
		model.addAttribute("allModulesList", allModulesList);
		model.addAttribute("optFunctionList", optFunctionList);		
		return "system/add_role";	
	}
	/**
	 * 
	 * @param operation
	 * @param role
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/role/operation",method=RequestMethod.POST)
	public String operationRole(String operation,Role role,Model model,Integer[]functionid){
		String message="";
		Set<Function> functionList=new HashSet<>();
		for(int i:functionid){
			functionList.add(systemServer.getFunctionById(i));
		}
		role.setFunctionSet(functionList);					
		if("addRole".equals(operation)){
			if(!systemServer.addRole(role)){				
				message="添加角色失败!";	}else{
					message="";
				}	
		}
		if("updateRole".equals(operation)){		
			if(!systemServer.updateRole(role)){
				message="修改角色失败!";}else{
					message="";
				}
		}			
		model.addAttribute("message", message);		
		return "redirect:/system/allrole.do";			
	}
	/**
	 * 删除角色
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/deleteRole/{roleId}",method=RequestMethod.GET)
	public String deleteRole(@PathVariable Integer roleId,Model model){
		String message="";
		Role role=(Role) systemServer.getRoleById(roleId);
		if(!systemServer.deleteRole(role)){
			message="删除角色失败！";
		}else{
			message="";
		}
		
		systemServer.deleteRole(role);	
		model.addAttribute("modules", message);		
		return "redirect:/system/allrole.do";	
	}
	/**
	 * 所有角色
	 * @param message
	 * @param curPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/allrole")
	public String  getAllRole(String message,Model model){	
		if(message!=null&& !message.equals("")){
			model.addAttribute("message", message);	
		}		
		List<Role> roleList=systemServer.getAllRole();
		model.addAttribute("roleList", roleList);	
		return "system/list_role";		
	}
	
	/**
	 * 添加模块
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/addmodules")
	public String addModules(Model model){	
		model.addAttribute("operation", "addmodules");	
		return "system/add_modules";			
	}
	

	
	/**
	 * 更新模块
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/updatemodules/{modules_id}",method=RequestMethod.GET)
	public String updateModules(@PathVariable Integer modules_id,Model model){	
		Modules modules=(Modules) systemServer.getModulesById(modules_id);
		model.addAttribute("operation", "updatemodules");
		model.addAttribute("modules", modules);		
		return "system/add_modules";	
	}
	
	/**
	 * 
	 * @param operation
	 * @param role
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/modules/operation",method=RequestMethod.POST)
	public String operationModules(String operation,Modules modules,Model model){	
		String message="";			
		if("addmodules".equals(operation)){	
			if(!systemServer.addModules(modules)){				
				message="添加模块失败!";}else{
					message="";
				}			
		}
		if("updatemodules".equals(operation)){		
			if(!systemServer.updateModules(modules)){
				message="修改模块失败";}else{
					message="";
				}	
		}	
		model.addAttribute("message", message);			
		return "redirect:/system/allmodules.do";					
	}
	
	/**
	 * 删除模块
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/deletemodules/{modules_id}",method=RequestMethod.GET)
	public String deleteModules(@PathVariable Integer modules_id,Model model){
		String message="";
		Modules mod=(Modules) systemServer.getModulesById(modules_id);
		if(!systemServer.deleteModules(mod)){
			message="删除模块失败！";
		}else{
			message="";
		}
		systemServer.deleteModules(mod);
		model.addAttribute("message", message);
		model.addAttribute("modules", "");		
		return "redirect:/system/allmodules.do";	
	}
	/**
	 * 所有模块
	 * @param message
	 * @param curPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/allmodules")
	public String  getAllModules(String message,Model model){	
		if(message!=null && !message.equals("")){
			model.addAttribute("message", message);	
		}	
		
		Integer pcount=systemServer.getAllModulesAmount();
		model.addAttribute("pcount", pcount);
		/*List<Modules> modulesList=systemServer.getAllModules();		
		model.addAttribute("modulesList", modulesList);	*/
		return "system/list_modules";		
	}
	
	
	
	/**
	 * 添加功能
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/addfunction")
	public String addFunction(Model model){	
		List<Modules> allModulesList=systemServer.getAllModules();	
		model.addAttribute("function", null);
		model.addAttribute("operation", "addfunction");
		model.addAttribute("allModulesList", allModulesList);	
		return "system/add_function";				
	}
	
	/**
	 * 更新功能
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/updatefunction/{function_id}",method=RequestMethod.GET)
	public String updateFunction(@PathVariable Integer function_id,Model model){	
		Function function=systemServer.getFunctionById(function_id);
		List<Modules> allModulesList=systemServer.getAllModules();	
		model.addAttribute("operation", "updatefunction");
		model.addAttribute("function", function);
		model.addAttribute("allModulesList", allModulesList);	
		return "system/add_function";		
	}
	
	@RequestMapping(value="/fun/operation",method=RequestMethod.POST)
	public String operationFunction(Integer m_id,Function function,Model model,String operation){	
		
	
		
		Modules modules=systemServer.getModulesById(m_id);
		function.setModules(modules);
		
		String message="";			
		if("addfunction".equals(operation)){
			if(!systemServer.addFunction(function))				
				message="添加功能失败!";		
		}else{
			message="";	
		}
		if("updatefunction".equals(operation)){	
			if(!systemServer.updateFunction(function)){			
				message="修改功能失败";
				}else{
					message="";	
				}
		}	
		model.addAttribute("message", message);			
		return "redirect:/system/allfunction.do";
		
	}
	/**
	 * 删除功能
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/deletefunction/{function_id}",method=RequestMethod.GET)
	public String deleteFunction(@PathVariable Integer function_id,Model model){
		Function function=systemServer.getFunctionById(function_id);
		String message="";
		systemServer.deleteFunction(function);
		if(!systemServer.deleteFunction(function)){
			message="删除功能失败！";
		}else{
			message="";
		}
		model.addAttribute("message", message);		
		return "redirect:/system/allfunction.do";		
	}
	

	
	/**
	 * 所有功能
	 * @param message
	 * @param curPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/allfunction")
	public String  getAllFunction(String message,Model model){	
		if(message!=null&& !message.equals("")){
			model.addAttribute("message", message);	
		}
		List<Function> functionList=systemServer.getAllFunction();
	
		model.addAttribute("functionList", functionList);	
		return "system/list_function2";		
	}
	/**
	 * 模块所有功能
	 * @param message
	 * @param curPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/allfunctionbymodules/{modules_id}",method=RequestMethod.GET)
	public String  getAllFunctionByModules(@PathVariable Integer modules_id,Model model){
		System.out.println("modules_id"+modules_id);
		Modules m=systemServer.getModulesById(modules_id);
		
		List<Function> functionList=SetUtil.setToList(m.getFunctionSet());
		
		model.addAttribute("functionList", functionList);	
		return "system/list_function";		
	}
	
	
	/**
	 * 添加套餐
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/addmenmbermode")
	public String addMenmberMode(Model model){		
		model.addAttribute("operation", "addmenmberMode");		
		return "system/add_menmber_mode";	
	}
	@RequestMapping(value="/menmbermode/operation",method=RequestMethod.POST)
	public String operationMenmberMode(String operation,MenmberMode menmberMode,Model model){
		String message="";			
		if("addmenmberMode".equals(operation)){
			if(!systemServer.addMenmberMode(menmberMode)){				
				message="添加套餐失败!";}else{
					message="";
				}		
		}
		if("updatemenmberMode".equals(operation)){		
			if(!systemServer.updateMenmberMode(menmberMode)){
				message="修改套餐失败";}else{
					message="";
				}
		}	
		model.addAttribute("message", message);	
		return "redirect:/system/allmenmberMode.do";
		
	}
	/**
	 * 删除套餐
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/deletemenmberMode/{m_id}",method=RequestMethod.GET)
	public String deleteMenmberMode(@PathVariable Integer m_id,Model model){	
		MenmberMode menmberMode=systemServer.getMenmberModeById(m_id);	
		Set<Combination> s=menmberMode.getCombinationSet();
		if(s!=null && s.size()>0){
			for(Combination c:s){
				this.deleteCombination(c.getCombination_id());
			}
		}
		String message="";
		if(!systemServer.deleteMenmberMode(menmberMode)){
			message="删除套餐失败！";
		}else{
			message="";
		}
		model.addAttribute("message", message);		
		return "redirect:/system/allmenmberMode.do";		
	}
	
	/**
	 * 更新套餐
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/updatemenmberMode/{m_id}",method=RequestMethod.GET)
	public String updateMenmberMode(@PathVariable Integer m_id,Model model){	
		MenmberMode menmberMode=systemServer.getMenmberModeById(m_id);;
		model.addAttribute("operation", "updatemenmberMode");
		model.addAttribute("menmberMode", menmberMode);		
		return "system/add_menmber_mode";	
	}
	
	
	/**
	 * 所有套餐
	 * @param message
	 * @param curPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/allmenmberMode")
	public String  getAllMenmberMode(String message,Model model){	
		if(message!=null&& !message.equals("")){
			model.addAttribute("message", message);	
		}
		List<MenmberMode> menmberModeList=systemServer.getAllMenmberMode();
		model.addAttribute("menmberModeList", menmberModeList);	
		return "system/list_menmber_mode";		
	}
	
	
	/**
	 * 添加职位
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/addpost")
	public String addPost(Model model){	
		List allDepartmentList=systemServer.getAllDepartment();
		model.addAttribute("allDepartmentList",allDepartmentList);	
		model.addAttribute("operation", "addpost");		
		return "system/add_post";	
	}
	
	@RequestMapping(value="/post/operation",method=RequestMethod.POST)
	public String operationPost(Integer department_id,String operation,Post post,Model model){
		String message="";	
		Department d=systemServer.getDepartmentById(department_id);
		post.setDepartment(d);
		if("addpost".equals(operation)){
			if(!systemServer.addPost(post))	{			
				message="添加职位失败!";}else{
					message="";
				}		
		}
		if("updatemenmberMode".equals(operation)){		
			if(!systemServer.updatePost(post)){
				message="修改职位失败";}else{
					message="";
				}
		}	
		model.addAttribute("message", message);			
		return "redirect:/system/allpost.do";
		
	}
	/**
	 * 更新职位
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/updatepost/{post_id}",method=RequestMethod.GET)
	public String updatePost(@PathVariable Integer post_id,Model model){	
		Post post=systemServer.getPostById(post_id);
		model.addAttribute("operation", "updatepost");
		model.addAttribute("post", post);		
		return "system/add_post";	
	}

	/**
	 * 删除职位
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/deletepost/{post_id}",method=RequestMethod.GET)
	public String deletePost(@PathVariable Integer post_id,Model model){
		Post post=systemServer.getPostById(post_id);
		String message="";
		if(!systemServer.deletePost(post)){
			message="删除职位失败！";
		}else{
			message="";
		}
		model.addAttribute("message",message);	
		return "redirect:/system/allpost.do";		
	}
	/**
	 * 所有职位
	 * @param message
	 * @param curPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/allpost")
	public String  getAllPost(String message,Model model){	
		if(message!=null&& !message.equals("")){
			model.addAttribute("message", message);	
		}
		List<Post> postList=systemServer.getAllPost();
		model.addAttribute("postList", postList);	
		return "system/list_post";		
	}	
	
	/**
	 * 部门所有职位
	 * @param message
	 * @param curPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/allpostbydepartment/{department_id}",method=RequestMethod.GET)
	public String  getAllPostByDepartment(@PathVariable Integer department_id,Model model){	
		Department department=systemServer.getDepartmentById(department_id);
		List<Post> postList=SetUtil.setToList(department.getPostSet());
		model.addAttribute("postList", postList);
		
		return "system/list_post";		
	}
	
	/**
	 * 添加商品类别
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/addcategory")
	public String addCategory(Model model){	
		model.addAttribute("operation", "addcategory");		
		return "system/add_category";	
	}
	@RequestMapping(value="/category/operation",method=RequestMethod.POST)
	public String operationCategory(String operation,Category category,Model model){
		String message="";			
		if("addcategory".equals(operation)){
			if(!systemServer.addCategory(category))	{			
				message="添加服务类别失败!";}else{
					message="";
				}		
		}
		if("updatecategory".equals(operation)){		
			if(!systemServer.updateCategory(category)){
				message="修改服务类别失败";}else{
					message="";
				}
		}	
		model.addAttribute("message", message);			
		return "redirect:/system/allcategory.do";
		
	}
	/**
	 * 删除商品类别
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/deletecategory/{category_id}",method=RequestMethod.GET)
	public String deleteCategory(@PathVariable Integer category_id,Model model){		
		Category category=systemServer.getCategoryById(category_id);
		String message="";
		if(!systemServer.deleteCategory(category)){
			message="删除产品分类失败！";
		}else{
			message="";
		}
		model.addAttribute("message",message);
		return "redirect:/system/allcategory.do";		
	}
	
	/**
	 * 更新商品类别
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/updatecategory/{category_id}",method=RequestMethod.GET)
	public String updateCategory(@PathVariable Integer category_id,Model model){	
		Category category=systemServer.getCategoryById(category_id);
		model.addAttribute("operation", "updatecategory");
		model.addAttribute("category", category);		
		return "system/add_category";	
	}
	
	/**
	 * 所有商品类别
	 * @param message
	 * @param curPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/allcategory")
	public String  getAllCategory(String message,Model model){	
		if(message!=null&& !message.equals("")){
			model.addAttribute("message", message);	
		}
		List<Category> categoryList=systemServer.getAllCategory();
		model.addAttribute("categoryList", categoryList);	
		return "system/list_category";		
	}	

	
	/**
	 * 添加金额组合
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/addcombination",method=RequestMethod.GET)
	public String addCombination(Integer[] m_list,Model model){	
	
		model.addAttribute("m_list", m_list);	
		model.addAttribute("operation", "addcombination");		
		return "system/add_combination";	
	}
	@RequestMapping(value="/combination/operation2")
	public String operationCombination(List<Integer> c_list,String operation2,String operation,Combination combination,Model model){
		String message="";	
		
		int number=systemServer.getCombinationMaxNumber()+1;
		combination.setCombination_number(number+1);
		if("addcombination".equals(operation2)){
			if(!systemServer.addCombination(combination)){				
				message="添加金额组合失败!";	
					
			}else{
				message="";
			}	
		}
		if("updatecombination".equals(operation2)){		
			if(!systemServer.updateCombination(combination))
				message="修改金额组合失败";
		}else{
			message="";
		}	
		
		int c_id=systemServer.getCombinationByNumber(number).getCombination_id();
		if(c_list==null && c_list.size()==0){
			c_list=new ArrayList<>();
		}
		c_list.add(c_id);
		model.addAttribute("operation", operation);	
		model.addAttribute("message", message);
		model.addAttribute("c_list", c_list);	
		return "redirect:/system/allcombinationbymenmberMode.do";
		
	}
	/**
	 * 删除金额组合
	 * @param post
	 * @param model
	 * @return
	 *//*
	@RequestMapping(value="/deletecombination/{combination_id}",method=RequestMethod.GET)*/
	
	private boolean deleteCombination(Integer combination_id){		
		Combination combination=systemServer.getCombinationById(combination_id);
		
		systemServer.deleteCombination(combination);	
		return true;		
	}
	
	/**
	 * 更新金额组合
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/updatecombination/{combination_id}",method=RequestMethod.GET)
	public String updateCombination(@PathVariable Integer combination_id,Model model){	
		Combination combination=systemServer.getCombinationById(combination_id);
		Integer m_id= combination.getMenmberMode().getM_id();
		model.addAttribute("m_id", m_id);
		model.addAttribute("operation", "updatecombination");
		model.addAttribute("combination", combination);		
		return "system/add_combination";	
	}
	
	/**
	 * 所有金额组合
	 * @param message
	 * @param curPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/allcombination")
	public String  getAllCombination(String message,Model model){	
		if(message!=null&& !message.equals("")){
			model.addAttribute("message", message);	
		}
		List<Combination> combinationList=systemServer.getAllCombination();
		model.addAttribute("combinationList", combinationList);	
		return "system/list_combination";		
	}
	/**
	 * 优惠套餐下金额组合
	 * @param message
	 * @param curPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/allcombinationbymenmberMode")
	public String  getAllCombinationByMenmberMode(Combination combination,Model model){	
		MenmberMode menmberMode=systemServer.getMenmberModeById(combination.getMenmberMode().getM_id());
		List<Combination> combinationList=SetUtil.setToList(menmberMode.getCombinationSet());
		model.addAttribute("combinationList", combinationList);	
		return "system/list_combination";		
	}

	/**
	 * 添加商品
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/addcommodity")
	public String addCommodity(Model model){	
		model.addAttribute("operation", "addcommodity");		
		return "system/add_commodity";	
	}
	@RequestMapping(value="/commodity/operation",method=RequestMethod.POST)
	public String operationCommodity(String operation,Commodity commodity,Model model){
		String message="";			
		if("addcommodity".equals(operation)){
			if(!systemServer.addCommodity(commodity)){				
				message="添加服务失败!";	}else{
					message="";
				}		
		}
		if("updatecategory".equals(operation)){		
			if(!systemServer.updateCommodity(commodity)){
				message="修改服务失败";}else{
					message="";
				}	
		}	
		model.addAttribute("message", message);			
		return "redirect:/system/allcommodity.do";
		
	}
	/**
	 * 删除商品
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/deletecommodity/{commodity_id}",method=RequestMethod.GET)
	public String deleteCommodity(@PathVariable Integer commodity_id,Model model){		
		Commodity commodity=systemServer.getCommodityById(commodity_id);
		String message="";
		if(!systemServer.deleteCommodity(commodity)){
			message="删除产品失败！";
		}else{
			message="";
		}
		model.addAttribute("message",message);	
		return "redirect:/system/allcommodity.do";		
	}
	
	/**
	 * 更新商品
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/updatecommodity/{commodity_id}",method=RequestMethod.GET)
	public String updateCommodity(@PathVariable Integer commodity_id,Model model){	
		Commodity commodity=systemServer.getCommodityById(commodity_id);
		model.addAttribute("operation", "updatecommodity");
		model.addAttribute("commodity", commodity);		
		return "system/add_category";	
	}
	
	/**
	 * 所有商品
	 * @param message
	 * @param curPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/allcommodity")
	public String  getAllCommodity(String message,Model model){	
		if(message!=null&& !message.equals("")){
			model.addAttribute("message", message);	
		}
		List<Commodity> commodityList=systemServer.getAllCommodity();
		model.addAttribute("commodityList", commodityList);	
		return "system/list_commodity";		
	}
	/**
	 * 同类所有商品
	 * @param message
	 * @param curPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/allcommoditybycategory/{category_id}",method=RequestMethod.GET)
	public String  getAllCommodityByCategory(@PathVariable Integer category_id,Model model){	
		Category category=systemServer.getCategoryById(category_id);
		List<Commodity> commodityList=SetUtil.setToList(category.getCommoditySet());
		model.addAttribute("commodityList", commodityList);	
		return "system/list_commodity";		
	}
	
	/**
	 * 添加部门
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/adddepartment")
	public String addDepartment(Model model){	
		model.addAttribute("operation", "adddepartment");		
		return "system/add_department";	
	}
	
	@RequestMapping(value="/department/operation",method=RequestMethod.POST)
	public String operationDepartment(String operation,Department department,Model model){
		
		String message="";			
		if("adddepartment".equals(operation)){
			if(!systemServer.addDepartment(department)){				
				message="添加部门失败!";}	else{
					message="";
				}		
		}
		if("updatedepartment".equals(operation)){		
			if(!systemServer.updateDepartment(department)){
				message="修改部门失败";}else{
					message="";
				}	
		}	
		model.addAttribute("message", message);			
		return "redirect:/system/alldepartment.do";
		
	}
	/**
	 * 更新部门
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/updatedepartment/{department_id}",method=RequestMethod.GET)
	public String updateDepartment(@PathVariable Integer department_id,Model model){	
		Department department=systemServer.getDepartmentById(department_id);
		model.addAttribute("operation", "updatedepartment");
		model.addAttribute("department", department);		
		return "system/add_department";	
	}

	/**
	 * 删除部门
	 * @param post
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/deletedepartment/{department_id}",method=RequestMethod.GET)
	public String deleteDepartment(@PathVariable Integer department_id,Model model){		
		Department department=systemServer.getDepartmentById(department_id);
		
		String message="";
		if(!systemServer.deleteDepartment(department)){
			message="删除部门失败！";
		}else{
			message="";
		}
		model.addAttribute("message",message);	
		return "redirect:/system/alldepartment.do";		
	}
	/**
	 * 所有部门
	 * @param message
	 * @param curPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/alldepartment")
	public String  getAllDepartment(String message,Model model){	
		if(message!=null&& !message.equals("")){
			model.addAttribute("message", message);	
		}
		List<Department> departmentList=systemServer.getAllDepartment();
		model.addAttribute("departmentList", departmentList);	
		return "system/list_department";		
	}
}
