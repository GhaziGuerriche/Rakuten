package com.priceminister.account;

public class IllegalWithdrawException extends Exception {

    private Double withdrawAmount;

    public IllegalWithdrawException(Double withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public String toString() {
        return "Illegal withdraw Amount: " + withdrawAmount;
    }
}
