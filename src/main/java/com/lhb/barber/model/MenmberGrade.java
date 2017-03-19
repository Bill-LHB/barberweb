package com.lhb.barber.model;

import java.util.Set;

import javax.persistence.Entity;

/**
 * 会员等级bean
 * @author Administrator
 *
 */
@Entity
public class MenmberGrade {
	private int menmberGrade_id;//等级id
	private String menmberGrade_name;//等级名称
	private String menmberGrade_discount;//等级折扣
	private String menmberGrade_description;//等级描述
	private Set<Member> memberSet;//会员

	public MenmberGrade(int menmberGrade_id, String menmberGrade_name, String menmberGrade_discount) {
		super();
		this.menmberGrade_id = menmberGrade_id;
		this.menmberGrade_name = menmberGrade_name;
		this.menmberGrade_discount = menmberGrade_discount;
	}

	public int getMenmberGrade_id() {
		return menmberGrade_id;
	}

	public void setMenmberGrade_id(int menmberGrade_id) {
		this.menmberGrade_id = menmberGrade_id;
	}

	public String getMenmberGrade_name() {
		return menmberGrade_name;
	}

	public void setMenmberGrade_name(String menmberGrade_name) {
		this.menmberGrade_name = menmberGrade_name;
	}

	public String getMenmberGrade_discount() {
		return menmberGrade_discount;
	}

	public void setMenmberGrade_discount(String menmberGrade_discount) {
		this.menmberGrade_discount = menmberGrade_discount;
	}

	public String getMenmberGrade_description() {
		return menmberGrade_description;
	}

	

	public Set<Member> getMemberSet() {
		return memberSet;
	}

	public void setMemberSet(Set<Member> memberSet) {
		this.memberSet = memberSet;
	}

	public void setMenmberGrade_description(String menmberGrade_description) {
		this.menmberGrade_description = menmberGrade_description;
	}



	public MenmberGrade() {
		super();
	}	
	
}
