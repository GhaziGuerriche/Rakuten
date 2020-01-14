package com.priceminister.account;

public class IllegalAddException extends Exception {

    private Double AddedAmount;

    public IllegalAddException(Double AddedAmount) {
        this.AddedAmount = AddedAmount;
    }

    public String toString() {
        return "Illegal add Amount: " + AddedAmount;
    }
}
