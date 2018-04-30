package main.java.es.deusto.server.dao;

import java.text.SimpleDateFormat;
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

import main.java.es.deusto.server.data.Account;
import main.java.es.deusto.server.data.BankTransaction;
import main.java.es.deusto.server.data.User;

public class BankingSystemDAO implements IBankingSystemDAO{
	
	private PersistenceManagerFactory pmf;
	private User userClass = new User();
	
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
			System.out.println("Saving new user: "+u.toString());
			pm.makePersistent(u);
			tx.commit();
		} catch(Exception e){
			System.out.println("Error saving user: " + e.getMessage());
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
			System.out.println("- Retrieving users with client ID: "+ uID);			
			System.out.println(" -- CHECKING USERS ...");
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
			System.err.println(" -- CHECKING USERS --  $ Error retrieving user using a 'Query': " + e.getMessage());
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
			System.out.println("- Retrieving users with client ID: "+ uID + ", Password: " + password);		
			System.out.println(" -- LOGIN IN THE SERVER --");
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
			System.err.println(" -- LOGIN IN THE SERVER -- $ Error retrieving user using a 'Query': " + e.getMessage());
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
			System.out.println(" -- FORGETPASSWORD METHOD -- " + "- Retrieving users with client ID: "+ uID + ", Email: " + email);					
			System.out.println(" -- RETURNING PASSWORD...");
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
			System.err.println(" -- FORGETPASSWORD METHOD --  $ Error retrieving user using a 'Query': " + e.getMessage());
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
			System.out.println(" -- CHANGEPASSWORD METHOD -- " + "- Retrieving users with client ID: "+ UserID + ", Password: " + oldPassword);					
			System.out.println(" -- CHANGING PASSWORD...");
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
			System.err.println(" -- CHANGEPASSWORD METHOD --  $ Error retrieving user using a 'Query': " + e.getMessage());
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
			System.out.println(" -- TRANSACTION METHOD -- ");
			System.out.println(" -- Transaction from USER: " + userClass.getUserID() + " to BankingAccount: " + targetBankingAccount + " $$ AMOUNT: " + amount);
			//Start the transaction
			tx.begin();

			Query<User> query = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE UserID == '" + uID + "'");
			
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
			System.err.println(" -- TRANSACTION METHOD --  $ Error retrieving user using a 'Query': " + e.getMessage());
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
			System.out.println(" -- NEW BANK TRANSACTION METHOD -- ");
			System.out.println(" -- Creating new bank transaction " + amount + "$ from USER: " +UserID);
			
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
			System.err.println(" -- NEW BANK TRANSACTION METHOD --  $ Error retrieving user using a 'Query': " + e.getMessage());
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
			System.out.println("-- GET BANK TRANSACTIONS METHOD --");
			System.out.println("-- Retrieving USER transaction information: "+userClass.getUserID());			
				
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
			
			return null;
			
		} catch (Exception e) {
			System.err.println(" -- GET BANK TRANSACTIONS METHOD --  $ Error retrieving USER transactions using a 'Query': " + e.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
	}
	
	@Override
	public boolean insertMoney(String userID, int amount, String des) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx =  pm.currentTransaction();
		
		try {				
			System.out.println(" -- INSERT MONEY METHOD -- ");
			System.out.println(" -- Inserting " + amount + "$ from USER: " +userID);
			
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
					users.getAccounts().add(a);
					pm.makePersistent(users);
					
					//End the transaction
					tx.commit();
					return true;
					
				}
			}

			//End the transaction
			tx.commit();
		} catch (Exception e) {
			System.err.println(" -- INSERT MONEY METHOD --  $ Error retrieving user using a 'Query': " + e.getMessage());
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
			System.out.println(" -- DRAWING MONEY METHOD -- ");
			System.out.println(" -- Drawing " + amount + "$ from USER: " + userID);
			
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
			System.out.println("-- SHOW USER ACCOUNT INFORMATION METHOD --");
			System.out.println("-- Retrieving USER information: "+userClass.getUserID());			
				
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
			
			return null;
			
		} catch (Exception e) {
			System.err.println(" -- INSERT MONEY METHOD --  $ Error retrieving USER accounts using a 'Query': " + e.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
	}

	@Override
	public List<User> showUserInfo() {
		// TODO Auto-generated method stub
		
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = (Transaction) pm.currentTransaction();
		
		try {
			System.out.println("-- SHOW USER INFORMATION METHOD --");
			System.out.println("-- Retrieving USER information: " +userClass.getUserID());			
				
			//Start the transaction
			tx.begin();
			
			Query<User> query = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE UserID == '" + userClass.getUserID() + "'");
			
			@SuppressWarnings("unchecked")
			List<User> users = (List<User>) query.execute();

			//End the transaction
			tx.commit();
			
			return users;
			
		} catch (Exception e) {
			System.err.println(" -- SHOW USER INFORMATION METHOD --  $ Error retrieving USER information using a 'Query': " + e.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
	}

	@Override
	public void changeUserInfo(User u) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx =  pm.currentTransaction();
		
		try {
			System.out.println("-- CHANGE USER INFORMATION METHOD --");
			System.out.println("-- Retrieving USER information: " +userClass.getUserID());
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
					System.out.println("--> INFORMATION CHANGED SUCCESSFULLY!!");
				}
			}	

			//End the transaction
			tx.commit();
		} catch (Exception e) {
			System.err.println(" -- CHANGEPASSWORD METHOD --  $ Error retrieving user using a 'Query': " + e.getMessage());
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
