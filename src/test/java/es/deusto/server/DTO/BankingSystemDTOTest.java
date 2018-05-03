package test.java.es.deusto.server.DTO;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import main.java.es.deusto.server.DTO.AccountAssembler;
import main.java.es.deusto.server.DTO.BankTransactionAssembler;
import main.java.es.deusto.server.DTO.UserAssembler;
import main.java.es.deusto.server.data.Account;
import main.java.es.deusto.server.data.BankTransaction;
import main.java.es.deusto.server.data.User;

public class BankingSystemDTOTest {

	private static User user;
	private static User user2;
	private static Account account;
	private static Account account2;
	private static BankTransaction bt;
	private static BankTransaction bt2;
	
	private static AccountAssembler as;
	private static BankTransactionAssembler bts;
	private static UserAssembler ua;
	
	private static List<User> userList = new ArrayList<User>();
	private static List<Account> accountList = new ArrayList<Account>();
	private static List<BankTransaction> BankTransactionList = new ArrayList<BankTransaction>();
	
	@BeforeClass
	public static void setUpClass() {
		//USER
		user = new User("7891331X", "Password", "Sofia", "Gomez", "Clara", "98128381239FKKA", "17/10/1976s", 656473819, "Sofia@gmail.es", "Spain", "Bilbao", 01011, null, null);
		user2 = new User("9281281Y", "Password34", "Raul", "Plano", "Huki", "213421892S21FCC", "17/08/1969", 688273821, "Raul@gmail.es", "Spain", "Bilbao", 01011, null, null);
		
		//ACCOUNT
		account = new Account("10", "11", "2", "10", "1997", 100, 1000, "INSERT", "POS");
		account2 = new Account("11", "21", "3", "2", "1993", 100, 1010, "INSERT", "POS");
	
		//BANK TRANSACTION
		bt = new BankTransaction("7891331X", "213421892S21FCC", 60, "TRANS", "10", "2", "7", "10", "2000");
		bt2 = new BankTransaction("9281281Y", "98128381239FKKA", 70, "TRANS", "11", "2", "7", "10", "2010");
		
		//LISTS
		userList.add(user);
		userList.add(user2);
		
		accountList.add(account);
		accountList.add(account2);
		
		BankTransactionList.add(bt);
		BankTransactionList.add(bt2);
		
		//ASSEMBLERS
		as = new AccountAssembler();
		bts = new BankTransactionAssembler();
		ua = new UserAssembler();
	}
	
	@Test
	public void testAssembler() {
		//User assembler
		assertEquals(ua.assemble(userList).get(0).getName(), user.getName());
		assertEquals(ua.assemble(userList).get(1).getSurName1(), user2.getSurName1());
		
		//Account assembler
		assertEquals(as.assemble(accountList).get(0).getAmount(), account.getAmount());
		assertEquals(as.assemble(accountList).get(1).getDay(), account2.getDay());
		
		//BankTransaction
		assertEquals(bts.assemble(BankTransactionList).get(0).getAmount(), bt.getAmount());
		assertEquals(bts.assemble(BankTransactionList).get(1).getDay(), bt2.getDay());
	
	}
}