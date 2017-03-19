package com.lhb.barber.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
/**
 * 会员Bean类
 * @author Administrator
 *
 */
@Entity
public class Member {
	private int member_id;
	private String member_number;//会员卡号
	private String member_name;//会员姓名
	private String member_money;//会员卡金额
	private String member_password;//密码
	private String member_sex;//会员性别
	private String member_identity;//会员身份证号
	private String member_phone;//会员电话
	private Date member_register;//注册时间
	private int member_integral;//累计积分
	
	private Date member_birthday;//会员生日
	private String member_address;//会员住址
	private String headurl;//会员头像
	private String member_remark;//备注
	
	private int member_status;//会员卡状态 0：挂失 1：可用
	private MenmberMode member_mode;//充费优惠套餐
	private MenmberGrade member_grade;//会员等级
	private Set<Order> orderSet;//订单

	public Member(int member_id, String member_number, String member_name, String member_money, String member_password,
			String member_sex, String member_identity, String member_phone, Date member_register, int member_integral) {
		super();
		this.member_id = member_id;
		this.member_number = member_number;
		this.member_name = member_name;
		this.member_money = member_money;
		this.member_password = member_password;
		this.member_sex = member_sex;
		this.member_identity = member_identity;
		this.member_phone = member_phone;
		this.member_register = member_register;
		this.member_integral = member_integral;
	}

	@Override
	public String toString() {
		return "Member [member_id=" + member_id + ", member_number=" + member_number + ", member_name=" + member_name
				+ ", member_money=" + member_money + ", member_password=" + member_password + ", member_sex="
				+ member_sex + ", member_identity=" + member_identity + ", member_phone=" + member_phone
				+ ", member_register=" + member_register + ", member_integral=" + member_integral + "]";
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public String getMember_number() {
		return member_number;
	}

	public void setMember_number(String member_number) {
		this.member_number = member_number;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_money() {
		return member_money;
	}

	public void setMember_money(String member_money) {
		this.member_money = member_money;
	}

	public String getMember_password() {
		return member_password;
	}

	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}

	public String getMember_sex() {
		return member_sex;
	}

	public void setMember_sex(String member_sex) {
		this.member_sex = member_sex;
	}

	public String getMember_identity() {
		return member_identity;
	}

	public void setMember_identity(String member_identity) {
		this.member_identity = member_identity;
	}

	public String getMember_phone() {
		return member_phone;
	}

	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}

	public Date getMember_register() {
		return member_register;
	}

	public void setMember_register(Date member_register) {
		this.member_register = member_register;
	}

	public int getMember_integral() {
		return member_integral;
	}

	public void setMember_integral(int member_integral) {
		this.member_integral = member_integral;
	}

	public Date getMember_birthday() {
		return member_birthday;
	}

	public void setMember_birthday(Date member_birthday) {
		this.member_birthday = member_birthday;
	}

	public String getMember_address() {
		return member_address;
	}

	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}

	public String getHeadurl() {
		return headurl;
	}

	public void setHeadurl(String member_portrait) {
		this.headurl = member_portrait;
	}

	public String getMember_remark() {
		return member_remark;
	}

	public void setMember_remark(String member_remark) {
		this.member_remark = member_remark;
	}



	public int getMember_status() {
		return member_status;
	}

	public void setMember_status(int member_status) {
		this.member_status = member_status;
	}

	public MenmberMode getMember_mode() {
		return member_mode;
	}

	public void setMember_mode(MenmberMode member_mode) {
		this.member_mode = member_mode;
	}

	public MenmberGrade getMember_grade() {
		return member_grade;
	}

	public void setMember_grade(MenmberGrade member_grade) {
		this.member_grade = member_grade;
	}

	

	public Set<Order> getOrderSet() {
		return orderSet;
	}

	public void setOrderSet(Set<Order> orderSet) {
		this.orderSet = orderSet;
	}

	public Member() {
		super();
	}
	

	

	
}
