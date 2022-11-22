package Entities;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Attendance {

	private int Empid;
	private String date;
	private LocalTime timeIN;
	private LocalTime timeOUT;
	private long uptime;
	private long downtime;
	private LocalTime closingTime;
	private LocalTime startTime;

	DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");

	public int getId() {
		return Empid;
	}

	public void setId(int id) {
		this.Empid = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public LocalTime getTimeIN() {
		return timeIN;
	}

	public void setTimeIN(LocalTime timeIN) {
		this.timeIN = timeIN;
	}

	public LocalTime getTimeOUT() {
		return timeOUT;
	}

	public void setTimeOUT(LocalTime timeOUT) {
		this.timeOUT = timeOUT;
	}

	public long getUptime() {
		return uptime;
	}

	public void setUptime(long uptime) {
		this.uptime = uptime;
	}

	public long getDowntime() {
		return downtime;
	}

	public void setDowntime(long downtime) {
		this.downtime = downtime;
	}

	public LocalTime getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(LocalTime closingTime) {
		this.closingTime = closingTime;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public Attendance(int id, LocalTime timeIN, LocalTime timeOUT) {
		this.Empid = id;
		this.timeIN = timeIN;
		this.timeOUT = timeOUT;
		this.closingTime = LocalTime.parse("17:00:00");
		this.startTime = LocalTime.parse("08:00:00");
		this.date= new Date().toGMTString();
		this.uptime = this.calculateUptime();
		this.downtime = this.calculateDowntime();
	}


	public long calculateUptime() {
		uptime = Duration.between(closingTime,timeOUT ).toHours();
		return uptime;
	}

	public long calculateDowntime() {
		downtime = (Duration.between(timeIN, startTime).toHours());
		return downtime;
	}

	@Override
	public String toString() {
		return "Attendance [Employee ID=" +this.Empid + ",Time In=" + this.timeIN+ " ,Time Out="+this.timeOUT+ ",Closing Time=" + this.getClosingTime()+ ",Opening Time=" + this.startTime+ ",Date=" + this.date+ ",Uptime=" + this.uptime+ ",DownTime=" + this.downtime+"]";
	}

}
