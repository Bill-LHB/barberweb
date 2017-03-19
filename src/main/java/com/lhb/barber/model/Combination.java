package com.lhb.barber.model;

import javax.persistence.Entity;

/**
 * 
 * @author Administrator
 *
 */
@Entity
public class Combination{
	private int combination_id;
	private int combination_number;
	private String combination_money;//金额标准
	private String combination_ratio;//优惠比例
	private String combination_extra;//额外金额
	private String description;//描述
	private MenmberMode menmberMode;//套餐

	
	public Combination(int combination_id, String combination_money, String combination_ratio,
			String combination_extra) {
	
		this.combination_id = combination_id;
		this.combination_money = combination_money;
		this.combination_ratio = combination_ratio;
		this.combination_extra = combination_extra;
	}
	public Combination() {
		super();
	}
	@Override
	public String toString() {
		return "Combination [combination_id=" + combination_id + ", combination_money=" + combination_money
				+ ", combination_ratio=" + combination_ratio + ", combination_extra=" + combination_extra + "]";
	}
	public int getCombination_id() {
		return combination_id;
	}
	public void setCombination_id(int combination_id) {
		this.combination_id = combination_id;
	}
	public String getCombination_money() {
		return combination_money;
	}
	public void setCombination_money(String combination_money) {
		this.combination_money = combination_money;
	}
	public String getCombination_ratio() {
		return combination_ratio;
	}
	public void setCombination_ratio(String combination_ratio) {
		this.combination_ratio = combination_ratio;
	}
	public String getCombination_extra() {
		return combination_extra;
	}
	public void setCombination_extra(String combination_extra) {
		this.combination_extra = combination_extra;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public MenmberMode getMenmberMode() {
		return menmberMode;
	}
	public void setMenmberMode(MenmberMode menmberMode) {
		this.menmberMode = menmberMode;
	}
	public int getCombination_number() {
		return combination_number;
	}
	public void setCombination_number(int combination_number) {
		this.combination_number = combination_number;
	}

	
	
}
