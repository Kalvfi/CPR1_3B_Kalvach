package org.example;


import org.example.accounts.StudentAccount;
import org.example.cards.services.CardStorageService;
import org.example.accounts.factories.BankAccountFactory;
import org.example.cards.services.ATM;
import org.example.accounts.services.AccountBalanceService;
import org.example.accounts.services.AccountCardsService;
import org.example.persons.customers.Customer;
import org.example.persons.customers.factories.CustomerFactory;

public class Main {
    public static void main(String[] args) {

        CustomerFactory customerFactory = new CustomerFactory();
        BankAccountFactory bankAccountFactory = new BankAccountFactory();
        AccountBalanceService accountBalanceService = new AccountBalanceService();
        AccountCardsService accountCardsService = new AccountCardsService();
        ATM atm = new ATM();

        Customer customer = customerFactory.createCustomer("Filip", "Kalvach");

        StudentAccount account = bankAccountFactory.createStudentAccount(
                customer,
                "DELTA-SŠIE");

        System.out.println("UUID: " + account.getUuid());
        System.out.println("Bank account number: " + account.getBankAccountNumber());
        System.out.println("Customer: " + account.getCustomer().getFullName());
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Student of: " + account.getStudentOf());

        accountBalanceService.deposit(account, 5000);

        System.out.println("\nBalance after adding: " + account.getBalance());

        accountCardsService.addCard(account);

        System.out.println("\nCards: ");
        account.getCards().forEach(card -> System.out.println(card.getCardNumber() + " " + card.getBankAccount().getBankAccountNumber()));

        atm.withdraw(CardStorageService.getAllCards().getFirst(), 5000);

        System.out.println(CardStorageService.getAllCards().getFirst().getBankAccount().getCustomer().getFullName());

        CardStorageService.getAllCards().forEach(card -> System.out.println(card.getCardNumber()));

    }
}