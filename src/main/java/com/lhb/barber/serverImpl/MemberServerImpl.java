package com.lhb.barber.serverImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lhb.barber.dao.MemberDao;
import com.lhb.barber.dao.SystemDao;
import com.lhb.barber.model.Employee;
import com.lhb.barber.model.Member;
import com.lhb.barber.server.MemberServer;
import com.lhb.barber.util.PagerUtil;

@Service("memberServer")
@Transactional
public class MemberServerImpl  implements MemberServer {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private SystemDao systemDao;
	
	@Override
	public boolean addMember(Member member) {
		// TODO Auto-generated method stub
		PagerUtil pager  =new PagerUtil();
		pager.setCurPage(1);
		if(memberDao.getMemberByNumber(member.getMember_number(), pager)!=null){
			return false;
		}
		if(memberDao.getMemberByPhone(member.getMember_phone(), pager)!=null){
			return false;
		}
		if(memberDao.getMemberByIdentity(member.getMember_identity(), pager)!=null){
			return false;
		}
		memberDao.addMember(member);
		return true;
	}

	@Override
	public boolean deleteMember(Member member) {
		PagerUtil pager  =new PagerUtil();
		pager.setCurPage(1);
		if(memberDao.getMemberById(member.getMember_id())==null){
			return false;
		}	
		memberDao.deleteMember(member);
		return true;
		
	}

	@Override
	public boolean updateMember(Member member) {
		PagerUtil pager  =new PagerUtil();
		pager.setCurPage(1);
		if(memberDao.getMemberById(member.getMember_id())==null){
			return false;
		}	
		memberDao.updateMember(member);
		return true;
		
	}

	@Override
	public List<Member> getAllMember(int curPage) {
		PagerUtil pager  =new PagerUtil();
		// TODO Auto-generated method stub
		pager.setCurPage(curPage);
		return memberDao.getAllMember(pager);
	}

	

	@Override
	public List<Member> getMemberByMessage(int curPage,String message) {
		PagerUtil pager  =new PagerUtil();
		// TODO Auto-generated method stub
		pager.setCurPage(curPage);	
		return memberDao.getMemberByMessage(message, pager);
		
	}

	@Override
	public Member getMemberById(int Member_id) {
		// TODO Auto-generated method stub
		return memberDao.getMemberById(Member_id);
	}

	

}
