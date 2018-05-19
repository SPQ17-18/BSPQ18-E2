package main.java.es.deusto.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import main.java.es.deusto.server.DTO.AccountDTO;
import main.java.es.deusto.server.DTO.AccountTypeDTO;
import main.java.es.deusto.server.DTO.BankTransactionDTO;
import main.java.es.deusto.server.DTO.UserDTO;
import main.java.es.deusto.server.data.Account;
import main.java.es.deusto.server.data.BankTransaction;
import main.java.es.deusto.server.data.User;

public interface IBankingSystemRemote extends Remote{

	public boolean newUser(String UserID, String Password, String name, String surName1, String surName2
			,String birthday, int telephoneNumber, String email, String country, String residence, int postalCode) throws RemoteException;
	public boolean logIn(String UserID, String Password) throws RemoteException;
	public String forgetPassword(String UserID, String email) throws RemoteException;
	public boolean changePassword(String UserID, String oldPassword, String newPassword) throws RemoteException;
	public boolean transaction(String originBankingAccount, String targetBankingAccount, int amount) throws RemoteException;
	public boolean drawMoney(String targetBankingAccount, int amount) throws RemoteException;
	public List<AccountDTO> getUserAccounts() throws RemoteException;
	public UserDTO showUserInfo() throws RemoteException;
	public void changeUserInfo(User u) throws RemoteException;
	public boolean insertMoney(String targetBankingAccount, int amount) throws RemoteException;
	public List<BankTransactionDTO> getBankTransactions(String accountID) throws RemoteException;
	public boolean createAccountType(String AccountType, String description) throws RemoteException;
	public boolean newUserAccount(String userID, String accountType) throws RemoteException;
	
	public List<AccountTypeDTO> getAllAccountTypes() throws RemoteException;
	//public boolean eraseOneUser();
	public List<AccountDTO> showAllAccountsForDirector() throws RemoteException;
	public boolean freezeAccount(String bankingAccount) throws RemoteException;
	public boolean unfreezeAccount(String bankingAccount) throws RemoteException;
	
}

