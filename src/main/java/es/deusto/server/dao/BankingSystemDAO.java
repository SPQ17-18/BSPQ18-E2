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
import main.java.es.deusto.server.data.AccountType;
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
	public void newUserAccount (Account a){
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = (Transaction) pm.currentTransaction();
		
		try {
			logger.info("- Retrieving users with client ID: "+ userClass.getUserID());			
			logger.info(" -- NEW USER ACCOUNT --");

			//Start the transaction
			tx.begin();

			Query<User> query = pm.newQuery(User.class);
			
			@SuppressWarnings("unchecked")
			List<User> users = (List<User>) query.execute();
			
			for(int i = 0; i<users.size(); i++){
				if(users.get(i).getUserID().equals(userClass.getUserID())){
					a.setUser(users.get(i));
					users.get(i).addAccount(a);
					//End the transaction
					tx.commit();
				}
			}
			
			//End the transaction
			tx.commit();
			
		} catch (Exception e) {
			logger.error(" -- NEW USER ACCOUNT --  $ Error retrieving user using a 'Query': " + e.getMessage());
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
	public boolean changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx =  pm.currentTransaction();
		
		try {
			logger.info(" -- CHANGEPASSWORD METHOD -- " + "- Retrieving users with client ID: "+ userClass.getUserID() + ", Password: " + oldPassword);					
			logger.info(" -- CHANGING PASSWORD...");
			//Start the transaction
			tx.begin();

			Extent<User> extent = pm.getExtent(User.class, true);

			for (User users : extent) {
				if (userClass.getUserID().equals(users.getUserID()) && oldPassword.equals(users.getPassword())) {
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
	public boolean transaction(String originBankingAccount, String targetBankingAccount, int amount) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx =  pm.currentTransaction();
		
		try {
			logger.info(" -- TRANSACTION METHOD -- ");
			logger.info(" -- Transaction from USER: " + userClass.getUserID() + " from BankingAccount" + originBankingAccount + " to BankingAccount: " + targetBankingAccount + " $$ AMOUNT: " + amount);
			//Start the transaction
			tx.begin();

			Query<Account> query = pm.newQuery("SELECT FROM " + Account.class.getName() + " WHERE AccountID == '" + originBankingAccount + "'");
			
			@SuppressWarnings("unchecked")
			List<Account> originAccount = (List<Account>) query.execute();
			
			Query<Account> query2 = pm.newQuery("SELECT FROM " + Account.class.getName() + " WHERE AccountID == '" + targetBankingAccount + "'");
			
			@SuppressWarnings("unchecked")
			List<Account> targetAccount = (List<Account>) query2.execute();

			//End the transaction
			tx.commit();
			
			if(originAccount.get(0)!= null && targetAccount.get(0) !=null){
				if(amount <= originAccount.get(0).getTotalAmount()){
					if(!originBankingAccount.equals(targetBankingAccount)){ //CANT DO A TRANSACTION TO THEIR OWN ACCOUNT
						originAccount.get(0).setTotalAmount(originAccount.get(0).getTotalAmount() - amount);
						targetAccount.get(0).setTotalAmount(targetAccount.get(0).getTotalAmount() + amount);
						
						newBankTransaction(originAccount.get(0).getAccountID(), targetAccount.get(0).getAccountID(), amount, "TRANSACTION TO");
						newBankTransaction(targetAccount.get(0).getAccountID(), originAccount.get(0).getAccountID(), amount, "TRANSACTION FROM");
						
						return true;
					}
				}
			}
			
		} catch (Exception e) {
			logger.error(" -- TRANSACTION METHOD --  $ Error retrieving ACCOUNT using a 'Query': " + e.getMessage());
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
	public boolean newBankTransaction(String sourceBankingAccount, String targetBankingAccount, int amount, String desc) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx =  pm.currentTransaction();
		
		// SOURCEBANKINGACCOUNT --> THE ACCOUNT WHERE THE TRANSACTIONS HAPPENS
		// TARGETBANKINGACCOUNT --> THE TARGET OF THE TRANSACTION (COULD BE THE SAME)
		
		try {				
			logger.info(" -- NEW BANK TRANSACTION METHOD -- ");
			logger.info(" -- Creating new bank transaction " + desc + " AMOUNT: " + amount + "$ in ACCOUNT: " +sourceBankingAccount);
			
			//Start the transaction
			tx.begin();
			
			Query<Account> query = pm.newQuery(Account.class);
			
			@SuppressWarnings("unchecked")
			List<Account> accounts = (List<Account>) query.execute();
			
			for (int i = 0; i<accounts.size();i++) {
				if (sourceBankingAccount.equals(accounts.get(i).getAccountID())){
						String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
						String year = timeStamp.substring(0, 4);
						String month = timeStamp.substring(4,6);
						String day = timeStamp.substring(6,8);
						String hour = timeStamp.substring(9,11);
						String minute = timeStamp.substring(11,13);
			
						BankTransaction bt = new BankTransaction(timeStamp + sourceBankingAccount + desc, sourceBankingAccount, targetBankingAccount, amount, desc, hour, minute, day, month, year); 
						bt.setAccount(accounts.get(i));
						accounts.get(i).addBankTransaction(bt);
						
						//End the transaction
						tx.commit();
						
						return true;
				}
			}

			//End the transaction
			tx.commit();
		} catch (Exception e) {
			logger.error(" -- NEW BANK TRANSACTION METHOD --  $ Error retrieving ACCOUNT using a 'Query': " + e.getMessage());
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
	public List<BankTransaction> getBankTransactions(String accountID) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = (Transaction) pm.currentTransaction();
		
		try {
			logger.info("-- GET BANK TRANSACTIONS METHOD --");
			logger.info("-- Retrieving USER "+userClass.getUserID() + " // BANK TRANSACTIONS from ACCOUNT: "+ accountID);			
				
			//Start the transaction
			tx.begin();
			
			Query<Account> query = pm.newQuery("SELECT FROM " + Account.class.getName() + " WHERE AccountID == '" + accountID + "'");
			
			@SuppressWarnings("unchecked")
			List<Account> accounts = (List<Account>) query.execute();
		
			//End the transaction
			tx.commit();
			
			return accounts.get(0).getTransactions();
			
		} catch (Exception e) {
			logger.error(" -- GET BANK TRANSACTIONS METHOD --  $ Error retrieving ACCOUNT transactions using a 'Query': " + e.getMessage());
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
	public boolean insertMoney(String targetBankingAccount, int amount) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx =  pm.currentTransaction();
		
		try {				
			logger.info(" -- INSERT MONEY METHOD -- ");
			logger.info(" -- Inserting " + amount + "$ from ACCOUNT: " +targetBankingAccount);
			
			//Start the transaction
			tx.begin();

			Query<Account> query = pm.newQuery(Account.class);
			
			@SuppressWarnings("unchecked")
			List<Account> accounts = (List<Account>) query.execute();

			for (int i = 0; i<accounts.size();i++) {
				if (targetBankingAccount.equals(accounts.get(i).getAccountID())){
					
					//Increment account money
					accounts.get(i).setTotalAmount(accounts.get(i).getTotalAmount() + amount);
					
					//Create a new transaction
					newBankTransaction(targetBankingAccount, targetBankingAccount, amount, "INSERT MONEY");
					
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
	public boolean drawMoney(String targetBankingAccount, int amount) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx =  pm.currentTransaction();
		
		try {				
			logger.info(" -- DRAWING MONEY METHOD -- ");
			logger.info(" -- Drawing " + amount + "$ from ACCOUNT: " + targetBankingAccount);
			
			//Start the transaction
			tx.begin();

			Query<Account> query = pm.newQuery(Account.class);
			
			@SuppressWarnings("unchecked")
			List<Account> accounts = (List<Account>) query.execute();

			for (int i = 0; i<accounts.size();i++) {
				if (targetBankingAccount.equals(accounts.get(i).getAccountID())){
					if(amount <= accounts.get(i).getTotalAmount()){
					
						//Decrease account money
						accounts.get(i).setTotalAmount(accounts.get(i).getTotalAmount() - amount);
						
						//Create a new transaction
						newBankTransaction(targetBankingAccount,targetBankingAccount, amount, "DRAW MONEY");
						
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
	public List<Account> getUserAccounts() {
		// TODO Auto-generated method stub
		
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = (Transaction) pm.currentTransaction();
		
		try {
			logger.info("-- GET USER ACCOUNTS METHOD --");
			logger.info("-- Retrieving ACCOUNTS from USER: "+userClass.getUserID());			
				
			//Start the transaction
			tx.begin();
			
			Query<User> query = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE UserID == '" + userClass.getUserID() + "'");
			
			@SuppressWarnings("unchecked")
			List<User> users = (List<User>) query.execute();

			//End the transaction
			tx.commit();
			for(int i = 0; i<users.get(0).getAccounts().size();i++){
				logger.info("USER ACCOUNT TYPE: "+ users.get(0).getAccounts().get(i).getAccountType());
			}
			
			return users.get(0).getAccounts();
			
		} catch (Exception e) {
			logger.error(" -- GET USER ACCOUNTS METHOD --  $ Error retrieving USER accounts using a 'Query': " + e.getMessage());
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
			logger.error(" -- CHANGE USER INFORMATION METHOD -- $ Error retrieving user using a 'Query': " + e.getMessage());
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
	public boolean createAccountType(AccountType at) {
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = (Transaction) pm.currentTransaction();
		
		try {
			logger.info("- Retrieving ACCOUNT TYPE with name: "+ at.getAccountType());			
			logger.info(" -- CHECKING ACCOUNT TYPE ...");
			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = (Transaction) pm.currentTransaction();		
			//Start the transaction
			tx.begin();

			Query<AccountType> query = pm.newQuery(AccountType.class);
			
			@SuppressWarnings("unchecked")
			List<AccountType> AccountTypes = (List<AccountType>) query.execute();
			
			for(int i = 0; i<AccountTypes.size(); i++){
				if(AccountTypes.get(i).getAccountType().equals(at.getAccountType())){
					return false;
				}
			}
			
			logger.info(" -- Creating new ACCOUNT TYPE with name: "+at.getAccountType());
			pm.makePersistent(at);
			
			//End the transaction
			tx.commit();
			
		} catch (Exception e) {
			logger.error(" -- CHECKING ACCOUNT TYPE  --  $ Error creating ACCOUNT TYPE: " + e.getMessage());
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
	public List<AccountType> getAllAccountTypes(){
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = (Transaction) pm.currentTransaction();
		
		try {
			logger.info("-- Retrieving all ACCOUNT TYPES --");			
			logger.info(" -- GETTING ACCOUNT TYPES -- ");
			
			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = (Transaction) pm.currentTransaction();		
			//Start the transaction
			tx.begin();
			
			Query<AccountType> query = pm.newQuery(AccountType.class);
			
			@SuppressWarnings("unchecked")
			List<AccountType> AccountTypes = (List<AccountType>) query.execute();
			
			//End the transaction
			tx.commit();
			
			return AccountTypes;
			
		} catch (Exception e) {
			logger.error(" -- GETTING ACCOUNT TYPES --  $ Error retrieving ACCOUNT TYPES using a 'Query': " + e.getMessage());
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
	public List<Account> getAllAccountsForDirector(){
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = (Transaction) pm.currentTransaction();
		
		try {
			logger.info("-- Retrieving all ACCOUNT in the Bank for the Director --");			
			logger.info(" -- GETTING ALL ACCOUNTS -- ");
			
			//Get the Persistence Manager
			pm = pmf.getPersistenceManager();
			//Obtain the current transaction
			tx = (Transaction) pm.currentTransaction();		
			//Start the transaction
			tx.begin();
			
			Query<Account> query = pm.newQuery(Account.class);
			
			@SuppressWarnings("unchecked")
			List<Account> allAccounts = (List<Account>) query.execute();
			
			//End the transaction
			tx.commit();
			
			return allAccounts;
			
		} catch (Exception e) {
			logger.error(" -- GETTING ALL ACCOUNTS --  $ Error retrieving ALL ACCOUNTS using a 'Query': " + e.getMessage());
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
	public boolean freezeAccount(String bankingAccount){
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx =  pm.currentTransaction();
		
		try {				
			logger.info(" -- FREEZING ACCOUNT METHOD -- ");
			logger.info(" -- Freezing: "+ bankingAccount + " BANKING ACCOUNT! -- ");
			
			//Start the transaction
			tx.begin();

			Query<Account> query = pm.newQuery(Account.class);
			
			@SuppressWarnings("unchecked")
			List<Account> accounts = (List<Account>) query.execute();

			for (int i = 0; i<accounts.size();i++) {
				if (bankingAccount.equals(accounts.get(i).getAccountID())){
					
					//Freeze account
					accounts.get(i).setFreezeAccount("FREEZED");
				
					//End the transaction
					tx.commit();
					return true;			
					
				}
			}

			//End the transaction
			tx.commit();
		} catch (Exception e) {
			System.err.println(" -- FREEZING ACCOUNT METHOD --  $ Error retrieving ACCOUNT using a 'Query': " + e.getMessage());
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
	public boolean unfreezeAccount(String bankingAccount){
		// TODO Auto-generated method stub
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx =  pm.currentTransaction();
		
		try {				
			logger.info(" -- UNFREEZING ACCOUNT METHOD -- ");
			logger.info(" -- Unfreezing: "+ bankingAccount + " BANKING ACCOUNT! -- ");
			
			//Start the transaction
			tx.begin();

			Query<Account> query = pm.newQuery(Account.class);
			
			@SuppressWarnings("unchecked")
			List<Account> accounts = (List<Account>) query.execute();

			for (int i = 0; i<accounts.size();i++) {
				if (bankingAccount.equals(accounts.get(i).getAccountID())){
					
					//Unfreeze account
					accounts.get(i).setFreezeAccount("UNFREEZED");
				
					//End the transaction
					tx.commit();
					return true;			
					
				}
			}

			//End the transaction
			tx.commit();
		} catch (Exception e) {
			System.err.println(" -- UNFREEZING ACCOUNT METHOD --  $ Error retrieving ACCOUNT using a 'Query': " + e.getMessage());
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
	
	
	
	//DELETE DATABASE METHODS
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
	
	public void deleteAllAccounts() {

		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			JDOQuery<Account> query = (JDOQuery<Account>) pm.newQuery(Account.class);
			query.deletePersistentAll();
			logger.info("Deleting Accounts from the DB... DELETED!");
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
	
	public void deleteAllBankTransactions() {

		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			JDOQuery<BankTransaction> query = (JDOQuery<BankTransaction>) pm.newQuery(BankTransaction.class);
			query.deletePersistentAll();
			logger.info("Deleting BankTransaction from the DB... DELETED!");
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
	
	public void deleteAllAccountTypes() {

		PersistenceManager pm = pmf.getPersistenceManager();

		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			JDOQuery<AccountType> query = (JDOQuery<AccountType>) pm.newQuery(AccountType.class);
			query.deletePersistentAll();
			logger.info("Deleting Account Types from the DB... DELETED!");
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
