package main.java.es.deusto.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import main.java.es.deusto.server.DTO.AccountDTO;
import main.java.es.deusto.server.DTO.BankTransactionDTO;
import main.java.es.deusto.server.DTO.UserDTO;
import main.java.es.deusto.server.data.Account;
import main.java.es.deusto.server.data.BankTransaction;
import main.java.es.deusto.server.data.User;

public interface IBankingSystemRemote extends Remote{

	public boolean newUser(String UserID, String Password, String name, String surName1, String surName2
			, String bankingAccount, String birthday, int telephoneNumber, String email, String country, String residence, int postalCode) throws RemoteException;
	public boolean logIn(String UserID, String Password) throws RemoteException;
	public String forgetPassword(String UserID, String email) throws RemoteException;
	public boolean changePassword(String UserID, String oldPassword, String newPassword) throws RemoteException;
	public boolean transaction(String targetBankingAccount, int amount, String desc) throws RemoteException;
	public boolean drawMoney(String userID, int amount) throws RemoteException;
	public List<AccountDTO> showAccountInfo() throws RemoteException;
	public List<UserDTO> showUserInfo() throws RemoteException;
	public void changeUserInfo(User u) throws RemoteException;
	public boolean insertMoney(String userID, int amount) throws RemoteException;
	public List<BankTransactionDTO> getBankTransactions() throws RemoteException;
	
}

