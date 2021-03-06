package main.java.es.deusto.server.data;

import javax.jdo.annotations.PersistenceCapable;

import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.Persistent;

@PersistenceCapable (detachable = "true")
public class AccountType {
	
	@PrimaryKey
	private String accountType;
	
	private String description;
	
	public AccountType(String accountType, String description){
		this.accountType = accountType;
		this.description = description;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
