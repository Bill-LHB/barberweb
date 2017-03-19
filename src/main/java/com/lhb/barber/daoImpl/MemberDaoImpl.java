package com.lhb.barber.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lhb.barber.MyHibernateDaoSupport;
import com.lhb.barber.dao.MemberDao;
import com.lhb.barber.model.Combination;
import com.lhb.barber.model.Member;
import com.lhb.barber.model.MenmberGrade;
import com.lhb.barber.model.MenmberMode;
import com.lhb.barber.model.User;
import com.lhb.barber.util.PagerUtil;

@Repository("memberDao")
public class MemberDaoImpl extends MyHibernateDaoSupport implements MemberDao {

	@Override
	public void addMember(Member member) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(member);
	}

	@Override
	public void deleteMember(Member member) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(member);
	}

	@Override
	public void updateMember(Member member) {
		// TODO Auto-generated method stub
		Member m=getMemberById(member.getMember_id());
		m.setMember_address(member.getMember_address());
		m.setMember_birthday(member.getMember_birthday());
		m.setMember_grade(member.getMember_grade());
		m.setMember_id(member.getMember_id());
		m.setMember_identity(member.getMember_identity());
		m.setMember_integral(member.getMember_integral());
		m.setMember_mode(member.getMember_mode());
		m.setMember_money(member.getMember_money());
		m.setMember_name(member.getMember_name());
		m.setMember_number(member.getMember_number());
		m.setMember_password(member.getMember_password());
		m.setMember_phone(member.getMember_phone());
		m.setHeadurl(member.getHeadurl());
		m.setMember_register(member.getMember_register());
		m.setMember_remark(member.getMember_remark());
		m.setMember_sex(member.getMember_sex());
		m.setMember_status(member.getMember_status());
		m.setOrderSet(member.getOrderSet());
		getHibernateTemplate().update(m);
	}

	@Override
	public List<Member> getAllMember(PagerUtil pager) {
		// TODO Auto-generated method stub
		String hql = "from Member";
		return getListByPage(hql, pager);
	}

	@Override
	public List<Member> getMemberByName(String m_name, PagerUtil pager) {
		// TODO Auto-generated method stub
		String hql = "from Member m where m.Member_name =?";
		return getListByPage(hql, pager, m_name);
	}

	@Override
	public List<Member> getMemberByNumber(String m_number, PagerUtil pager) {
		// TODO Auto-generated method stub
		String hql = "from Member m where m.Member_number =?";
		return getListByPage(hql, pager, m_number);
	}

	@Override
	public List<Member> getMemberByPhone(String m_phone, PagerUtil pager) {
		// TODO Auto-generated method stub
		String hql = "from Member m where m.Member_phone =?";
		return getListByPage(hql, pager, m_phone);
	}

	@Override
	public List<Member> getMemberByIdentity(String m_identity, PagerUtil pager) {
		// TODO Auto-generated method stub
		String hql = "from Member m where m.Member_identity =?";
		return getListByPage(hql, pager, m_identity);
	}

	@Override
	public List<Member> getMemberByMessage(String message, PagerUtil pager) {
		// TODO Auto-generated method stub
		String hql = "from Member m where m.Member_number =? or m.Member_name =? or m.Member_identity =? or m.Member_phone =?";
		return getListByPage(hql, pager, message, message, message, message);
	}

	@Override
	public List<Member> getAllMember() {
		// TODO Auto-generated method stub
		String hql = "from Member";
		return (List<Member>) getHibernateTemplate().find(hql);
	}

	@Override
	public Member getMemberById(int id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Member.class, id);
	}

	@Override
	public Integer getAllMemberAmount() {
		// TODO Auto-generated method stub
		String hql = "from Member";
		return getCount(hql);
	}

}
