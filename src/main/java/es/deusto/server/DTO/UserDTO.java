package main.java.es.deusto.server.DTO;

public class UserDTO {

	String UserID = null;	String password=null;
	String name;
	String surName1;
	String surName2;
	String bankingAccount;
	int age;
	int postalCode;
	
	//CONSTRUCTOR
	public UserDTO(String userID, String password, String name, String surName1, String surName2, String bankingAccount,
			 int age, int postalCode) {
		super();
		UserID = userID;
		this.password = password;
		this.name = name;
		this.surName1 = surName1;
		this.surName2 = surName2;
		this.bankingAccount = bankingAccount;
		this.age = age;
		this.postalCode = postalCode;
	}

	//GETTERS AND SETTERS
	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName1() {
		return surName1;
	}

	public void setSurName1(String surName1) {
		this.surName1 = surName1;
	}

	public String getSurName2() {
		return surName2;
	}

	public void setSurName2(String surName2) {
		this.surName2 = surName2;
	}

	public String getBankingAccount() {
		return bankingAccount;
	}

	public void setBankingAccount(String bankingAccount) {
		this.bankingAccount = bankingAccount;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	
	
}
