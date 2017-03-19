package com.lhb.barber;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.lhb.barber.util.PagerUtil;

public class MyHibernateDaoSupport extends HibernateDaoSupport {
	@Resource(name = "sessionFactory") // 为父类HibernateDaoSupport注入sessionFactory的值
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	/**
	 * Hibernate实现分页技术
	 * 
	 * @param hql
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	private List getListByPage(final String hql, final int offset, final int pageSize, String...parameter) {
		List lists = getHibernateTemplate().execute(new HibernateCallback<List>() {
			@Override
			public List doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(hql);
				for (int i = 0; i <  parameter.length; i++) { 
					query.setString(i,parameter[i]); 
			    } 		
				query.setFirstResult(offset).setMaxResults(pageSize);
				List lists = query.list();
				return lists;
			}
		});
		return lists;
	}
	protected List getListByPage(String hql, PagerUtil pager,String...parameter){		
		return getListByPage(hql,pager.getIStart(), pager.getIStep(),parameter);
	}
	
	/**
	 * 获取查询结果行数
	 * @param hql
	 * @return
	 */
	protected Integer getCount(String hql,String ...parameter) {
		String h="select count(*) "+hql;
		Integer count = (Integer) getHibernateTemplate().execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException {				
				Query query=session.createQuery(h);			
				for(int i=0;i<parameter.length;i++){
					query.setString(i,parameter[i]);
				}	
				
				return new Long((long) query.uniqueResult()).intValue();
			}
		});
		return (Integer)count;
	}
}
