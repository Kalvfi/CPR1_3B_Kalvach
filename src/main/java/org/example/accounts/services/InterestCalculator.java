package org.example.accounts.services;

import jakarta.inject.Singleton;
import org.example.accounts.SaveAccount;

@Singleton
public class InterestCalculator {

    public double calculateInterest(SaveAccount saveAccount)
    {
        return saveAccount.getBalance() * saveAccount.getInterestRate();
    }
}
