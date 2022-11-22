package Entities;

import java.util.ArrayList;

import Entities.Leave.STATUS;

public class LeaveLedger {

	private ArrayList<Leave> leaves;
	private int NoOfLeaves;

	public ArrayList<Leave> getLeaves() {
		return leaves;
	}

	public void setLeaves(ArrayList<Leave> leaves) {
		this.leaves = leaves;
	}

	public int getNoOfLeaves() {
		return NoOfLeaves;
	}

	public void setNoOfLeaves(int noOfLeaves) {
		NoOfLeaves = noOfLeaves;
	}

	public LeaveLedger() {
		this.leaves = new ArrayList<Leave>();
		this.NoOfLeaves=this.leaves.size();
	}

	public void addLeave(Leave l) {
		this.leaves.add(l);
	}

	public void acceptLeave(int empID) {
		for (Leave e : this.leaves) {
			if (e.getEmpID() == empID) {
				e.setStatus(STATUS.Accepted);
			}
		}
	}

	public void rejectLeave(int empID) {
		for (Leave e : this.leaves) {
			if (e.getEmpID() == empID) {
				e.setStatus(STATUS.Rejected);
			}
		}
	}

	public void viewAllLeaves() {
		for (Leave l : this.leaves) {
			System.out.println(l.toString());
		}
	}

}
