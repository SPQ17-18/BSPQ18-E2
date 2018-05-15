
package main.java.es.deusto.server.DTO;

public class AccountTypeDTO {

	private String accountType;
	private String description;
	
	public AccountTypeDTO(String accountType, String description){
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