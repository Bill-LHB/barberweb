package com.lhb.barber.server;

import java.util.List;

import com.lhb.barber.model.Employee;
import com.lhb.barber.model.Member;
import com.lhb.barber.util.PagerUtil;

public interface MemberServer {
	
	boolean addMember(Member member);// 添加会员

	boolean deleteMember(Member member);// 删除会员

	boolean updateMember(Member member);// 更新会员

	List<Member> getAllMember(int curPage);// 获取所有会员

	List<Member> getMemberByMessage(int curPage,String message);// 通过会员信息获取会员
	Member getMemberById(int Member_id);// 通过会员Id获取会员
}
