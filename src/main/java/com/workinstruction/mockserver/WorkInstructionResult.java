package com.workinstruction.mockserver;

import java.util.ArrayList;

public class WorkInstructionResult {
	String id;
	String pid;
	String uid;
	String type;
	String executestatus;
	String date;
	ArrayList<Executor> executors = new ArrayList<Executor>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getExecutestatus() {
		return executestatus;
	}
	public void setExecutestatus(String executestatus) {
		this.executestatus = executestatus;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public ArrayList<Executor> getExecutors() {
		return executors;
	}
	public void setExecutors(ArrayList<Executor> executors) {
		this.executors = executors;
	}
	@Override
	public String toString() {
		return "WorkInstructionResult [id=" + id + ", pid=" + pid + ", uid=" + uid + ", type=" + type
				+ ", executestatus=" + executestatus + ", date=" + date + ", executors=" + executors + "]";
	}
	
	
}
