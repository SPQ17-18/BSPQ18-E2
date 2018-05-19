package main.java.es.deusto.server.remote;

import java.rmi.RemoteException;

import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import main.java.es.deusto.server.DTO.AccountAssembler;
import main.java.es.deusto.server.DTO.AccountDTO;
import main.java.es.deusto.server.DTO.AccountTypeAssembler;
import main.java.es.deusto.server.DTO.AccountTypeDTO;
import main.java.es.deusto.server.DTO.BankTransactionAssembler;
import main.java.es.deusto.server.DTO.BankTransactionDTO;
import main.java.es.deusto.server.DTO.UserAssembler;
import main.java.es.deusto.server.DTO.UserDTO;
import main.java.es.deusto.server.dao.BankingSystemDAO;
import main.java.es.deusto.server.dao.IBankingSystemDAO;
import main.java.es.deusto.server.data.Account;
import main.java.es.deusto.server.data.AccountType;
import main.java.es.deusto.server.data.BankTransaction;
import main.java.es.deusto.server.data.User;

public class BankingSystemRemote extends UnicastRemoteObject implements IBankingSystemRemote {

	private static final long serialVersionUID = 1L;
	
	private IBankingSystemDAO dao;
	private static final Logger logger = Logger.getLogger(BankingSystemRemote.class);
	
	public BankingSystemRemote () throws RemoteException{
		dao = new BankingSystemDAO();
	}

	@Override
	public boolean newUser(String UserID, String Password, String name, String surName1, String surName2
			, String birthday , int telephoneNumber, String email, String country, String residence, int postalCode)  throws RemoteException{
		// TODO Auto-generated method stub
		dao.deleteAllBankTransactions();
		dao.deleteAllAccounts();
		dao.deleteAllUsers();
		if(dao.checkUser(UserID) == false){
			logger.error("---->>>> There is already a USER with the same ID!!");
			return false;
		}
		else{
			logger.info("---->>>> No USER with the same ID!!");
		
			User u = new User (UserID, Password, name, surName1, surName2,birthday, telephoneNumber, email, country, residence, postalCode);
			dao.newUser(u);
			
			return true;
		}
	}
	
	@Override
	public boolean newUserAccount(String userID, String accountType){
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String year = timeStamp.substring(0, 4);
		String month = timeStamp.substring(4,6);
		String day = timeStamp.substring(6,8);
		String hour = timeStamp.substring(9,11);
		String minute = timeStamp.substring(11,13);
		
		Account a = new Account (userID + timeStamp, hour, minute, day, month, year, 0);
		dao.newUserAccount(a, userID);
		return false;
	}
	

	@Override
	public boolean logIn(String UserID, String password)  throws RemoteException{
		// TODO Auto-generated method stub
		if(dao.logIn(UserID, password) == false){
			logger.error("---->>>> LOGIN failed!! Incorrect information!");
			return false;
		}
		else{
			logger.info("---->>>> Successful LOGIN !! Correct information!");
			return true;
		}
	}

	@Override
	public String forgetPassword(String UserID, String email)  throws RemoteException{
		// TODO Auto-generated method stub
		String pass = dao.forgetPassword(UserID, email);
		if(pass.equals("ERROR")){
			return "ERROR";
		}
		else{
			return pass;
		}
	}

	@Override
	public boolean changePassword(String UserID, String oldPassword, String newPassword)  throws RemoteException{
		// TODO Auto-generated method stub
		if(dao.changePassword(UserID, oldPassword, newPassword) == false){
			logger.error("---->>>> ERROR. Incorrect information!!");
			return false;
		}
		else{
			logger.info("---->>>> NEW PASSWORD CHANGED!");
			return true;
		}
	}

	@Override
	public boolean transaction(String originBankingAccount, String targetBankingAccount, int amount)  throws RemoteException{
		if(dao.transaction(originBankingAccount, targetBankingAccount, amount) == false){
			logger.error("---->>>> ERROR. Incorrect information!! Invalid target banking account!");
			return false;
		}
		else{
			logger.info("---->>>> TRANSACTION MADE SUCCESFULLY!!");
			return true;
		}		
	}
	
