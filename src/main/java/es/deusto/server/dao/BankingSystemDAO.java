package main.java.es.deusto.server.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import org.datanucleus.api.jdo.JDOQuery;

import org.apache.log4j.Logger;

import main.java.es.deusto.server.data.Account;
import main.java.es.deusto.server.data.BankTransaction;
import main.java.es.deusto.server.data.User;

public class BankingSystemDAO implements IBankingSystemDAO{
	
	private PersistenceManagerFactory pmf;
	private User userClass = new User();
	private static final Logger logger = Logger.getLogger(BankingSystemDAO.class);
	
	public BankingSystemDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	@Override
	public void newUser(User u) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = (Transaction) pm.currentTransaction();
		
		try{
			tx.begin();
			logger.info("Saving new user: "+u.toString());
			pm.makePersistent(u);
			tx.commit();
		} catch(Exception e){
			logger.error("Error saving user: " + e.getMessage());
		} finally{
			if(tx != null && tx.isActive()){
				tx.rollback();
			}
			
			pm.close();
			
		}
	}
	
	@Override
	public boolean checkUser(String uID) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = (Transaction) pm.currentTransaction();
		
		try {
			logger.info("- Retrieving users with client ID: "+ uID);			
			logger.info(" -- CHECKING USERS ...");
			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = (Transaction) pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Query<User> query = pm.newQuery(User.class);
			
			@SuppressWarnings("unchecked")
			List<User> users = (List<User>) query.execute();

			//End the transaction
			tx.commit();
			
			for(int i = 0; i<users.size(); i++){
				if(users.get(i).getUserID().equals(uID)){
					return false;
				}
			}
			
		} catch (Exception e) {
			logger.error(" -- CHECKING USERS --  $ Error retrieving user using a 'Query': " + e.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
		return true;
		
	}


	@Override
	public boolean logIn(String uID, String password) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx =  pm.currentTransaction();
		
		try {
			logger.info("- Retrieving users with client ID: "+ uID + ", Password: " + password);		
			logger.info(" -- LOGIN IN THE SERVER --");
			//Start the transaction
			tx.begin();

			Query<User> query = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE UserID == '" + uID + "'");
			
			@SuppressWarnings("unchecked")
			List<User> users = (List<User>) query.execute();

			//End the transaction
			tx.commit();
			
			for(int i = 0; i < users.size(); i++){
				if(users.get(i).getPassword().equals(password)){
					userClass = users.get(i);
					return true;
				}
			}
			
		} catch (Exception e) {
			logger.error(" -- LOGIN IN THE SERVER -- $ Error retrieving user using a 'Query': " + e.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
		return false;
	}

	@Override
	public String forgetPassword(String uID, String email) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx =  pm.currentTransaction();
		
		try {
			logger.info(" -- FORGETPASSWORD METHOD -- " + "- Retrieving users with client ID: "+ uID + ", Email: " + email);					
			logger.info(" -- RETURNING PASSWORD...");
			//Start the transaction
			tx.begin();

			Query<User> query = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE UserID == '" + uID + "'");
			
			@SuppressWarnings("unchecked")
			List<User> users = (List<User>) query.execute();

			//End the transaction
			tx.commit();
			
			for(int i = 0; i < users.size(); i++){
				if(users.get(i).getEmail().equals(email)){
					return users.get(i).getPassword();
				}
			}
			
		} catch (Exception e) {
			logger.error(" -- FORGETPASSWORD METHOD --  $ Error retrieving user using a 'Query': " + e.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
		return "ERROR";
	}

	@Override
	public boolean changePassword(String UserID, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx =  pm.currentTransaction();
		
		try {
			logger.info(" -- CHANGEPASSWORD METHOD -- " + "- Retrieving users with client ID: "+ UserID + ", Password: " + oldPassword);					
			logger.info(" -- CHANGING PASSWORD...");
			//Start the transaction
			tx.begin();

			Extent<User> extent = pm.getExtent(User.class, true);

			for (User users : extent) {
				if (UserID.equals(users.getUserID()) && oldPassword.equals(users.getPassword())) {
					users.setPassword(newPassword);
					pm.makePersistent(users);
					//End the transaction
					tx.commit();
					return true;
				}
			}

			//End the transaction
			tx.commit();
		} catch (Exception e) {
			logger.error(" -- CHANGEPASSWORD METHOD --  $ Error retrieving user using a 'Query': " + e.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
		return false; 
	}

	@Override
	public boolean transaction(String targetBankingAccount, int amount, String desc) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx =  pm.currentTransaction();
		
		try {
			logger.info(" -- TRANSACTION METHOD -- ");
			logger.info(" -- Transaction from USER: " + userClass.getUserID() + " to BankingAccount: " + targetBankingAccount + " $$ AMOUNT: " + amount);
			//Start the transaction
			tx.begin();

			Query<User> query = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE UserID == '" + userClass.getUserID() + "'");
			
			@SuppressWarnings("unchecked")
			List<User> users = (List<User>) query.execute();
			
			Query<User> query2 = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE bankingAccount == '" + targetBankingAccount + "'");
			
			@SuppressWarnings("unchecked")
			List<User> targetUsers = (List<User>) query2.execute();

			//End the transaction
			tx.commit();
			
			if(users.get(0).getAccounts().get(users.get(0).getAccounts().size()).getAmount() < amount){
				if(targetUsers.get(0).getBankingAccount().equals(targetBankingAccount)){
					//TRANSACTION TO
					drawMoney(users.get(0).getUserID(), amount, "TRANSACTION TO: " +targetBankingAccount);
					//TRANSACTION FROM
					insertMoney(targetUsers.get(0).getUserID(), amount, "TRANSACTION FROM: " +users.get(0).getBankingAccount());
					//NEW TRANSACTION USER
					newBankTransaction(users.get(0).getUserID(), targetUsers.get(0).getBankingAccount(), amount, "TRANSACTION TO");
					//NEW TRANSACTION TARGET USER
					newBankTransaction(targetUsers.get(0).getUserID(), users.get(0).getBankingAccount(), amount, "TRANSACTION FROM");
					
					return true;
				}
			}
			
		} catch (Exception e) {
			logger.error(" -- TRANSACTION METHOD --  $ Error retrieving user using a 'Query': " + e.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
		return false;
	}
	
	@Override
	public boolean newBankTransaction(String UserID, String targetBankingAccount, int amount, String desc) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx =  pm.currentTransaction();
		
		try {				
			logger.info(" -- NEW BANK TRANSACTION METHOD -- ");
			logger.info(" -- Creating new bank transaction " + amount + "$ from USER: " +UserID);
			
			//Start the transaction
			tx.begin();

			Extent<User> extent = pm.getExtent(User.class, true);

			for (User users : extent) {
				if (UserID.equals(users.getUserID())){
					
					String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
					String year = timeStamp.substring(0, 3);
					String month = timeStamp.substring(4,5);
					String day = timeStamp.substring(6,7);
					String hour = timeStamp.substring(9,10);
					String minute = timeStamp.substring(11,12);
		
					BankTransaction bt = new BankTransaction(UserID, targetBankingAccount, amount, desc, hour, minute, day, month, year); 
					users.getTransactions().add(bt);
					pm.makePersistent(users);
					
					//End the transaction
					tx.commit();
					return true;
					
				}
			}

			//End the transaction
			tx.commit();
		} catch (Exception e) {
			logger.error(" -- NEW BANK TRANSACTION METHOD --  $ Error retrieving user using a 'Query': " + e.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
		return false;
	}
	
	@Override
	public List<BankTransaction> getBankTransactions() {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = (Transaction) pm.currentTransaction();
		
		try {
			logger.info("-- GET BANK TRANSACTIONS METHOD --");
			logger.info("-- Retrieving USER transaction information: "+userClass.getUserID());			
				
			//Start the transaction
			tx.begin();
			
			Query<User> query = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE UserID == '" + userClass.getUserID() + "'");
			
			@SuppressWarnings("unchecked")
			List<User> users = (List<User>) query.execute();

			//End the transaction
			tx.commit();
			
			if(users.get(0).getTransactions()!= null){
				return users.get(0).getTransactions();
			}
			
		} catch (Exception e) {
			logger.error(" -- GET BANK TRANSACTIONS METHOD --  $ Error retrieving USER transactions using a 'Query': " + e.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
		return null;
	}
	
	@Override
	public boolean insertMoney(String userID, int amount, String des) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx =  pm.currentTransaction();
		
		try {				
			logger.info(" -- INSERT MONEY METHOD -- ");
			logger.info(" -- Inserting " + amount + "$ from USER: " +userID);
			
			//Start the transaction
			tx.begin();

			Extent<User> extent = pm.getExtent(User.class, true);

			for (User users : extent) {
				if (userID.equals(users.getUserID())){
					
					String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
					String year = timeStamp.substring(0, 3);
					String month = timeStamp.substring(4,5);
					String day = timeStamp.substring(6,7);
					String hour = timeStamp.substring(9,10);
					String minute = timeStamp.substring(11,12);
					
					Account a = new Account(hour, minute, day, month, year, amount, users.getAccounts().get(users.getAccounts().size()).getAmount() + amount, des, "POS"); 
					List<Account> ac = new ArrayList<Account>();
					ac.add(a);
					users.setAccounts(ac);
					pm.makePersistent(users);
					
					//End the transaction
					tx.commit();
					return true;
					
				}
			}

			//End the transaction
			tx.commit();
		} catch (Exception e) {
			logger.error(" -- INSERT MONEY METHOD --  $ Error retrieving user using a 'Query': " + e.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
		return false;
	}
	
	@Override
	public boolean drawMoney(String userID, int amount, String des) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx =  pm.currentTransaction();
		
		try {				
			logger.info(" -- DRAWING MONEY METHOD -- ");
			logger.info(" -- Drawing " + amount + "$ from USER: " + userID);
			
			//Start the transaction
			tx.begin();

			Extent<User> extent = pm.getExtent(User.class, true);

			for (User users : extent) {
				if (userID.equals(users.getUserID())){
					if (users.getAccounts().get(users.getAccounts().size()).getAmount() > amount) {
					
						String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
						String year = timeStamp.substring(0, 3);
						String month = timeStamp.substring(4,5);
						String day = timeStamp.substring(6,7);
						String hour = timeStamp.substring(9,10);
						String minute = timeStamp.substring(11,12);
			
						Account a = new Account(hour, minute, day, month, year, amount, users.getAccounts().get(users.getAccounts().size()).getAmount() - amount, des, "NEG"); 
						users.getAccounts().add(a);
						pm.makePersistent(users);
					
						//End the transaction
						tx.commit();
						return true;
					}
				}
			}

			//End the transaction
			tx.commit();
		} catch (Exception e) {
			System.err.println(" -- DRAWING MONEY METHOD --  $ Error retrieving user using a 'Query': " + e.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
		return false;
	}

	@Override
	public List<Account> showAccountInfo() {
		// TODO Auto-generated method stub
		
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = (Transaction) pm.currentTransaction();
		
		try {
			logger.info("-- SHOW USER ACCOUNT INFORMATION METHOD --");
			logger.info("-- Retrieving USER information: "+userClass.getUserID());			
				
			//Start the transaction
			tx.begin();
			
			Query<User> query = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE UserID == '" + userClass.getUserID() + "'");
			
			@SuppressWarnings("unchecked")
			List<User> users = (List<User>) query.execute();

			//End the transaction
			tx.commit();
			
			if(users.get(0).getAccounts() != null){
				return users.get(0).getAccounts();
			}
			
		} catch (Exception e) {
			logger.error(" -- INSERT MONEY METHOD --  $ Error retrieving USER accounts using a 'Query': " + e.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
		return null;
	}

	@Override
	public List<User> showUserInfo() {
		// TODO Auto-generated method stub
		
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = (Transaction) pm.currentTransaction();
		
		try {
			logger.info("-- SHOW USER INFORMATION METHOD --");
			logger.info("-- Retrieving USER information: " +userClass.getUserID());			
				
			//Start the transaction
			tx.begin();
			
			Query<User> query = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE UserID == '" + userClass.getUserID() + "'");
			
			@SuppressWarnings("unchecked")
			List<User> users = (List<User>) query.execute();

			//End the transaction
			tx.commit();
			
			return users;
			
		} catch (Exception e) {
			logger.error(" -- SHOW USER INFORMATION METHOD --  $ Error retrieving USER information using a 'Query': " + e.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
		return null;
	}

	@Override
	public void changeUserInfo(User u) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx =  pm.currentTransaction();
		
		try {
			logger.info("-- CHANGE USER INFORMATION METHOD --");
			logger.info("-- Retrieving USER information: " +userClass.getUserID());
			//Start the transaction
			tx.begin();

			Extent<User> extent = pm.getExtent(User.class, true);

			for (User users : extent) {
				if (userClass.getUserID().equals(users.getUserID())) {
					users.setName(u.getName());
					users.setSurName1(u.getSurName1());
					users.setSurName2(u.getSurName2());
					users.setBirthday(u.getBirthday());
					users.setEmail(u.getEmail());
					users.setCountry(u.getCountry());
					users.setResidence(u.getResidence());
					users.setPostalCode(u.getPostalCode());
					pm.makePersistent(users);
					//End the transaction
					tx.commit();
					logger.info("--> INFORMATION CHANGED SUCCESSFULLY!!");
				}
			}	

			//End the transaction
			tx.commit();
		} catch (Exception e) {
			logger.error(" -- CHANGEPASSWORD METHOD --  $ Error retrieving user using a 'Query': " + e.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
	}
	
	public void deleteAllUsers() {

		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			JDOQuery<User> query = (JDOQuery<User>) pm.newQuery(User.class);
			query.deletePersistentAll();
			logger.info("Deleting Users from the DB... DELETED!");
			tx.commit();
		} catch (Exception ex) {
			logger.error("Error cleaning the DB: " + ex.getMessage());
			
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}

	}
	
}
