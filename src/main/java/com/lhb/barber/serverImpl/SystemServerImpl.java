package com.lhb.barber.serverImpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lhb.barber.dao.SystemDao;
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
import com.lhb.barber.util.PagerUtil;

@Service("systemServer")
@Transactional
public class SystemServerImpl implements SystemServer {
	@Autowired
	private SystemDao systemDao;

	@Override
	public boolean addRole(Role role) {
		if (systemDao.getRoleByName(role.getName()) != null && systemDao.getRoleByName(role.getName()).size()>0) {
			return false;
		}
		systemDao.addRole(role);
		return true;
	}

	@Override
	public boolean deleteRole(Role role) {
		PagerUtil pager = new PagerUtil();
		pager.setICount(1);
		pager.setCurPage(1);
		if (systemDao.getRoleById(role.getRole_id()) == null) {
			return false;
		}
		if (role.getUserSet() != null) {
			return false;
		}
		systemDao.deleteRole(role);
		return true;
	}

	@Override
	public boolean updateRole(Role role) {
		PagerUtil pager = new PagerUtil();
		pager.setICount(1);
		pager.setCurPage(1);
		if (systemDao.getRoleById(role.getRole_id()) == null) {
			return false;
		}
		systemDao.updateRole(role);
		return true;
	}

	@Override
	public List<Role> getRoleByName(String name) {
		return systemDao.getRoleByName(name);
	}


	@Override
	public List<Role> getAllRole() {
		// TODO Auto-generated method stub
		return systemDao.getAllRole();
	}

	@Override
	public Role getRoleById(int id) {
		// TODO Auto-generated method stub
		return systemDao.getRoleById(id);
	}

	@Override
	public boolean addModules(Modules modules) {
		List<Modules> modulesList=systemDao.getModulesByName(modules.getName());
		
		if (modulesList != null && modulesList.size()>0) {
			return false;
		}
		systemDao.addModules(modules);
		return true;

	}

	@Override
	public boolean deleteModules(Modules modules) {
		Set f=modules.getFunctionSet();
		if (systemDao.getModulesById(modules.getModules_id()) == null) {
			return false;
		}
		if (f != null && f.size()>0) {	
			return false;
		}
		systemDao.deleteModules(modules);
		return true;

	}

	@Override
	public boolean updateModules(Modules modules) {
		if (systemDao.getModulesById(modules.getModules_id()) == null) {
			return false;
		}	
		systemDao.updateModules(modules);
		return true;

	}

	@Override
	public List<Modules> getModulesByName(String name) {
		// TODO Auto-generated method stub
		return systemDao.getModulesByName(name);
	}

	@Override
	public List<Modules> getAllModules() {
		// TODO Auto-generated method stub
		return systemDao.getAllModules();
	}

	@Override
	public Modules getModulesById(int id) {
		// TODO Auto-generated method stub
		return systemDao.getModulesById(id);
	}

	
	
	@Override
	public boolean addFunction(Function function) {
		List f=systemDao.getFunctionByModulesAndName(function.getModules(), function.getName());
		if (f != null && f.size()>0) {
			return false;
		}
		systemDao.addFunction(function);
		return true;
	}

	@Override
	public boolean deleteFunction(Function function) {	
		if(systemDao.getFunctionById(function.getFunction_id())==null){
			return false;
		}
		systemDao.deleteFunction(function);
		return true;

	}

	@Override
	public boolean updateFunction(Function function) {
		
		List f=systemDao.getFunctionByModulesAndName(function.getModules(), function.getName());
		
		if (f != null && f.size()>0) {
			return false;
		}
		systemDao.updateFunction(function);
		return true;

	}

	@Override
	public Function getFunctionByModulesAndName(Modules modules, String name) {
		// TODO Auto-generated method stub
		Function function = null;
		List f=systemDao.getFunctionByModulesAndName(function.getModules(), function.getName());
		if (f != null && f.size()>0)
			function = (Function) f.get(0);
		return function;
	}


