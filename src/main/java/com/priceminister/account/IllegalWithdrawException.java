package com.priceminister.account;

public class IllegalWithdrawException extends Exception {

    private Double withdrawAmount;

    public IllegalWithdrawException(Double withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public IllegalWithdrawException() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String toString() {
        return "Illegal withdraw Amount: " + withdrawAmount;
    }
}
