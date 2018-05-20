package main.java.es.deusto.server.dao;

import java.util.Date;
import java.util.List;

import main.java.es.deusto.server.data.Account;
import main.java.es.deusto.server.data.AccountType;
import main.java.es.deusto.server.data.BankTransaction;
import main.java.es.deusto.server.data.User;

public interface IBankingSystemDAO {


	public void newUser(User u);
	public void newUserAccount (Account a);
	public boolean checkUser(String uID);
	public boolean logIn(String uID, String password);
	public String forgetPassword(String UserID, String email);
	public boolean changePassword(String oldPassword, String newPassword);
	public boolean transaction(String originBankingAccount, String targetBankingAccount, int amount);
	public boolean insertMoney(String targetBankingAccount, int amount);
	public boolean drawMoney(String targetBankingAccount, int amount);
	public List<Account> getUserAccounts();
	public List<User> showUserInfo();
	public void changeUserInfo(User u);
	public boolean newBankTransaction( String sourceBankingAccount, String targetBankingAccount, int amount, String desc);
	public List<BankTransaction> getBankTransactions(String accountID);
	
	//DIRECTOR METHODS
	public boolean createAccountType(AccountType at); //ACCOUNT TYPE -> NAME + DESCRIPTION
	public List<AccountType> getAllAccountTypes();
	//public boolean eraseOneUser(); IGUAL ES MEJOR BORRAR UN ACCOUNTTYPE
	public List<Account> getAllAccountsForDirector();
	public boolean freezeAccount(String bankingAccount);
	public boolean unfreezeAccount(String bankingAccount);
	
	public void deleteAllUsers();
	public void deleteAllAccounts();
	public void deleteAllBankTransactions();
	public void deleteAllAccountTypes();
	
}

