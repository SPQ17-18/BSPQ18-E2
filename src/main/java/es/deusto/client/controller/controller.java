package main.java.es.deusto.client.controller;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import javax.swing.JOptionPane;

import main.java.es.deusto.client.GUI.GUI_MAIN;
import main.java.es.deusto.client.remote.RMIServiceLocator;
import main.java.es.deusto.server.DTO.AccountDTO;
import main.java.es.deusto.server.DTO.BankTransactionDTO;

public class controller {
	
	private static RMIServiceLocator rsl;
	private static controller c;
	private static final Logger logger = Logger.getLogger(controller.class);
	
	public static void main(String[] args) throws RemoteException {
		rsl = new RMIServiceLocator();
		rsl.setService(args);
		new GUI_MAIN(c);
	}
	
	//ALL THE OPERATIONS THAT CAN BE DONE BY THE USER
	
	public static boolean newUser(String name, String surname1, String surname2, int postalCode, String city, String country, int phoneNumber, String email, String birthday,
									String clientID, String password){
		try{
			if(rsl.getService().newUser(clientID, password, name, surname1, surname2, birthday, phoneNumber, email, country, city, postalCode) == false){
				JOptionPane.showMessageDialog(null, "New USER could not be created. There is already a USER with the same ID!");
				return false;
			}
			else{
				JOptionPane.showMessageDialog(null, "New USER successfully created!");
			}
		} catch(Exception e){
			logger.error("Problem occurred trying to store the USER");
    	}
		
		return true;
	}
	
	public static boolean logIn(String userID, String password){
		try{
			if(rsl.getService().logIn(userID, password) == false){
				JOptionPane.showMessageDialog(null, "LOGIN failed!! Incorrect information!");
				return false;
			}
			else{
				JOptionPane.showMessageDialog(null, "Successful LOGIN !! Correct information!");
			}
		} catch(Exception e){
			logger.error("Problem occurred trying to LOGIN");
		}
		
		return true;
	}
	
	public static boolean forgetPassword(String UserID, String email){
		try{
			String pass = rsl.getService().forgetPassword(UserID, email);
			if(pass.equals("ERROR")){
				JOptionPane.showMessageDialog(null, "Incorrect information!! Please, fill the gaps again.");
				return false;
			}
			else{
				JOptionPane.showMessageDialog(null, "Your password is: " + pass);
			}
		} catch(Exception e){
			logger.error("Problem occurred trying to FORGET PASSWORD");
		}
		return true;
	}
	
	public static void changePassword(){ //String UserID, String oldPassword, String newPassword
		try{
			if(rsl.getService().changePassword("78128D", "PAC", "CAT") == false){
				JOptionPane.showMessageDialog(null, "Incorrect information!! Please, fill the gaps again.");
			}
			else{
				JOptionPane.showMessageDialog(null, "Correct information! New password updated.");
			}
		} catch(Exception e){
			logger.error("Problem occurred trying to CHANGE PASSWORD");
		}
	}
	
	public boolean transaction(String userId, int userAccount, String targetId, int targetAccount, int amount, String desc, Date date){
//		try{
//			if(rsl.getService().transaction(userId, userAccount, targetId, targetAccount, amount, desc, date) == false){
//				JOptionPane.showMessageDialog(null, "TRANSACTION failed!! Incorrect information!");
//				return false;
//			}
//			else{
//				JOptionPane.showMessageDialog(null, "Successful TRANSACTION !!! Correct information!");
//			}
//		} catch(Exception e){
//			logger.error("Problem occurred trying to TRANSACTION");
//		}
//		
		return true;
	}
	
	public boolean insertMoney(int amount){
		//DONE
		return false;
	}
	
	public boolean drawMoney(int amount){
		//DONE
		return false;
	}
	
	public static List<AccountDTO> getUserAccounts(){
		try{
			return rsl.getService().getUserAccounts();
		} catch(Exception e){
			logger.error("Problem occurred trying to GET USER ACCOUNTS!");
		}
		return null;
	}
	
	public static List<BankTransactionDTO> getAccountBankTransactions(String accountID){
		try{
			return rsl.getService().getBankTransactions(accountID);
		} catch(Exception e){
			logger.error("Problem occurred trying to GET ACCOUNT TRANSACTIONS!");
		}
		return null;
	}
	
	public boolean showUserInfo(){
		return false;
	}
	
	public boolean changeUserInfo(){
		return false;
	}
	
	
}

