package main.java.es.deusto.server.DTO;

public class AccountDTO {
	
	private String hour;
	private String minute;
	private String day;
	private String month;
	private String year;
	private int amount;
	private int totalAmount;
	private String descriptionUser;
	private String desNegPos;
	
	public AccountDTO(String hour, String minute, String day, String month, String year, int amount, int totalAmount, String descriptionUser, String desNegPos) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.day = day;
		this.month = month;
		this.year = year;
		this.amount = amount;
		this.totalAmount = totalAmount;
		this.descriptionUser = descriptionUser;
		this.desNegPos = desNegPos;
	}

	public String getHour() {
		return hour;
	}
	
	public void setHour(String hour) {
		this.hour = hour;
	}
	
	public String getMinute() {
		return minute;
	}
	
	public void setMinute(String minute) {
		this.minute = minute;
	}
	
	public String getDay() {
		return day;
	}
	
	public void setDay(String day) {
		this.day = day;
	}
	
	public String getMonth() {
		return month;
	}
	
	public void setMonth(String month) {
		this.month = month;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getDescriptionUser() {
		return descriptionUser;
	}

	public void setDescriptionUser(String descriptionUser) {
		this.descriptionUser = descriptionUser;
	}

	public String getDesNegPos() {
		return desNegPos;
	}

	public void setDesNegPos(String desNegPos) {
		this.desNegPos = desNegPos;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}
