package Entities;

import java.util.ArrayList;

public class AttendanceLog {

	private ArrayList<Attendance> attendancelog;

	public ArrayList<Attendance> getAttendancelog() {
		return attendancelog;
	}

	public void setAttendancelog(ArrayList<Attendance> attendancelog) {
		this.attendancelog = attendancelog;
	}

	public void addAttendance(Attendance e) {
		attendancelog.add(e);
	}
	
	

	public AttendanceLog() {
		this.attendancelog = new ArrayList<Attendance>();
	}

	public ArrayList<Attendance> searchAttendance(int Empid) {
		ArrayList<Attendance> attendanceLog = null;
		for (Attendance var : this.attendancelog) {
			if (Empid == var.getId()) {
				attendanceLog.add(var);
			}
		}
		return attendanceLog;
	}

	public long getTotalUpTime(int empID) {
		long uptime = 0;
		for (Attendance e : this.getAttendancelog()) {
			if (e.getId() == empID) {
				uptime = uptime + e.getUptime();
			}
		}
		return uptime;
	}

	public long getTotalDownTime(int empID) {
		long downTime = 0;
		for (Attendance e : this.getAttendancelog()) {
			if (e.getId() == empID) {
				downTime = downTime + e.getDowntime();
			}
		}
		return downTime;
	}

	public void viewAllAttendances() {
		for (Attendance a : this.attendancelog) {
			System.out.println(a.toString());
		}
	}
}