	@Override
	public boolean drawMoney(String targetBankingAccount, int amount)  throws RemoteException{
		// TODO Auto-generated method stub
		if(dao.drawMoney(targetBankingAccount, amount) == false){
			logger.error("---->>>> ERROR. NOT ENOUGH MONEY IN THE ACCOUNT");
			return false;
		}
		else{
			logger.info("---->>>> SUCCESSFULL OPERATION! $$$$ Drawing money...");
			return true;
		}
	}
	
	@Override
	public boolean insertMoney(String targetBankingAccount, int amount)  throws RemoteException{
		// TODO Auto-generated method stub
		if(dao.insertMoney(targetBankingAccount, amount) == false){
			logger.error("---->>>> ERROR INSERTING MONEY!!");
			return false;
		}
		else{
			logger.info("---->>>> SUCCESSFULL OPERATION! $$$$ Inserting money...");
			return true;
		}
	}

	@Override
	public UserDTO showUserInfo()  throws RemoteException{
		// TODO Auto-generated method stub
		logger.info("---->>>> Assembling Users ... creating DTO!!");
		UserAssembler ua = new UserAssembler();
		return ua.assemble(dao.showUserInfo()).get(0);
	}

	@Override
	public void changeUserInfo(User u)  throws RemoteException{
		// TODO Auto-generated method stub
		dao.changeUserInfo(u);
	}
	
	@Override
	public List<AccountDTO> getUserAccounts()  throws RemoteException{
		// TODO Auto-generated method stub
		logger.info("---->>>> Assembling Accounts ... creating DTO!!");
		AccountAssembler as = new AccountAssembler();
		return as.assemble(dao.getUserAccounts());
	}
	
	@Override
	public List<BankTransactionDTO> getBankTransactions(String accountID) throws RemoteException {
		// TODO Auto-generated method stub
		logger.info("---->>>> Assembling Bank Transactions ... creating DTO!!");
		BankTransactionAssembler bta = new BankTransactionAssembler();
		return bta.assemble(dao.getBankTransactions(accountID));
	}

	@Override
	public boolean createAccountType(String AccountType, String description) {
		// TODO Auto-generated method stub
		AccountType at = new AccountType(AccountType, description);
		if(dao.createAccountType(at) == false){
			logger.error("---->>>> ERROR CREATING NEW ACCOUNT TYPE!!");
			return false;
		}
		else{
			logger.info("---->>>> ACCOUNT TYPE SUCCESSFULLY CREATED!!");
			return true;
		}
	}
	
	@Override
	public List<AccountTypeDTO> getAllAccountTypes() {
		// TODO Auto-generated method stub
		logger.info("---->>>> Assembling Accounts Types ... creating DTO!!");
		AccountTypeAssembler ats = new AccountTypeAssembler();
		return ats.assemble(dao.getAllAccountTypes());
	}
	
	@Override
	public List<AccountDTO> showAllAccountsForDirector() {
		// TODO Auto-generated method stub
		logger.info("---->>>> Assembling all Accounts for director ... creating DTO!!");
		AccountAssembler as = new AccountAssembler();
		return as.assemble(dao.getAllAccountsForDirector());
	}
	
	@Override
	public boolean freezeAccount(String bankingAccount) {
		// TODO Auto-generated method stub
		if(dao.freezeAccount(bankingAccount) == false){
			logger.error("---->>>> ERROR FREEZING ACCOUNT!!");
			return false;
		}
		else{
			logger.info("---->>>> SUCCESS IN FREEZING THE ACCOUNT!!");
			return true;
		}
	}
	
	@Override
	public boolean unfreezeAccount(String bankingAccount) {
		if(dao.unfreezeAccount(bankingAccount) == false){
			logger.error("---->>>> ERROR UNFREEZING ACCOUNT!!");
			return false;
		}
		else{
			logger.info("---->>>> SUCCESS IN UNFREEZING THE ACCOUNT!!");
			return true;
		}
	}
	
}
