package test.java.es.deusto.server.dao;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import main.java.es.deusto.server.dao.BankingSystemDAO;
import main.java.es.deusto.server.data.Account;
import main.java.es.deusto.server.data.AccountType;
import main.java.es.deusto.server.data.User;

public class BankingSystemDAOTest {
	
	private static BankingSystemDAO dao;
	private static User user;
	private static User user2;
	private static Account a;
	private static Account a2;
	private static AccountType at;
	
	@BeforeClass
	public static void setUpClass() {
		dao = new BankingSystemDAO();
		user = new User("7891331X", "Password", "Sofia", "Gomez", "Clara", "17/10/1976s", 656473819, "Sofia@gmail.es", "Spain", "Bilbao", 01011);
		user2 = new User("9281281Y", "Password34", "Raul", "Plano", "Huki", "17/08/1969", 688273821, "Raul@gmail.es", "Spain", "Bilbao", 01011);
		
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String year = timeStamp.substring(0, 4);
		String month = timeStamp.substring(4,6);
		String day = timeStamp.substring(6,8);
		String hour = timeStamp.substring(9,11);
		String minute = timeStamp.substring(11,13);
		
		a = new Account (user.getUserID() + timeStamp, hour, minute, day, month, year, 0);
		a2 = new Account (user2.getUserID() + timeStamp, hour, minute, day, month, year, 0);
		
		at = new AccountType("Young Account", "5% of discount in drawing money.");
		
		// Delete all from the DB
		dao.deleteAllBankTransactions();
		dao.deleteAllAccounts();
		dao.deleteAllUsers();
		dao.deleteAllAccountTypes();
	}
	
	
	@Test
	public void testUser() {
		//Check if User exist
		assertEquals(dao.checkUser(user.getUserID()), true);
		assertEquals(dao.checkUser(user2.getUserID()), true);
		
		//New User
		dao.newUser(user);
		dao.newUser(user2);
		
		//New account to the users
		dao.newUserAccount(a, user.getUserID());
		dao.newUserAccount(a2, user2.getUserID());
		
		//User login
		assertEquals(dao.logIn(user.getUserID(), user.getPassword()), true);
		
		//Show user information RETURN A USER
		List<User> listUser = dao.showUserInfo();

		assertEquals(listUser.get(0).getName(), user.getName());
		assertEquals(listUser.get(0).getSurName1(), user.getSurName1());
		
		//Forget password
		assertEquals(dao.forgetPassword(user.getUserID(), user.getEmail()), user.getPassword());
		
		//Change password
		assertEquals(dao.changePassword(user.getUserID(), user.getPassword(), "Secret"), true);
		
		//Change user information
		User u = new User("7891331X", "Password", "Sofia", "Gomez", "Clara", "17/10/1976s", 656473819, "Sofia@gmail.es", "Spain", "San Sebastian", 07061);
		dao.changeUserInfo(u);
		
		//Show user information RETURN A USER
		List<User> listUserChanged = dao.showUserInfo();
		
		assertEquals(listUserChanged.get(0).getResidence(), u.getResidence());
		
		//New Account Type
		dao.createAccountType(at);
	}
	
	@Test
	public void testUserMethods() {
		//Insert Money
		dao.insertMoney(a.getAccountID(),1000);
		
		//Draw Money
		dao.drawMoney(a.getAccountID(), 450);
		
		//Show account information RETURN A LIST
		dao.getUserAccounts();
	}
	
	@Test
	public void testUserTransactions() {
		//Transaction
		dao.transaction(a.getAccountID(), a2.getAccountID(), 40);
	
//		//Get Transactions LIST OF TRANSACTIONS
		dao.getBankTransactions(a.getAccountID());
	}
	
//	@Test
//	public void testDeleteDB() {
//		// Delete all Users from the DB
//		dao.deleteAllBankTransactions();
//		dao.deleteAllAccounts();
//		dao.deleteAllUsers();
//	}
}
