package main.java.es.deusto.server.data;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.Persistent;

@PersistenceCapable (detachable = "true")
public class AccountType {
	
	@PrimaryKey
	private int ID;
	
	private String accountType;
	
	public AccountType(String accountType){
		this.accountType = accountType;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
}
