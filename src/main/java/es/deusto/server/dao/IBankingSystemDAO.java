package main.java.es.deusto.server.dao;

import java.util.Date;
import java.util.List;

import main.java.es.deusto.server.data.Account;
import main.java.es.deusto.server.data.BankTransaction;
import main.java.es.deusto.server.data.User;

public interface IBankingSystemDAO {

	public void newUser(User u);
	public void newUserAccount (Account a, String UserID);
	public boolean checkUser(String uID);
	public boolean logIn(String uID, String password);
	public String forgetPassword(String UserID, String email);
	public boolean changePassword(String UserID, String oldPassword, String newPassword);
	public boolean transaction(String originBankingAccount, String targetBankingAccount, int amount);
	public boolean insertMoney(String targetBankingAccount, int amount);
	public boolean drawMoney(String targetBankingAccount, int amount);
	public List<Account> getUserAccounts();
	public List<User> showUserInfo();
	public void changeUserInfo(User u);
	public boolean newBankTransaction( String sourceBankingAccount, String targetBankingAccount, int amount, String desc);
	public List<BankTransaction> getBankTransactions(String accountID);
	
	public void deleteAllUsers();
	public void deleteAllAccounts();
	public void deleteAllBankTransactions();
	
	//public boolean createAccountType();
	//public boolean getAllAccountTypes();
	//public boolean eraseOneUser();
	//public boolean showAllAccountsForDirector();
	//public boolean freezeAccount();
	//public boolean unfreezeAccount();
}

