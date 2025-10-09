package org.example.accounts;

import org.example.accounts.cards.PaymentCard;
import org.example.persons.customers.Customer;

import java.util.List;
import java.util.ArrayList;

public class BankAccount extends BaseBankAccount {

    private List<PaymentCard> cards;

    public BankAccount(String uuid, String bankAccountNumber, Customer customer) {
        super(uuid, bankAccountNumber, customer, 0);
        this.cards = new ArrayList<PaymentCard>();
    }

    public List<PaymentCard> getCards() {
        return cards;
    }
}
