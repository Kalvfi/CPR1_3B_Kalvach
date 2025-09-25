package org.example.accounts.services;

public class InputValidationService {
    public void checkPositiveAmount(double amount){
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive!");
    }

    public void checkMaxAmount(double amount){
        if (amount > 100000) throw new IllegalArgumentException("Cannot deposit amounts higher than 10000!");
    }

    public void checkFinalAmount(double balance, double amount){
        if (amount > balance) throw new IllegalArgumentException("Final balance can't be negative!");
    }
}