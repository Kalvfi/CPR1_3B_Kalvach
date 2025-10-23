package org.example;

import org.example.accounts.StudentAccount;
import org.example.persons.customers.Customer;

public class Main {
    public static void main(String[] args) {

        final Container container = new Container();

        Customer customer = container.customerFactory.createCustomer("Filip", "Kalvach");

        StudentAccount account = container.bankAccountFactory.createStudentAccount(
                customer,
                "DELTA-SŠIE");

        System.out.println("UUID: " + account.getUuid());
        System.out.println("Bank account number: " + account.getBankAccountNumber());
        System.out.println("Customer: " + account.getCustomer().getFullName());
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Student of: " + account.getStudentOf());

        container.accountBalanceService.deposit(account, 5000);

        System.out.println("\nBalance after adding: " + account.getBalance());

        container.accountCardsService.addCard(account);

        System.out.println("\nCards: ");
        account.getCards().forEach(card -> System.out.println(card.getCardNumber() + " " + card.getBankAccount().getBankAccountNumber()));

        container.atm.withdraw(container.cardStorageService.getAllCards().getFirst(), 5000);

        System.out.println(container.cardStorageService.getAllCards().getFirst().getBankAccount().getCustomer().getFullName());

        container.cardStorageService.getAllCards().forEach(card -> System.out.println(card.getCardNumber()));
    }
}