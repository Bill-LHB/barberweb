
package com.lhb.barber.server;

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

public interface SystemServer {
	/*boolean addRole(Role role);// 添加角色

	boolean deleteRole(Role role);// 删除角色

	boolean updateRole(Role role);// 更新角色

	List<Role> getRoleByName(String name);// 通过角色名获取角色

	List<Role> getAllRole();// 获取所有角色

	Role getRoleById(int id);// 通过Id获取角色

	boolean addModules(Modules modules);// 添加模块

	boolean deleteModules(Modules modules);// 删除模块

	boolean updateModules(Modules modules);// 更新模块

	List<Modules> getModulesByName(String name);// 通过模块名获取模块

	List<Modules> getAllModules();// 获取所有模块

	Modules getModulesById(int id);// 获取ID获取模块

	boolean addFunction(Function function);// 添加功能

	boolean deleteFunction(Function function);// 删除功能

	boolean updateFunction(Function function);// 更新功能

	Function getFunctionByModulesAndName(Modules modules, String name);// 通过功能名获取功能

	List<Function> getAllFunction();// 获取所有功能

	Function getFunctionById(int function_id);// 通过Id获取功能

	boolean addMenmberMode(MenmberMode menmberMode);// 添加优惠套餐

	boolean deleteMenmberMode(MenmberMode menmberMode);// 删除优惠套餐

	boolean updateMenmberMode(MenmberMode menmberMode);// 更新优惠套餐

	List<MenmberMode> getAllMenmberMode();// 获取优惠套餐

	MenmberMode getMenmberModeById(int id);// 通过Id获取优惠套餐

	List<MenmberMode> getMenmberModeByName(String m_name);// 通过优惠套餐名称获取优惠套餐

	boolean addPost(Post post);// 添加职位

	boolean deletePost(Post post);// 删除职位

	boolean updatePost(Post post);// 更新职位

	List<Post> getPostByName(String name);// 通过职位名获取职位

	List<Post> getAllPost();// 获取所有职位

	Post getPostById(int id);// 通过Id获取职位
	
	boolean addDepartment(Department department);// 添加部门

	boolean deleteDepartment(Department department);// 删除部门

	boolean updateDepartment(Department department);// 更新部门

	List<Department> getDepartmentByName(String name);// 通过部门名获取部门

	List<Department> getAllDepartment();// 获取所有部门

	Department getDepartmentById(int id);// 通过Id获取部门
	
	boolean addCategory(Category category);// 添加服务类别

	boolean deleteCategory(Category category);// 删除服务类别

	boolean updateCategory(Category category);// 更新服务类别

	List<Category> getCategoryByName(String name);// 通过服务类别名获取服务类别

	List<Category> getAllCategory();// 获取所有服务类别

	Category getCategoryById(int id);// 通过Id获取服务类别
	
	boolean addCommodity(Commodity commodity);// 添加商品

	boolean deleteCommodity(Commodity commodity);// 删除商品

	boolean updateCommodity(Commodity commodity);// 更新商品

	List<Commodity> getCommodityByName(String name);// 通过商品名获取商品

	List<Commodity> getAllCommodity();// 获取所有商品

	Commodity getCommodityById(int id);// 通过Id获取商品

	boolean addCombination(Combination combination);// 添加金额组合

	boolean deleteCombination(Combination combination);// 删除金额组合

	boolean updateCombination(Combination combination);// 更新金额组合

	List<Combination> getAllCombination();// 获取所有金额组合

	Combination getCombinationById(int id);// 通过Id获取金额组合
	Integer getCombinationMaxNumber();
	Combination getCombinationByNumber(int number);// 通过Number获取部门
*/
	boolean addModules(Modules modules);// 添加模块

	boolean deleteModules(Modules modules);// 删除模块

	boolean updateModules(Modules modules);// 更新模块

	List<Modules> getModulesByName(String name);// 通过模块名获取模块
	
	Modules getModulesById(int id);// 获取ID获取模块
	
	List<Modules> getAllModules();// 获取所有模块
	
	List<Modules> getAllModulesByPager(PagerUtil pager);// 分页获取所有模块
	
	Integer getAllModulesAmount();//获取所有模块条目数
	
	boolean addFunction(Function function);// 添加功能

	boolean deleteFunction(Function function);// 删除功能

	boolean updateFunction(Function function);// 更新功能

	Function getFunctionByModulesAndName(Modules modules, String name);// 通过模块和功能名获取功能
	
	Function getFunctionById(int id);// 通过Id获取功能
	
	List<Function> getAllFunction();// 获取所有功能
	
	Integer getAllFunctionAmount();//获取所有功能条目数
	
	List<Function> getFunctionByModulesByPager(Modules modules,PagerUtil pager);// 分页技术通过模块获取功能
	
	Integer getAllFunctionAmountByModules(Modules modules);//获取模块内所有功能条目数
	
