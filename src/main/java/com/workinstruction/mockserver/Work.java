package com.workinstruction.mockserver;

import java.util.ArrayList;

public class Work {

	String workid;
	String worktype;
	ArrayList<WorkInstruction> workinstructions = new ArrayList<WorkInstruction>();
	
	public String getWorkid() {
		return workid;
	}
	public void setWorkid(String workid) {
		this.workid = workid;
	}
	public String getWorktype() {
		return worktype;
	}
	public void setWorktype(String worktype) {
		this.worktype = worktype;
	}

	public ArrayList<WorkInstruction> getWorkinstructions() {
		return workinstructions;
	}
	
	public void setWorkinstructions(ArrayList<WorkInstruction> workinstructions) {
		this.workinstructions = workinstructions;
	}
	
	public void addWorkInstruction(WorkInstruction workinstruction){
		this.workinstructions.add(workinstruction);
	}
	
}
