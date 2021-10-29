package test.finance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import in.conceptarchitact.finance.BankAccount;
import in.conceptarchitact.finance.Bank;

public class BankAccountTests {

	String password="password";
	double amount=20000;
	
	BankAccount account;
	Bank bank;
	
	
	@Before
	public void init() {
		account =new BankAccount(1, "Vivek", password, amount);
		System.out.println("@Before called");
	}

	@Test
	public void withdrawShouldFailForNegativeAmount() {
	
		boolean result=account.withdraw(-1, password);		
		assertEquals(false, result);
	}
	

	@Test public void withdrawShouldFailForInvalidPassword() {
		
		boolean result=account.withdraw(1, "wrong-password");
		
		assertFalse(result);
	}
	
	
	@Test public void withdrawShouldFailForExcessAmount() {
		boolean result=account.withdraw(amount+1, password);
		assertEquals(false,result);
	}
	
	@Test public void withdrawShouldPassForValidAmountAndPassword() {
		String password="password";
		double amount=20000;
		BankAccount account=new BankAccount(1,"Vivek",password, amount);
		boolean result=account.withdraw(amount, password);
		
		assertTrue(result);
		assertEquals(0, account.getBalance(),0.001);
	}
	
	@Test
	public void depositShouldFailForInvalidValue() {
		boolean result =account.deposit(100);
		assertEquals(true,result);
		
	}
	@Test
	public void depositShoudFailForInvalidAccount() {
		boolean result = bank.deposit(1222, 12233);
		assertEquals(false,result);
	}
	@Test
	public void depositShoudFailForInvalidAccountAndInvalidAmount() {
		boolean result = bank.deposit(-1222, -3000);
		assertEquals(false,result);
	}
	@Test
	public  void depositeShouldPassForValidAccountNoAndAmount()
	{
		boolean result = bank.deposit(1, 3000);
		assertEquals(false,result);
	}
	
	
	
}