	List<Function> getAllFunctionByPager(PagerUtil pager);// 分页技术获取所有功能
	
	boolean addRole(Role role);// 添加角色

	boolean deleteRole(Role role);// 删除角色

	boolean updateRole(Role role);// 更新角色

	List<Role> getRoleByName(String name);// 通过角色名获取角色

	Role getRoleById(int id);// 通过Id获取角色

	List<Role> getAllRole();// 获取所有角色
	
	List<Role> getAllRoleByPager(PagerUtil pager);// 分页获取所有角色
	
	Integer getAllRolesAmount();//获取所有角色条目数
	
	boolean addMenmberMode(MenmberMode menmberMode);// 添加优惠套餐

	boolean deleteMenmberMode(MenmberMode menmberMode);// 删除优惠套餐

	boolean updateMenmberMode(MenmberMode menmberMode);// 更新优惠套餐
	
	List<MenmberMode> getMenmberModeByName(String m_name);// 通过优惠套餐名称获取优惠套餐

	MenmberMode getMenmberModeById(int id);// 通过Id获取优惠套餐
	
	List<MenmberMode> getAllMenmberMode();// 获取优惠套餐
	
	List<MenmberMode> getAllMenmberModeByPager(PagerUtil pager);// 分页获取所有优惠套餐
	
	Integer getAllMenmberModeAmount();//获取所有优惠套餐条目数
	
	boolean addCombination(Combination combination);// 添加优惠方式

	boolean deleteCombination(Combination combination);// 删除优惠方式

	boolean updateCombination(Combination combination);// 更新优惠方式

	Combination getCombinationById(int id);// 通过Id获取优惠方式
	
	Combination getCombinationByNumber(int number);// 通过编号获取优惠方式
	
	List<Combination> getAllCombination();// 获取所有优惠方式

	List<Combination> getAllCombinationByPager(PagerUtil pager);// 分页获取所有优惠方式
	
	Integer getAllCombinationAmount();//获取所有优惠方式条目数
	
	List<Combination> getCombinationByMenmberModeByPager(MenmberMode menmberMode,PagerUtil pager);// 分页技术通过套餐获取优惠方式
	
	Integer getAllCombinationAmountByMenmberMode(MenmberMode menmberMode);//获取套餐内所有优惠方式条目数
	
	Integer getCombinationMaxNumber();//获取优惠方式编号最大值
	
	boolean addDepartment(Department department);// 添加部门

	boolean deleteDepartment(Department department);// 删除部门

	boolean updateDepartment(Department department);// 更新部门

	List<Department> getDepartmentByName(String name);// 通过部门名获取部门

	Department getDepartmentById(int id);// 通过Id获取部门 

	List<Department> getAllDepartment();// 获取所有部门
	
	List<Department> getAllDepartmentByPager(PagerUtil pager);// 分页获取部门 
	
	Integer getAllDepartmentAmount();//获取部门条目数
	
	boolean addPost(Post post);// 添加职位

	boolean deletePost(Post post);// 删除职位

	boolean updatePost(Post post);// 更新职位

	List<Post> getPostByName(String name);// 通过职位名获取职位
	
	Post getPostById(int id);// 通过Id获取职位

	List<Post> getAllPost();// 获取所有职位
	
	List<Post> getAllPostByPager(PagerUtil pager);// 分页获取职位
	
	Integer getAllPostAmount();//获取职位条目数

	List<Post> getPostByDepartmentByPager(Department department,PagerUtil pager);// 分页技术通过部门获取职位
	
	Integer getAllPostAmountByDepartment(Department department);//获取部门内所有职位条目数
	
	boolean addCategory(Category category);// 添加服务类别

	boolean deleteCategory(Category category);// 删除服务类别

	boolean updateCategory(Category category);// 更新服务类别

	List<Category> getCategoryByName(String name);// 通过服务类别名获取服务类别

	List<Category> getAllCategory();// 获取所有服务类别

	Category getCategoryById(int id);// 通过Id获取服务类别

	List<Category> getAllCategoryByPager(PagerUtil pager);// 分页获取服务类别
	
	Integer getAllCategoryAmount();//获取服务类别条目数
		
	boolean addCommodity(Commodity commodity);// 添加产品

	boolean deleteCommodity(Commodity commodity);// 删除产品

	boolean updateCommodity(Commodity commodity);// 更新产品

	List<Commodity> getCommodityByName(String name);// 通过产品名获取职位

	List<Commodity> getAllCommodity();// 获取所有产品

	Commodity getCommodityById(int id);// 通过Id获取产品

	List<Commodity> getAllCommodityByPager(PagerUtil pager);// 分页获取产品
	
	Integer getAllCommodityAmount();//获取产品条目数

	List<Commodity> getCommodityByCategoryByPager(Category category,PagerUtil pager);// 分页技术通过产品类别获取产品
	
	Integer getAllCommodityAmountByCategory(Category category);//获取产品类别内所有产品条目数
	

}
