package com.workinstruction.mockserver;

import java.util.ArrayList;
import java.util.HashMap;

public class WorkInstruction {
	String id;
	String pid;
	String uid;
	String type;
	String lastmoddate;
	String workdesc;
	HashMap<String,String> workattrs = new HashMap<String,String>();
	ArrayList<Attachment> attachments = new ArrayList<Attachment>();
	ArrayList<String> executors = new ArrayList<String>();
	
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
	
	public String getLastmoddate() {
		return lastmoddate;
	}
	
	public void setLastmoddate(String lastmoddate) {
		this.lastmoddate = lastmoddate;
	}
	
	public String getWorkdesc() {
		return workdesc;
	}
	
	public void setWorkdesc(String workdesc) {
		this.workdesc = workdesc;
	}
	
	public HashMap<String, String> getWorkattrs() {
		return workattrs;
	}
	
	public void setWorkattrs(HashMap<String, String> workattrs) {
		this.workattrs = workattrs;
	}
	
	public ArrayList<Attachment> getAttachments() {
		return attachments;
	}
	
	public void setAttachments(ArrayList<Attachment> attachments) {
		this.attachments = attachments;
	}
	
	public ArrayList<String> getExecutors() {
		return executors;
	}
	
	public void setExecutors(ArrayList<String> executors) {
		this.executors = executors;
	}
	
	public void addWorkAttribute(String name,String value){
		this.workattrs.put(name, value);
	}
	
	public void addAttachment(Attachment attachment){
		this.attachments.add(attachment);
	}
	
	public void addExecutor(String username){
		this.executors.add(username);
	}
}
