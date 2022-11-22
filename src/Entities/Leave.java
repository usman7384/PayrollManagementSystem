package Entities;

import java.util.Date;

import Entities.Leave.STATUS;

public class Leave {

	private int empID;
	private int NoOfDays;
	private STATUS status;
	private String reason;
	private String date;

	public enum STATUS {
		Accepted, Rejected, Applied
	}

	public int getNoOfDays() {
		return NoOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		NoOfDays = noOfDays;
	}

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public Leave(int empID, int noOfDays, String reason) {
		this.empID = empID;
		this.NoOfDays = noOfDays;
		this.status = STATUS.Applied;
		this.reason = reason;
		this.date = new Date().toGMTString();
	}

	

	public void acceptLeave() {
				this.setStatus(STATUS.Accepted);
	}

	public void rejectLeave() {
				this.setStatus(STATUS.Rejected);
	}

	
	@Override
	public String toString() {
		return "Leave [Employee ID=" +this.empID + ",No. Of Days=" + this.NoOfDays+ " ,Status="+this.getStatus()+ ",Reason=" + this.reason+ ",Date=" + this.date+" ]";
	}
	
}
