
package com.lhb.barber.dao;

import java.util.List;

import com.lhb.barber.model.Combination;
import com.lhb.barber.model.Member;
import com.lhb.barber.model.MenmberGrade;
import com.lhb.barber.model.MenmberMode;
import com.lhb.barber.util.PagerUtil;

public interface MemberDao {

	void addMember(Member member);// 添加会员

	void deleteMember(Member member);// 删除会员

	void updateMember(Member member);// 更新会员

	List<Member> getAllMember(PagerUtil pager);// 分页获取所有会员
	
	List<Member> getAllMember();// 获取所有会员
	
	Integer getAllMemberAmount();//获取所有会员条目数
	
	Member getMemberById(int id);// 通过Id获取会员

	List<Member> getMemberByName(String m_name, PagerUtil pager);// 通过会员名获取会员

	List<Member> getMemberByNumber(String m_number, PagerUtil pager);// 通过会员卡号获取会员

	List<Member> getMemberByPhone(String m_phone, PagerUtil pager);// 通过会员电话获取会员

	List<Member> getMemberByIdentity(String m_identity, PagerUtil pager);// 通过会员身份证号获取会员
	
	List<Member> getMemberByMessage(String message, PagerUtil pager);// 通过会员信息获取会员
	
	
}
