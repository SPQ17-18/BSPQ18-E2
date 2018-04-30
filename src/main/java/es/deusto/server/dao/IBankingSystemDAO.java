package main.java.es.deusto.server.dao;

import java.util.Date;
import java.util.List;

import main.java.es.deusto.server.data.Account;
import main.java.es.deusto.server.data.BankTransaction;
import main.java.es.deusto.server.data.User;

public interface IBankingSystemDAO {

	public void newUser(User u);
	public boolean checkUser(String uID);
	public boolean logIn(String uID, String password);
	public String forgetPassword(String UserID, String email);
	public boolean changePassword(String UserID, String oldPassword, String newPassword);
	public boolean transaction(String targetBankingAccount, int amount, String desc);
	public boolean insertMoney(String userID, int amount, String des);
	public boolean drawMoney(String userID, int amount, String des);
	public List<Account> showAccountInfo();
	public List<User> showUserInfo();
	public void changeUserInfo(User u);
	public boolean newBankTransaction(String UserID, String targetBankingAccount, int amount, String desc);
	public List<BankTransaction> getBankTransactions();
}

