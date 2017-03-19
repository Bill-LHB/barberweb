package com.lhb.barber.model;

import java.util.Set;

import javax.persistence.Entity;
/**
 * 套餐bean
 * @author Administrator
 *
 */
@Entity
public class MenmberMode {
	private int m_id;
	private String m_name;//优惠方式名称
	
	private int m_isOverlay;//是否叠加运算，1：叠加运算。0：不叠加运算。
	private Set<Combination> combinationSet;//优惠组合方式
	private String m_description;//优惠方式描述
	private Set<Member> memberSet;//会员

	public MenmberMode() {
		super();
	}
	public MenmberMode(int m_id, String m_name, int m_isOverlay) {
		super();
		this.m_id = m_id;
		this.m_name = m_name;
		this.m_isOverlay = m_isOverlay;
	}
	@Override
	public String toString() {
		return "MenmberMode [m_id=" + m_id + ", m_name=" + m_name + ", m_isOverlay=" + m_isOverlay
				  + "]";
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public int getM_isOverlay() {
		return m_isOverlay;
	}
	public void setM_isOverlay(int m_isOverlay) {
		this.m_isOverlay = m_isOverlay;
	}

	public Set<Combination> getCombinationSet() {
		return combinationSet;
	}
	public void setCombinationSet(Set<Combination> combinationSet) {
		this.combinationSet = combinationSet;
	}
	public Set<Member> getMemberSet() {
		return memberSet;
	}
	public void setMemberSet(Set<Member> memberSet) {
		this.memberSet = memberSet;
	}
	public String getM_description() {
		return m_description;
	}
	public void setM_description(String m_description) {
		this.m_description = m_description;
	}	
}
