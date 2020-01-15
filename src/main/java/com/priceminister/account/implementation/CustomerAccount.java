package com.priceminister.account.implementation;

import com.priceminister.account.*;

public class CustomerAccount implements Account {

    private Double balance = 0.0;

    public synchronized void add(Double addedAmount) throws IllegalAddException {
        if (addedAmount <= 0.0) {
            throw new IllegalAddException(addedAmount);

        } else {
            balance += addedAmount;
        }

    }

    public synchronized Double getBalance() {
        return balance;
    }

    public synchronized Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule)
            throws IllegalBalanceException, IllegalWithdrawException {
        if (withdrawnAmount <= 0) {
            throw new IllegalWithdrawException(withdrawnAmount);
        } else {
            if (rule.withdrawPermitted(balance - withdrawnAmount)) {
                balance -= withdrawnAmount;
            } else {
                throw new IllegalBalanceException(balance);
            }
        }
        return balance;
    }

}
