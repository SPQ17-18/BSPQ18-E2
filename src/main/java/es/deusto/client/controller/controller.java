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
				JOptionPane.showMessageDialog(null,c.getResourceBundle().getString("error_already_same_ID")+"!");
				return false;
			}
			else{
				JOptionPane.showMessageDialog(null, c.getResourceBundle().getString("msg_succesful_new_user")+"!");
			}
		} catch(Exception e){
			logger.error(resourcebundle.getString("error_storing_user"), e);
    	}
		
		return true;
	}
	
	public static boolean logIn(String userID, String password){
		try{
			if(rsl.getService().logIn(userID, password) == false){
				JOptionPane.showMessageDialog(null, c.getResourceBundle().getString("error_login_fail")+"!");
				return false;
			}
		} catch(Exception e){
			logger.error(c.getResourceBundle().getString("error_login"));
		}
		
		return true;
	}
	
	public static boolean forgetPassword(String UserID, String email){
		try{
			String pass = rsl.getService().forgetPassword(UserID, email);
			if(pass.equals("ERROR")){
				JOptionPane.showMessageDialog(null, c.getResourceBundle().getString("error_incorrect_info"));
				return false;
			}
			else{
				JOptionPane.showMessageDialog(null, c.getResourceBundle().getString("msg_pass_is")+": " + pass);
			}
		} catch(Exception e){
			logger.error(c.getResourceBundle().getString("error_forg_pass"));
		}
		return true;
	}
	
	public static boolean changePassword(String oldPassword, String newPassword){ //String UserID, String oldPassword, String newPassword
		try{
			if(rsl.getService().changePassword(oldPassword, newPassword) == false){
				JOptionPane.showMessageDialog(null, c.getResourceBundle().getString("error_incorrect_info"));
				return false;
			}
			else{
				JOptionPane.showMessageDialog(null, c.getResourceBundle().getString("msg_pass_updated"));
			}
		} catch(Exception e){
			logger.error(c.getResourceBundle().getString("error_change_pass"));
		}
		return true;
	}
	
	public static boolean transaction(String originBankingAccount, String targetBankingAccount, int amount){
		try{
			if(rsl.getService().transaction(originBankingAccount, targetBankingAccount, amount) == false){
				JOptionPane.showMessageDialog(null, c.getResourceBundle().getString("error_transaction"));
				return false;
			}
			else{
				JOptionPane.showMessageDialog(null, c.getResourceBundle().getString("msg_success_trans"));
			}
		} catch(Exception e){
			logger.error(c.getResourceBundle().getString("error_trans"));
		}
		
		return true;
	}
	
	public static boolean insertMoney(String targetBankingAccount, int amount){
		try{
			if(rsl.getService().insertMoney(targetBankingAccount, amount) == true){
				JOptionPane.showMessageDialog(null, c.getResourceBundle().getString("msg_success_insert"));
				return true;
			}
			else{
				JOptionPane.showMessageDialog(null, c.getResourceBundle().getString("msg_insert_not_done"));
			}
		} catch(Exception e){
			logger.error(c.getResourceBundle().getString("error_insert"));
		}
		return false;
	}
	
	public static boolean drawMoney(String targetBankingAccount, int amount){
		try{
			if(rsl.getService().drawMoney(targetBankingAccount, amount) == true){
				JOptionPane.showMessageDialog(null, c.getResourceBundle().getString("msg_success_draw"));
				return true;
			}
			else{
				JOptionPane.showMessageDialog(null, c.getResourceBundle().getString("msg_draw_not_done"));
			}
		} catch(Exception e){
			logger.error(c.getResourceBundle().getString("error_draw"));
		}
		return false;
	}
	
	public static List<AccountDTO> getUserAccounts(){
		try{
			return rsl.getService().getUserAccounts();
		} catch(Exception e){
			logger.error(c.getResourceBundle().getString("error_get_acc"));
		}
		return null;
	}
	
	public static List<AccountDTO> getAllAccounts(){
		try{
			return rsl.getService().showAllAccountsForDirector();
		} catch(Exception e){
			logger.error(c.getResourceBundle().getString("error_get_acc"));
		}
		return null;
	}
	
	public static List<BankTransactionDTO> getAccountBankTransactions(String accountID){
		try{
			return rsl.getService().getBankTransactions(accountID);
		} catch(Exception e){
			logger.error(c.getResourceBundle().getString("error_get_trans"));
		}
		return null;
	}
	
	public static List<AccountTypeDTO> getAccountTypes(){
		try{
			return rsl.getService().getAllAccountTypes();
		} catch(Exception e){
			logger.error(c.getResourceBundle().getString("error_get_types"));
		}
		return null;
	}
	
	public static void newUserAccount(String accountType){
		try{
			rsl.getService().newUserAccount(accountType);
		} catch(Exception e){
			logger.error(c.getResourceBundle().getString("error_create_acc"));
		}
	
	}
	
	public static void newaccountType(String accountTypeName, String description){
		try{
			rsl.getService().createAccountType(accountTypeName, description);
		} catch(Exception e){
			logger.error(c.getResourceBundle().getString("error_create_acc_type"));
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