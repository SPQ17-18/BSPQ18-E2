package test.java.es.deusto.client.controller;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import main.java.es.deusto.client.controller.controller;
import main.java.es.deusto.server.DTO.AccountDTO;
import main.java.es.deusto.server.dao.BankingSystemDAO;
import main.java.es.deusto.server.data.Account;
import main.java.es.deusto.server.data.AccountType;
import main.java.es.deusto.server.data.User;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;

@PerfTest(invocations=5)
@Required(max=1200,average=250)

public class ControllerTest {
	
	private static controller c;
	private static BankingSystemDAO dao;
	private static Account a;
	private static Account a2;
	private static User director;
	
	@BeforeClass
	public static void setUpClient() {
		//Launch client side
		try {
			System.setProperty("java.security.policy", "target//test-classes//security//java.policy");
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new SecurityManager());
			}
			String args[] = new String[3];
			args[0] = "127.0.0.1";
			args[1] = "1099";
			args[2] = "BankingSystemRMIDAO";
			c.main(args);
		} catch (Exception re) {
			System.exit(-1);
		}
	}
	
	@BeforeClass
	public static void setUpDataBase() {
		c = new controller();
		dao = new BankingSystemDAO();
		
		// Delete all from the DB
		dao.deleteAllBankTransactions();
		dao.deleteAllAccounts();
		dao.deleteAllUsers();
		dao.deleteAllAccountTypes();
		
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String year = timeStamp.substring(0, 4);
		String month = timeStamp.substring(4,6);
		String day = timeStamp.substring(6,8);
		String hour = timeStamp.substring(9,11);
		String minute = timeStamp.substring(11,13);
		
//		director = new User("director", "director", "", "", "", "", 0, "", "", "", 0);
//		
//		dao.newUser(director);
		
	}
	
	@Test
	public void testClientController() {		
		//New User
		assertEquals(controller.newUser("Sofia", "Gomez", "Clara", 01011, "Spain", "Bilbao", 656473819, "Sofia@gmail.es","17/10/1976","7891331X", "Password"), true);
		
		//Login
		assertEquals(controller.logIn("7891331X","Password"), true);
		
		//NEW ACCOUNTS
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String year = timeStamp.substring(0, 4);
		String month = timeStamp.substring(4,6);
		String day = timeStamp.substring(6,8);
		String hour = timeStamp.substring(9,11);
		String minute = timeStamp.substring(11,13);
		a = new Account ("89912ed" + timeStamp, hour, minute, day, month, year, 0, "Young Account");
		a2 = new Account ("daflsdal" + timeStamp, hour, minute, day, month, year, 0, "Young Account");
			
		dao.newUserAccount(a);
		dao.newUserAccount(a2);
		
		//Forget password
		assertEquals(controller.forgetPassword("7891331X", "Sofia@gmail.es"), true);
		
		//Change password
		assertEquals(controller.changePassword("Password", "Sofia91"), true);
		
		//New user Account
		controller.newUserAccount("Young Account");
		
		//Get User accounts
		List<AccountDTO> userAccount = controller.getUserAccounts();
		
		//Insert Money
		assertEquals(controller.insertMoney(userAccount.get(0).getAccountID(), 1000),true);
		
		//Draw Money
		controller.newUserAccount("Young Account");
		assertEquals(controller.drawMoney(userAccount.get(0).getAccountID(), 100),true);
		
		//Transaction
		//assertEquals(controller.transaction(userAccount.get(0).getAccountID(), userAccount.get(1).getAccountID(), 60),true);
		
		//Get Account Bank Transactions
		controller.getAccountBankTransactions(userAccount.get(0).getAccountID());
		
		//New User Director
		assertEquals(controller.newUser("", "", "", 0, "", "", 0, "","","director", "director"), true);
		
		//Log in as the director
		controller.logIn("director", "director");
		
		//New Account Type
		controller.newaccountType("Young Account", "5% of discount in drawing money.");
		
		//Get Account Types
		controller.getAccountTypes();
		
		//Get all accounts
		List<AccountDTO> allAccounts = controller.getAllAccounts();
		
//		//Freeze Account
//		controller.freezeAccount(allAccounts.get(0).getAccountID());
//		assertEquals(allAccounts.get(0).isFreezeAccount(), "FREEZED");
//		
//		//Unfreeze Account
//		controller.unfreezeAccount(allAccounts.get(0).getAccountID());
//		assertEquals(allAccounts.get(0).isFreezeAccount(), "UNFREEZED");
	}

}
