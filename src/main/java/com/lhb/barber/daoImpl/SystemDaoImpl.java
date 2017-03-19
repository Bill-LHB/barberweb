package com.lhb.barber.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lhb.barber.MyHibernateDaoSupport;
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
import com.lhb.barber.util.HibernateUtil;
import com.lhb.barber.util.PagerUtil;

@Transactional(readOnly = false)
@Repository("systemDao")
public class SystemDaoImpl extends MyHibernateDaoSupport implements SystemDao {
	@Override
	public void addRole(Role role) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(role);
	}

	@Override
	public void deleteRole(Role role) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(role);
	}

	@Override
	public void updateRole(Role role) {
		// TODO Auto-generated method stub
		Role r = getRoleById(role.getRole_id());
		r.setDescription(role.getDescription());
		r.setFunctionSet(role.getFunctionSet());
		r.setName(role.getName());
		r.setUserSet(role.getUserSet());
		r.setRole_id(role.getRole_id());
		getHibernateTemplate().update(r);
	}

	@Override
	public List<Role> getRoleByName(String name) {
		// TODO Auto-generated method stub
		String hql = "from Role r where r.name =?";
		return (List<Role>) getHibernateTemplate().find(hql, name);
	}

	@Override
	public Role getRoleById(int id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Role.class, id);
	}

	@Override
	public List<Role> getAllRole() {
		// TODO Auto-generated method stub
		String hql = "from Role";
		return (List<Role>) getHibernateTemplate().find(hql);
	}

	@Override
	public List<Role> getAllRoleByPager(PagerUtil pager) {// 分页获取所有角色
		String hql = "from Role";
		return getListByPage(hql, pager);

	}

	@Override
	public Integer getAllRolesAmount() {// 获取所有角色条目数
		String hql = "from Role";
		return getCount(hql);
	}

	@Override
	public void addModules(Modules modules) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(modules);
	}

	@Override
	public void deleteModules(Modules modules) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(modules);
	}

	@Override
	public void updateModules(Modules modules) {
		// TODO Auto-generated method stub
		Modules m = getModulesById(modules.getModules_id());
		m.setModules_id(modules.getModules_id());
		m.setName(modules.getName());
		m.setDescription(modules.getDescription());
		m.setFunctionSet(modules.getFunctionSet());
		getHibernateTemplate().update(m);
	}

	@Override
	public List<Modules> getModulesByName(String name) {
		// TODO Auto-generated method stub
		String hql = "from Modules m where m.name =?";
		return (List<Modules>) getHibernateTemplate().find(hql, name);

	}

	@Override
	public List<Modules> getAllModules() {
		// TODO Auto-generated method stub
		String hql = "from Modules";
		return (List<Modules>) getHibernateTemplate().find(hql);
	}

	@Override
	public Modules getModulesById(int id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Modules.class, id);
	}

	@Override
	public List<Modules> getAllModulesByPager(PagerUtil pager) {// 分页获取所有模块
		String hql = "from Modules";
		return getListByPage(hql, pager);
	}

	@Override
	public Integer getAllModulesAmount() {// 获取所有模块条目数
		String hql = "from Modules";		
		int i= getCount(hql);
		System.out.println(i+"------------------");
		return i;
	}

	@Override
	public void addFunction(Function function) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(function);
	}

	@Override
	public void deleteFunction(Function function) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(function);
	}

	@Override
	public void updateFunction(Function function) {
		// TODO Auto-generated method stub
		Function f = getFunctionById(function.getFunction_id());
		f.setDescription(function.getDescription());
		f.setFunction_code(function.getFunction_code());
		f.setFunction_id(function.getFunction_id());
		f.setModules(function.getModules());
		f.setName(function.getName());
		f.setRoleSet(function.getRoleSet());
		getHibernateTemplate().update(f);
	}

	@Override
	public List<Function> getFunctionByModulesAndName(Modules modules, String name) {
		// TODO Auto-generated method stub
		String hql = "from Function f where f.modules.name=? and f.name =?";
		return (List<Function>) getHibernateTemplate().find(hql, modules, name);
	}

	@Override
	public Function getFunctionById(int id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Function.class, id);
	}

	@Override
	public List<Function> getAllFunction() {
		// TODO Auto-generated method stub
		String hql = "from Function";
		return (List<Function>) getHibernateTemplate().find(hql);
	}

	@Override
	public Integer getAllFunctionAmount() {
		String hql = "from Function";
		
		int i= getCount(hql);
		System.out.println(i+"****************");
		return 10;
	}

	@Override
	public List<Function> getFunctionByModulesByPager(Modules modules, PagerUtil pager) {
		// TODO Auto-generated method stub
		String hql = "from Function f where f.modules.name=? ";
		return getListByPage(hql, pager, modules.getName());
	}

	@Override
	public Integer getAllFunctionAmountByModules(Modules modules) {
		String hql = "from Function f where f.modules.name=? ";
		return getCount(hql, modules.getName());

	}

	@Override
	public List<Function> getAllFunctionByPager(PagerUtil pager) {
		String hql = "from Function";
		return getListByPage(hql, pager);

	}

	@Override
	public void addCombination(Combination combination) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(combination);
	}

	@Override
	public void deleteCombination(Combination combination) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(combination);
	}

	@Override
	public void updateCombination(Combination combination) {
		// TODO Auto-generated method stub
		Combination c = getCombinationById(combination.getCombination_id());
		c.setCombination_extra(combination.getCombination_extra());
		c.setCombination_id(combination.getCombination_id());
		c.setCombination_money(combination.getCombination_money());
		c.setCombination_ratio(combination.getCombination_ratio());
		c.setDescription(combination.getDescription());
		c.setMenmberMode(combination.getMenmberMode());
		getHibernateTemplate().update(c);
	}

	@Override
	public Combination getCombinationById(int id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Combination.class, id);
	}

	@Override
	public Combination getCombinationByNumber(int number) {
		// TODO Auto-generated method stub
		Combination combination = null;
		String hql = "from Combination c where c.combination_number =?";
		List<Combination> c = (List<Combination>) getHibernateTemplate().find(hql, number);
		if (c != null && c.size() > 0) {
			combination = c.get(0);
		}
		return combination;
	}

	@Override
	public Integer getCombinationMaxNumber() {
		// TODO Auto-generated method stub
		String hql = "select max(c.combination_number) from Combination c";
		return (Integer) HibernateUtil.getSession().createQuery(hql).uniqueResult();
	}

	@Override
	public List<Combination> getAllCombination() {
		// TODO Auto-generated method stub
		String hql = "from Combination";
		return (List<Combination>) getHibernateTemplate().find(hql);
	}

	@Override
	public List<Combination> getAllCombinationByPager(PagerUtil pager) {// 分页获取所有优惠方式
		String hql = "from Combination";
		return getListByPage(hql, pager);
	}

	@Override
	public Integer getAllCombinationAmount() {// 获取所有优惠方式条目数
		String hql = "from Combination";
		return getCount(hql);
	}

	@Override
	public List<Combination> getCombinationByMenmberModeByPager(MenmberMode menmberMode, PagerUtil pager) {// 分页技术通过套餐获取优惠方式
		String hql = "from Combination c where c.menmberMode.m_name=?";
		return getListByPage(hql, pager, menmberMode.getM_name());
	}

	@Override
	public Integer getAllCombinationAmountByMenmberMode(MenmberMode menmberMode) {// 获取套餐内所有优惠方式条目数
		String hql = "from Combination c where c.menmberMode.m_name=?";
		return getCount(hql, menmberMode.getM_name());
	}

	@Override
	public void addDepartment(Department department) {
		// TODO Auto-generated method stub

		getHibernateTemplate().save(department);
	}

	@Override
	public void deleteDepartment(Department department) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(department);
	}

	@Override
	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub
		Department d = getDepartmentById(department.getDepartment_id());
		d.setDepartment_id(department.getDepartment_id());
		d.setDescription(department.getDescription());
		d.setName(department.getName());
		d.setPostSet(department.getPostSet());
		getHibernateTemplate().update(d);
	}

	@Override
	public List<Department> getDepartmentByName(String name) {
		// TODO Auto-generated method stub
		String hql = "from Department d where d.name =?";
		return (List<Department>) getHibernateTemplate().find(hql, name);
	}

	@Override
	public Department getDepartmentById(int id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Department.class, id);
	}

	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		String hql = "from Department";
		return (List<Department>) getHibernateTemplate().find(hql);
	}

	@Override
	public List<Department> getAllDepartmentByPager(PagerUtil pager) {// 分页获取所有部门
		String hql = "from Department";
		return getListByPage(hql, pager);

	}

	@Override
	public Integer getAllDepartmentAmount() {// 获取部门 条目数
		String hql = "from Department";
		return getCount(hql);

	}

	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(category);
	}

	@Override
	public void deleteCategory(Category category) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(category);
	}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		Category c = getCategoryById(category.getCategory_id());
		c.setCategory_id(category.getCategory_id());
		c.setCategory_name(category.getCategory_name());
		c.setCategory_number(category.getCategory_number());
		c.setCommoditySet(category.getCommoditySet());
		c.setDescription(category.getDescription());
		getHibernateTemplate().update(c);
	}

	@Override
	public List<Category> getCategoryByName(String name) {
		// TODO Auto-generated method stub
		String hql = "from Category c where c.category_name =?";
		return (List<Category>) getHibernateTemplate().find(hql, name);
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		String hql = "from Category";
		return (List<Category>) getHibernateTemplate().find(hql);
	}

	@Override
	public List<Category> getAllCategoryByPager(PagerUtil pager) {// 分页获取服务类别
		String hql = "from Category";
		return getListByPage(hql, pager);
	}

	@Override
	public Integer getAllCategoryAmount() {// 获取服务类别条目数
		String hql = "from Category";
		return getCount(hql);

	}

	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Category.class, id);
	}

	@Override
	public void addPost(Post post) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(post);
	}

	@Override
	public void deletePost(Post post) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(post);
	}

	@Override
	public void updatePost(Post post) {
		// TODO Auto-generated method stub
		Post p = getPostById(post.getPost_id());
		p.setDepartment(post.getDepartment());
		p.setDescription(post.getDescription());
		p.setEmployeeSet(post.getEmployeeSet());
		p.setPost_id(post.getPost_id());
		p.setPost_name(post.getPost_name());
		p.setPost_wage(post.getPost_wage());
		getHibernateTemplate().update(p);
	}

	@Override
	public List<Post> getPostByName(String name) {
		// TODO Auto-generated method stub
		String hql = "from Post p where p.post_name =?";
		return (List<Post>) getHibernateTemplate().find(hql, name);
	}

	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		String hql = "from Post";
		return (List<Post>) getHibernateTemplate().find(hql);
	}

	@Override
	public List<Post> getAllPostByPager(PagerUtil pager) {// 分页获取职位
		String hql = "from Post";
		return getListByPage(hql, pager);

	}

	@Override
	public Integer getAllPostAmount() {// 获取职位条目数
		String hql = "from Post";
		return getCount(hql);

	}

	@Override
	public List<Post> getPostByDepartmentByPager(Department department, PagerUtil pager) {// 分页技术通过部门获取职位
		String hql = "from Post p where p.department.name =?";

		return getListByPage(hql, pager, department.getName());

	}

	@Override
	public Integer getAllPostAmountByDepartment(Department department) {// 获取部门内所有职位条目数
		String hql = "from Post p where p.department.name =?";

		return getCount(hql, department.getName());

	}

	@Override
	public Post getPostById(int id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Post.class, id);
	}

	@Override
	public void addMenmberMode(MenmberMode menmberMode) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(menmberMode);
	}

	@Override
	public void deleteMenmberMode(MenmberMode menmberMode) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(menmberMode);
	}

	@Override
	public void updateMenmberMode(MenmberMode menmberMode) {
		// TODO Auto-generated method stub
		MenmberMode m = getMenmberModeById(menmberMode.getM_id());
		m.setCombinationSet(menmberMode.getCombinationSet());
		m.setM_description(menmberMode.getM_description());
		m.setM_id(menmberMode.getM_id());
		m.setM_isOverlay(menmberMode.getM_isOverlay());
		m.setM_name(menmberMode.getM_name());
		m.setMemberSet(menmberMode.getMemberSet());
		getHibernateTemplate().update(m);
	}

	@Override
	public MenmberMode getMenmberModeById(int id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(MenmberMode.class, id);
	}

	@Override
	public List<MenmberMode> getMenmberModeByName(String m_name) {
		// TODO Auto-generated method stub
		String hql = "from MenmberMode M where M.m_name =?";
		return (List<MenmberMode>) getHibernateTemplate().find(hql, m_name);
	}

	@Override
	public List<MenmberMode> getAllMenmberMode() {
		// TODO Auto-generated method stub
		String hql = "from MenmberMode";
		return (List<MenmberMode>) getHibernateTemplate().find(hql);
	}

	@Override
	public List<MenmberMode> getAllMenmberModeByPager(PagerUtil pager) {
		String hql = "from MenmberMode";
		return getListByPage(hql, pager);
	}

	@Override
	public Integer getAllMenmberModeAmount() {// 获取所有优惠套餐条目数
		String hql = "from MenmberMode";
		return getCount(hql);
	}

	@Override
	public void addCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(commodity);
	}

	@Override
	public void deleteCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(commodity);
	}

	@Override
	public void updateCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		Commodity c = getCommodityById(commodity.getCommodity_id());
		c.setCommodity_category(commodity.getCommodity_category());
		c.setCommodity_commission(commodity.getCommodity_commission());
		c.setCommodity_id(commodity.getCommodity_id());
		c.setCommodity_mindiscount(commodity.getCommodity_mindiscount());
		c.setCommodity_name(commodity.getCommodity_name());
		c.setCommodity_number(commodity.getCommodity_number());
		c.setCommodity_purchase(commodity.getCommodity_purchase());
		c.setCommodity_quantity(commodity.getCommodity_quantity());
		c.setCommodity_ratio(commodity.getCommodity_ratio());
		c.setCommodity_selling(commodity.getCommodity_selling());
		c.setDescription(commodity.getDescription());
		c.setEmployeeSet(commodity.getEmployeeSet());
		c.setOrderSet(commodity.getOrderSet());
		getHibernateTemplate().update(c);
	}

	@Override
	public List<Commodity> getCommodityByName(String name) {
		// TODO Auto-generated method stub
		String hql = "from Commodity c where c.commodity_name =?";
		return (List<Commodity>) getHibernateTemplate().find(hql, name);
	}

	@Override
	public List<Commodity> getAllCommodity() {
		// TODO Auto-generated method stub
		String hql = "from Commodity";
		return (List<Commodity>) getHibernateTemplate().find(hql);
	}

	@Override
	public Commodity getCommodityById(int id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Commodity.class, id);
	}

	@Override
	public List<Commodity> getAllCommodityByPager(PagerUtil pager) {// 分页获取产品
		String hql = "from Commodity";
		return getListByPage(hql, pager);

	}

	@Override
	public Integer getAllCommodityAmount() {// 获取产品条目数
		String hql = "from Commodity";
		return getCount(hql);

	}

	@Override
	public List<Commodity> getCommodityByCategoryByPager(Category category, PagerUtil pager) {// 分页技术通过产品类别获取产品
		String hql = "from Commodity c where c.commodity_category.category_name=?";
		return getListByPage(hql, pager, category.getCategory_name());

	}

	@Override
	public Integer getAllCommodityAmountByCategory(Category category) {// 获取产品类别内所有产品条目数
		String hql = "from Commodity c where c.commodity_category.category_name=?";
		return getCount(hql, category.getCategory_name());

	}
}
