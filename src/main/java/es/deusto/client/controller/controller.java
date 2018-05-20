package main.java.es.deusto.client.controller;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import javax.swing.JOptionPane;

import main.java.es.deusto.client.GUI.GUI_MAIN;
import main.java.es.deusto.client.remote.RMIServiceLocator;
import main.java.es.deusto.server.DTO.AccountDTO;
import main.java.es.deusto.server.DTO.AccountTypeDTO;
import main.java.es.deusto.server.DTO.BankTransactionDTO;

public class controller {
	
	private static RMIServiceLocator rsl;
	private static controller c;
	private static final Logger logger = Logger.getLogger(controller.class);
	private static ResourceBundle resourcebundle;
	private static Locale locale;
	public static int language = 2; 
	public static String[] Args;
	
	public static void main(String[] args) throws RemoteException {
		c = new controller();
		rsl = new RMIServiceLocator();
		rsl.setService(args);
		Args = args;
		if(language == 0){
			locale = new Locale("es", "ES");
		}else if(language == 1){
			locale = new Locale("en", "US");
		}else if(language == 2){
			locale = new Locale("de", "DE");
		}
		resourcebundle = ResourceBundle.getBundle("lang/translations", locale);
		new GUI_MAIN(c);
	}
	
	public ResourceBundle getResourceBundle(){
		return resourcebundle;
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
			logger.error(resourcebundle.getString("error_storing_user"), e);
    	}
		
		return true;
	}
	
	public static boolean logIn(String userID, String password){
		try{
			if(rsl.getService().logIn(userID, password) == false){
				JOptionPane.showMessageDialog(null, "LOGIN failed!! Incorrect information!");
				return false;
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
	
	public static boolean changePassword(String oldPassword, String newPassword){ //String UserID, String oldPassword, String newPassword
		try{
			if(rsl.getService().changePassword(oldPassword, newPassword) == false){
				JOptionPane.showMessageDialog(null, "Incorrect information!! Please, fill the gaps again.");
				return false;
			}
			else{
				JOptionPane.showMessageDialog(null, "Correct information! New password updated.");
			}
		} catch(Exception e){
			logger.error("Problem occurred trying to CHANGE PASSWORD");
		}
		return true;
	}
	
	public static boolean transaction(String originBankingAccount, String targetBankingAccount, int amount){
		try{
			if(rsl.getService().transaction(originBankingAccount, targetBankingAccount, amount) == false){
				JOptionPane.showMessageDialog(null, "TRANSACTION failed!! Incorrect information or not enough MONEY!");
				return false;
			}
			else{
				JOptionPane.showMessageDialog(null, "Successful TRANSACTION !!! Correct information!");
			}
		} catch(Exception e){
			logger.error("Problem occurred trying to TRANSACTION");
		}
		
		return true;
	}
	
	public static boolean insertMoney(String targetBankingAccount, int amount){
		try{
			if(rsl.getService().insertMoney(targetBankingAccount, amount) == true){
				JOptionPane.showMessageDialog(null, "Successfully insertion of money!!");
				return true;
			}
			else{
				JOptionPane.showMessageDialog(null, "Insertion of money could not be done!!");
			}
		} catch(Exception e){
			logger.error("Problem occurred trying to INSERT MONEY!");
		}
		return false;
	}
	
	public static boolean drawMoney(String targetBankingAccount, int amount){
		try{
			if(rsl.getService().drawMoney(targetBankingAccount, amount) == true){
				JOptionPane.showMessageDialog(null, "Successfully draw of money!!");
				return true;
			}
			else{
				JOptionPane.showMessageDialog(null, "Draw of money could not be done. Not enough money in the account!!");
			}
		} catch(Exception e){
			logger.error("Problem occurred trying to DRAW MONEY!");
		}
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
	
	public static List<AccountDTO> getAllAccounts(){
		try{
			return rsl.getService().showAllAccountsForDirector();
		} catch(Exception e){
			logger.error("Problem occurred trying to GET ALL ACCOUNTS!");
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
	
	public static List<AccountTypeDTO> getAccountTypes(){
		try{
			return rsl.getService().getAllAccountTypes();
		} catch(Exception e){
			logger.error("Problem occurred trying to GET ACCOUNT TYPES!");
		}
		return null;
	}
	
	public static void newUserAccount(String accountType){
		try{
			rsl.getService().newUserAccount(accountType);
		} catch(Exception e){
			logger.error("Problem occurred trying to CREATE NEW USER ACCOUNT!");
		}
	
	}
	
	public static void newaccountType(String accountTypeName, String description){
		try{
			rsl.getService().createAccountType(accountTypeName, description);
		} catch(Exception e){
			logger.error("Problem occurred trying to CREATE NEW ACCOUNT TYPE!");
		}
	
	}
	
	public static void freezeAccount(String accountID){
		try{
			rsl.getService().freezeAccount(accountID);
		} catch(Exception e){
			logger.error("Problem occurred trying to FREEZE ACCOUNT!");
		}
	
	}
	
	public static void unfreezeAccount(String accountID){
		try{
			rsl.getService().unfreezeAccount(accountID);
		} catch(Exception e){
			logger.error("Problem occurred trying to UNFREEZE ACCOUNT!");
		}
	
	}
	
	public boolean showUserInfo(){
		return false;
	}
	
	public boolean changeUserInfo(){
		return false;
	}
	
	
}