package com.workinstruction.mockserver;

public class Executor {
	String name;
	String type;
	String decision;
	String date;
	String comment;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "Executor [name=" + name + ", type=" + type + ", decision=" + decision + ", date=" + date + ", comment="
				+ comment + "]";
	}
	
}
