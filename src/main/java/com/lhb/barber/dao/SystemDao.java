package com.lhb.barber.dao;

import java.util.List;

import com.lhb.barber.model.Category;
import com.lhb.barber.model.Combination;
import com.lhb.barber.model.Commodity;
import com.lhb.barber.model.Department;
import com.lhb.barber.model.Function;
import com.lhb.barber.model.MenmberMode;
import com.lhb.barber.model.Modules;
import com.lhb.barber.model.Post;
import com.lhb.barber.model.Role;
import com.lhb.barber.util.PagerUtil;

public interface SystemDao {
	void addModules(Modules modules);// 添加模块

	void deleteModules(Modules modules);// 删除模块

	void updateModules(Modules modules);// 更新模块

	List<Modules> getModulesByName(String name);// 通过模块名获取模块
	
	Modules getModulesById(int id);// 获取ID获取模块
	
	List<Modules> getAllModules();// 获取所有模块
	
	List<Modules> getAllModulesByPager(PagerUtil pager);// 分页获取所有模块
	
	Integer getAllModulesAmount();//获取所有模块条目数
	
	void addFunction(Function function);// 添加功能

	void deleteFunction(Function function);// 删除功能

	void updateFunction(Function function);// 更新功能

	List<Function> getFunctionByModulesAndName(Modules modules, String name);// 通过模块和功能名获取功能
	
	Function getFunctionById(int id);// 通过Id获取功能
	
	List<Function> getAllFunction();// 获取所有功能
	
	Integer getAllFunctionAmount();//获取所有功能条目数
	
	List<Function> getFunctionByModulesByPager(Modules modules,PagerUtil pager);// 分页技术通过模块获取功能
	
	Integer getAllFunctionAmountByModules(Modules modules);//获取模块内所有功能条目数
	
	List<Function> getAllFunctionByPager(PagerUtil pager);// 分页技术获取所有功能
	
	void addRole(Role role);// 添加角色

	void deleteRole(Role role);// 删除角色

	void updateRole(Role role);// 更新角色

	List<Role> getRoleByName(String name);// 通过角色名获取角色

	Role getRoleById(int id);// 通过Id获取角色

	List<Role> getAllRole();// 获取所有角色
	
	List<Role> getAllRoleByPager(PagerUtil pager);// 分页获取所有角色
	
	Integer getAllRolesAmount();//获取所有角色条目数
	
	void addMenmberMode(MenmberMode menmberMode);// 添加优惠套餐

	void deleteMenmberMode(MenmberMode menmberMode);// 删除优惠套餐

	void updateMenmberMode(MenmberMode menmberMode);// 更新优惠套餐
	
	List<MenmberMode> getMenmberModeByName(String m_name);// 通过优惠套餐名称获取优惠套餐

	MenmberMode getMenmberModeById(int id);// 通过Id获取优惠套餐
	
	List<MenmberMode> getAllMenmberMode();// 获取优惠套餐
	
	List<MenmberMode> getAllMenmberModeByPager(PagerUtil pager);// 分页获取所有优惠套餐
	
	Integer getAllMenmberModeAmount();//获取所有优惠套餐条目数
	
	void addCombination(Combination combination);// 添加优惠方式

	void deleteCombination(Combination combination);// 删除优惠方式

	void updateCombination(Combination combination);// 更新优惠方式

	Combination getCombinationById(int id);// 通过Id获取优惠方式
	
	Combination getCombinationByNumber(int number);// 通过编号获取优惠方式
	
	List<Combination> getAllCombination();// 获取所有优惠方式

	List<Combination> getAllCombinationByPager(PagerUtil pager);// 分页获取所有优惠方式
	
	Integer getAllCombinationAmount();//获取所有优惠方式条目数
	
	List<Combination> getCombinationByMenmberModeByPager(MenmberMode menmberMode,PagerUtil pager);// 分页技术通过套餐获取优惠方式
	
	Integer getAllCombinationAmountByMenmberMode(MenmberMode menmberMode);//获取套餐内所有优惠方式条目数
	
	Integer getCombinationMaxNumber();//获取优惠方式编号最大值
	
	void addDepartment(Department department);// 添加部门

	void deleteDepartment(Department department);// 删除部门

	void updateDepartment(Department department);// 更新部门

	List<Department> getDepartmentByName(String name);// 通过部门名获取部门

	Department getDepartmentById(int id);// 通过Id获取部门 

	List<Department> getAllDepartment();// 获取所有部门
	
	List<Department> getAllDepartmentByPager(PagerUtil pager);// 分页获取部门 
	
	Integer getAllDepartmentAmount();//获取部门条目数
	
	void addPost(Post post);// 添加职位

	void deletePost(Post post);// 删除职位

	void updatePost(Post post);// 更新职位

	List<Post> getPostByName(String name);// 通过职位名获取职位
	
	Post getPostById(int id);// 通过Id获取职位

	List<Post> getAllPost();// 获取所有职位
	
	List<Post> getAllPostByPager(PagerUtil pager);// 分页获取职位
	
	Integer getAllPostAmount();//获取职位条目数

	List<Post> getPostByDepartmentByPager(Department department,PagerUtil pager);// 分页技术通过部门获取职位
	
	Integer getAllPostAmountByDepartment(Department department);//获取部门内所有职位条目数
	
	void addCategory(Category category);// 添加服务类别

	void deleteCategory(Category category);// 删除服务类别

	void updateCategory(Category category);// 更新服务类别

	List<Category> getCategoryByName(String name);// 通过服务类别名获取服务类别

	List<Category> getAllCategory();// 获取所有服务类别

	Category getCategoryById(int id);// 通过Id获取服务类别

	List<Category> getAllCategoryByPager(PagerUtil pager);// 分页获取服务类别
	
	Integer getAllCategoryAmount();//获取服务类别条目数
		
	void addCommodity(Commodity commodity);// 添加产品

	void deleteCommodity(Commodity commodity);// 删除产品

	void updateCommodity(Commodity commodity);// 更新产品

	List<Commodity> getCommodityByName(String name);// 通过产品名获取职位

	List<Commodity> getAllCommodity();// 获取所有产品

	Commodity getCommodityById(int id);// 通过Id获取产品

	List<Commodity> getAllCommodityByPager(PagerUtil pager);// 分页获取产品
	
	Integer getAllCommodityAmount();//获取产品条目数

	List<Commodity> getCommodityByCategoryByPager(Category category,PagerUtil pager);// 分页技术通过产品类别获取产品
	
	Integer getAllCommodityAmountByCategory(Category category);//获取产品类别内所有产品条目数
	
}