	@Override
	public List<Function> getAllFunction() {
		// TODO Auto-generated method stub
		return systemDao.getAllFunction();
	}

	@Override
	public Function getFunctionById(int id) {
		// TODO Auto-generated method stub
		return systemDao.getFunctionById(id);
	}

	
	
	@Override
	public boolean addMenmberMode(MenmberMode menmberMode) {
		if (systemDao.getMenmberModeById(menmberMode.getM_id()) != null) {
			return false;
		}
		systemDao.addMenmberMode(menmberMode);
		return true;

	}

	@Override
	public boolean deleteMenmberMode(MenmberMode menmberMode) {
		if (systemDao.getMenmberModeById(menmberMode.getM_id()) == null) {
			return false;
		}
		systemDao.deleteMenmberMode(menmberMode);
		return true;
	}

	@Override
	public boolean updateMenmberMode(MenmberMode menmberMode) {
		if (systemDao.getMenmberModeById(menmberMode.getM_id()) == null) {
			return false;
		}
		systemDao.updateMenmberMode(menmberMode);
		return true;

	}

	@Override
	public List<MenmberMode> getAllMenmberMode() {
		// TODO Auto-generated method stub
		return systemDao.getAllMenmberMode();
	}

	@Override
	public MenmberMode getMenmberModeById(int id) {
		// TODO Auto-generated method stub
		return systemDao.getMenmberModeById(id);
	}

	@Override
	public List<MenmberMode> getMenmberModeByName(String m_name) {
		// TODO Auto-generated method stub
		return systemDao.getMenmberModeByName(m_name);
	}

	@Override
	public boolean addPost(Post post) {
		if (systemDao.getPostById(post.getPost_id())!= null) {
			return false;
		}
		systemDao.addPost(post);
		return true;

	}

	@Override
	public boolean deletePost(Post post) {
		if (systemDao.getPostById(post.getPost_id()) == null) {
			return false;
		}
		systemDao.deletePost(post);
		return true;

	}

	@Override
	public boolean updatePost(Post post) {
		if (systemDao.getPostById(post.getPost_id()) == null) {
			return false;
		}
		systemDao.updatePost(post);
		return true;

	}

