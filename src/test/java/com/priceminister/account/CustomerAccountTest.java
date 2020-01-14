package com.priceminister.account;

import static org.junit.Assert.*;

import org.junit.*;

import com.priceminister.account.implementation.*;

/**
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, the develop the code that makes it pass. Then focus
 * on the second test, and so on.
 *
 * We want to see how you "think code", and how you organize and structure a
 * simple application.
 *
 * When you are done, please zip the whole project (incl. source-code) and send
 * it to recrutement-dev@priceminister.com
 *
 */
public class CustomerAccountTest {

    Account customerAccount;
    AccountRule rule;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        customerAccount = new CustomerAccount();
    }

    /**
     * Tests that an empty account always has a balance of 0.0, not a NULL.
     */
    @Test
    public void testAccountWithoutMoneyHasZeroBalance() {
        //assertEquals(double,double) is depracated
        Assert.assertTrue(customerAccount.getBalance() == 0.0);
    }

    /**
     * Adds money to the account and checks that the new balance is as expected.
     */
    @Test
    public void testAddOperation() {
        Double oldBalance = customerAccount.getBalance();
        Double positiveAmount = 5.0;
        customerAccount.add(positiveAmount);
        //assertEquals(double,double) is depracated
        Assert.assertTrue(customerAccount.getBalance().equals(oldBalance + positiveAmount));

    }

    /**
     * Tests that an illegal withdrawal throws the expected exception. Use the
     * logic contained in CustomerAccountRule; feel free to refactor the
     * existing code.
     */
    @Test(expected = IllegalBalanceException.class)
    public void testWithdrawAndReportBalanceIllegalBalance() throws IllegalBalanceException {
        Double withdrawnAmount = customerAccount.getBalance() + 5.0;
        customerAccount.withdrawAndReportBalance(withdrawnAmount, rule);
    }

    /*
    Tests that a negative amount add throws the expected exception. 
     */
    @Test(expected = IllegalAddException.class)
    public void testAddPositiveAmount() {
        Double negativeAmount = -5.0;
        customerAccount.add(negativeAmount);
    }

    /**
     * Tests that a negative amount withdrawal throws the expected exception.
     */
    @Test(expected = IllegalWithdrawException.class)
    public void testwithdrawPositiveAmount() throws IllegalWithdrawException, IllegalBalanceException {
        Double negativeAmount = -5.0;
        customerAccount.withdrawAndReportBalance(negativeAmount, rule);
    }

}
