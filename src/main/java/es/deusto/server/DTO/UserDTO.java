package main.java.es.deusto.server.DTO;

public class UserDTO {

	String UserID = null;	String password=null;
	String name;
	String surName1;
	String surName2;
	String bankingAccount;
	String address;
	int age;
	int postalCode;
	
	public UserDTO(String userID, String password, String name, String surName1, String surName2, String bankingAccount,
			String address, int age, int postalCode) {
		super();
		UserID = userID;
		this.password = password;
		this.name = name;
		this.surName1 = surName1;
		this.surName2 = surName2;
		this.bankingAccount = bankingAccount;
		this.address = address;
		this.age = age;
		this.postalCode = postalCode;
	}
	
}
