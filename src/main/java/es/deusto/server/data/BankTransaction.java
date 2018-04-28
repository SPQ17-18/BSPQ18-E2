package main.java.es.deusto.server.data;


import java.util.Date;

public class BankTransaction {

	private String sourceId;
	private String targetId;
	private int amount;
	private String desc;
	private Date date;

	
	public BankTransaction(String sourceId, String targetId, int amount, String desc, Date date) {
		super();
		this.sourceId= sourceId;
		this.targetId = targetId;
		this.amount = amount;
		this.desc = desc;
		this.date = date;
	}
	
	//GETTERS AND SETTERS

	public String getSourceId() {return sourceId;}
	public void setSourceId(String sourceId) {this.sourceId = sourceId;}
	
	public String getTargetId() {return targetId;}
	public void seTargetId(String targetId) {this.targetId = targetId;}

	public int getAmount() {return amount;}
	public void setAmount(int amount) {this.amount = amount;}

	public String getDesc() {return desc;}
	public void setDesc(String desc) {this.desc = desc;}

	public Date getDate() {return date;}
	public void setDate(Date date) {this.date = date;}
	
}