	@Override
	public List<Post> getPostByName(String name) {
		// TODO Auto-generated method stub
		return systemDao.getPostByName(name);
	}


	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return systemDao.getAllPost();
	}

	@Override
	public Post getPostById(int id) {
		return systemDao.getPostById(id);
	}

	

	
	@Override
	public boolean addCategory(Category category) {
		// TODO Auto-generated method stub
		if (systemDao.getCategoryById(category.getCategory_id())!= null) {
			return false;
		}
		systemDao.addCategory(category);
		return true;
	}

	@Override
	public boolean deleteCategory(Category category) {
		// TODO Auto-generated method stub
		if (systemDao.getCategoryById(category.getCategory_id())== null) {
			return false;
		}
		systemDao.deleteCategory(category);
		return true;
	}

	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		if (systemDao.getCategoryById(category.getCategory_id())== null) {
			return false;
		}
		systemDao.updateCategory(category);
		return true;
	}

	@Override
	public List<Category> getCategoryByName(String name) {
		// TODO Auto-generated method stub
		return systemDao.getCategoryByName(name);
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return systemDao.getAllCategory();
	}

	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		return systemDao.getCategoryById(id);
	}

	
	
	
	
	
	@Override
	public boolean addCommodity(Commodity commodity) {
		List<Commodity> c=systemDao.getCommodityByName(commodity.getCommodity_name());
		if(c!=null || c.size()==0){
			return false;
		}
		systemDao.addCommodity(commodity);
		return true;	
	}

	@Override
	public boolean deleteCommodity(Commodity commodity) {
		Commodity c=systemDao.getCommodityById(commodity.getCommodity_id());
		if(c==null){
			return false;
		}
		systemDao.deleteCommodity(commodity);
		return true;	
	}

	@Override
	public boolean updateCommodity(Commodity commodity) {
		Commodity c=systemDao.getCommodityById(commodity.getCommodity_id());
		if(c==null){
			return false;
		}
		systemDao.updateCommodity(commodity);
		return true;		
	}

	@Override
	public List<Commodity> getCommodityByName(String name) {	
		return systemDao.getCommodityByName(name);
	}


	@Override
	public List<Commodity> getAllCommodity() {
		// TODO Auto-generated method stub
		return systemDao.getAllCommodity();
	}

	@Override
	public Commodity getCommodityById(int id) {	
		return systemDao.getCommodityById(id);
	}

	@Override
	public boolean addDepartment(Department department) {
		// TODO Auto-generated method stub
		List<Department> d=systemDao.getDepartmentByName(department.getName());
		if(d!=null && d.size()>=0){
			return false;
		}
		
		systemDao.addDepartment(department);
		return true;	
	}

	@Override
	public boolean deleteDepartment(Department department) {
		// TODO Auto-generated method stub
		Department d=systemDao.getDepartmentById(department.getDepartment_id());
		if(d!=null){
			return false;
		}
		systemDao.deleteDepartment(department);
		return true;
	}

	@Override
	public boolean updateDepartment(Department department) {
		// TODO Auto-generated method stub
		Department d=systemDao.getDepartmentById(department.getDepartment_id());
		if(d!=null){
			return false;
		}
		systemDao.updateDepartment(department);
		return true;
	}

	@Override
	public List<Department> getDepartmentByName(String name) {
		// TODO Auto-generated method stub
		return systemDao.getDepartmentByName(name);
	}


	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return systemDao.getAllDepartment();
	}

	@Override
	public Department getDepartmentById(int id) {
		// TODO Auto-generated method stub
		return systemDao.getDepartmentById(id);
	}

	
	
	@Override
	public boolean addCombination(Combination combination) {
		// TODO Auto-generated method stub	
		systemDao.addCombination(combination);
		return true;
	}

	@Override
	public boolean deleteCombination(Combination combination) {
		// TODO Auto-generated method stub
		Combination c=systemDao.getCombinationById(combination.getCombination_id());
		if(c!=null){
			return false;
		}
		systemDao.deleteCombination(combination);
		return true;
	}

	@Override
	public boolean updateCombination(Combination combination) {
		// TODO Auto-generated method stub
		Combination c=systemDao.getCombinationById(combination.getCombination_id());
		if(c!=null){
			return false;
		}
		systemDao.updateCombination(combination);
		return true;
	}


	@Override
	public List<Combination> getAllCombination() {
		// TODO Auto-generated method stub
		return systemDao.getAllCombination();
	}

	@Override
	public Combination getCombinationById(int id) {
		// TODO Auto-generated method stub
		return systemDao.getCombinationById(id);
	}

	@Override
	public Integer getCombinationMaxNumber() {
		// TODO Auto-generated method stub
		return systemDao.getCombinationMaxNumber();
	}

	@Override
	public Combination getCombinationByNumber(int number) {
		// TODO Auto-generated method stub
		return systemDao.getCombinationByNumber(number);
	}

	@Override
	public List<Modules> getAllModulesByPager(PagerUtil pager) {
		// TODO Auto-generated method stub
		return systemDao.getAllModulesByPager(pager);
	}

	@Override
	public Integer getAllModulesAmount() {
		// TODO Auto-generated method stub
		return systemDao.getAllModulesAmount();
	}


	@Override
	public Integer getAllFunctionAmount() {
		// TODO Auto-generated method stub
		return systemDao.getAllFunctionAmount();
	}

	@Override
	public List<Function> getFunctionByModulesByPager(Modules modules, PagerUtil pager) {
		// TODO Auto-generated method stub
		return systemDao.getFunctionByModulesByPager(modules, pager);
	}

	@Override
	public Integer getAllFunctionAmountByModules(Modules modules) {
		// TODO Auto-generated method stub
		return systemDao.getAllFunctionAmountByModules(modules);
	}

	@Override
	public List<Function> getAllFunctionByPager(PagerUtil pager) {
		// TODO Auto-generated method stub
		return systemDao.getAllFunctionByPager(pager);
	}

	@Override
	public List<Role> getAllRoleByPager(PagerUtil pager) {
		// TODO Auto-generated method stub
		return systemDao.getAllRoleByPager(pager);
	}

	@Override
	public Integer getAllRolesAmount() {
		// TODO Auto-generated method stub
		return systemDao.getAllRolesAmount();
	}

	@Override
	public List<MenmberMode> getAllMenmberModeByPager(PagerUtil pager) {
		// TODO Auto-generated method stub
		return systemDao.getAllMenmberModeByPager(pager);
	}

	@Override
	public Integer getAllMenmberModeAmount() {
		// TODO Auto-generated method stub
		return systemDao.getAllMenmberModeAmount();
	}

	@Override
	public List<Combination> getAllCombinationByPager(PagerUtil pager) {
		// TODO Auto-generated method stub
		return systemDao.getAllCombinationByPager(pager);
	}

	@Override
	public Integer getAllCombinationAmount() {
		// TODO Auto-generated method stub
		return systemDao.getAllCombinationAmount();
	}

	@Override
	public List<Combination> getCombinationByMenmberModeByPager(MenmberMode menmberMode, PagerUtil pager) {
		// TODO Auto-generated method stub
		return systemDao.getCombinationByMenmberModeByPager(menmberMode, pager);
	}

	@Override
	public Integer getAllCombinationAmountByMenmberMode(MenmberMode menmberMode) {
		// TODO Auto-generated method stub
		return systemDao.getAllCombinationAmountByMenmberMode(menmberMode);
	}

	@Override
	public List<Department> getAllDepartmentByPager(PagerUtil pager) {
		// TODO Auto-generated method stub
		return systemDao.getAllDepartmentByPager(pager);
	}

	@Override
	public Integer getAllDepartmentAmount() {
		// TODO Auto-generated method stub
		return systemDao.getAllDepartmentAmount();
	}

	@Override
	public List<Post> getAllPostByPager(PagerUtil pager) {
		// TODO Auto-generated method stub
		return systemDao.getAllPostByPager(pager);
	}

	@Override
	public Integer getAllPostAmount() {
		// TODO Auto-generated method stub
		return systemDao.getAllPostAmount();
	}

	@Override
	public List<Post> getPostByDepartmentByPager(Department department, PagerUtil pager) {
		// TODO Auto-generated method stub
		return systemDao.getPostByDepartmentByPager(department, pager);
	}

	@Override
	public Integer getAllPostAmountByDepartment(Department department) {
		// TODO Auto-generated method stub
		return systemDao.getAllPostAmountByDepartment(department);
	}

	@Override
	public List<Category> getAllCategoryByPager(PagerUtil pager) {
		// TODO Auto-generated method stub
		return systemDao.getAllCategoryByPager(pager);
	}

	@Override
	public Integer getAllCategoryAmount() {
		// TODO Auto-generated method stub
		return systemDao.getAllCategoryAmount();
	}

	@Override
	public List<Commodity> getAllCommodityByPager(PagerUtil pager) {
		// TODO Auto-generated method stub
		return systemDao.getAllCommodityByPager(pager);
	}

	@Override
	public Integer getAllCommodityAmount() {
		// TODO Auto-generated method stub
		return systemDao.getAllCombinationAmount();
	}

	@Override
	public List<Commodity> getCommodityByCategoryByPager(Category category, PagerUtil pager) {
		// TODO Auto-generated method stub
		return systemDao.getAllCommodityByPager(pager);
	}

	@Override
	public Integer getAllCommodityAmountByCategory(Category category) {
		// TODO Auto-generated method stub
		return systemDao.getAllCommodityAmountByCategory(category);
	}

}
