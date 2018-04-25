package main.java.es.deusto.server.DTO;

import java.util.Date;

public class BankTransactionDTO {
	
	private String user1Dni;
	private String user2Dni;
	private int amount;
	private String desc;
	private Date date;
	
	//CONSTRUCTOR
	public BankTransactionDTO(String u1Dni, String u2Dni, int amount, String desc, Date d) {
		super();
		this.user1Dni = u1Dni;
		this.user2Dni = u2Dni;
		this.amount = amount;
		this.date = d;
		this.desc = desc;
	}

	public String getUser1Dni() {return user1Dni;}
	public void setUser1Dni(String user1Dni) {this.user1Dni = user1Dni;}

	public String getUser2Dni() {return user2Dni;}
	public void setUser2Dni(String user2Dni) {this.user2Dni = user2Dni;	}

	public int getAmount() {return amount;}
	public void setAmount(int amount) {this.amount = amount;}

	public String getDesc() {return desc;}
	public void setDesc(String desc) {this.desc = desc;}

	public Date getDate() {return date;}
	public void setDate(Date date) {this.date = date;}

}
