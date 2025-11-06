package org.example.entries;

import org.example.entries.enums.ActionType;

import java.time.OffsetDateTime;

public class AccountTransferEntry {
    private final OffsetDateTime dateTime;
    private final ActionType actionType;
    private final double amount;
    private boolean wasExported;

    public AccountTransferEntry(ActionType actionType, double amount){
        this.dateTime = OffsetDateTime.now();
        this.actionType =  actionType;
        this.amount = amount;
        this.wasExported = false;
    }

    public OffsetDateTime getDateTime() {
        return dateTime;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isWasExported() {
        return wasExported;
    }

    public void setWasExported(boolean wasExported) {
        this.wasExported = wasExported;
    }
}
