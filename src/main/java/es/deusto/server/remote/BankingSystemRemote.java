package main.java.es.deusto.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

import main.java.es.deusto.server.DTO.AccountDTO;
import main.java.es.deusto.server.DTO.UserDTO;
import main.java.es.deusto.server.dao.BankingSystemDAO;
import main.java.es.deusto.server.dao.IBankingSystemDAO;
import main.java.es.deusto.server.data.User;

public class BankingSystemRemote extends UnicastRemoteObject implements IBankingSystemRemote {

	private static final long serialVersionUID = 1L;
	
	private IBankingSystemDAO dao;
	
	public BankingSystemRemote () throws RemoteException{
		dao = new BankingSystemDAO();
	}

	@Override
	public boolean newUser(String UserID, String Password, String name, String surName1, String surName2
			, String bankingAccount, int age, int telephoneNumber, String email, String country, String residence, int postalCode)  throws RemoteException{
		// TODO Auto-generated method stub
		if(dao.checkUser(UserID) == false){
			System.out.println("--> There is already a USER with the same ID!!");
			return false;
		}
		else{
			User u = new User (UserID, Password, name, surName1, surName2, bankingAccount, age, telephoneNumber, email, country, residence, postalCode, null, null);
			dao.newUser(u);
			return true;
		}
	}
	

	@Override
	public boolean logIn(String UserID, String password)  throws RemoteException{
		// TODO Auto-generated method stub
		if(dao.logIn(UserID, password) == false){
			System.out.println("--> LOGIN failed!! Incorrect information!");
			return false;
		}
		else{
			System.out.println("--> Successful LOGIN !! Correct information!");
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
			System.out.println("--> ERROR. Incorrect information!!");
			return false;
		}
		else{
			System.out.println("--> NEW PASSWORD CHANGED!");
			return true;
		}
	}

	@Override
	public boolean transaction(String userId, int userAccount, String targetId,int targetAccount, int amount, String desc, Date date)  throws RemoteException{
		if(dao.transaction(userId, userAccount, targetId,targetAccount, amount, desc, date) == false){
			System.out.println("--> ERROR. Incorrect information!!");
			return false;
		}
		else{
			System.out.println("--> TRANSACTION MADE SUCCESFULLY!");
			return true;
		}
		
	}
	
	@Override
	public boolean drawMoney(int amount)  throws RemoteException{
		// TODO Auto-generated method stub
		if(dao.drawMoney(amount) == false){
			System.out.println("--> ERROR. NOT ENOUGH MONEY IN THE ACCOUNT");
			return false;
		}
		else{
			System.out.println("--> ENOUGH MONEY! $$$$ Drawing money...");
			return true;
		}
	}

	@Override
	public List<AccountDTO> showAccountInfo()  throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO showUserInfo()  throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO changeUserInfo()  throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}
}
