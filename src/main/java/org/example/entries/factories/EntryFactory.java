package org.example.entries.factories;

import jakarta.inject.Singleton;
import org.example.entries.AccountTransferEntry;
import org.example.entries.enums.ActionType;

@Singleton
public class EntryFactory {
    public AccountTransferEntry createAccountTransferRecord(ActionType actionType, double amount){
        return new AccountTransferEntry(actionType, amount);
    }
}
