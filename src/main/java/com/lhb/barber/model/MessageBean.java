package com.lhb.barber.model;

import javax.persistence.Entity;

@Entity
public class MessageBean {
private String operation;

public MessageBean() {
	super();
}
public String getOperation() {
	return operation;
}
public void setOperation(String operation) {
	this.operation = operation;
}



}
