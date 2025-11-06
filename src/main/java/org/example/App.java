package org.example;

import jakarta.inject.Inject;
import org.example.accounts.SaveAccount;
import org.example.accounts.StudentAccount;
import org.example.accounts.cron.InterestCronService;
import org.example.accounts.factories.BankAccountFactory;
import org.example.accounts.services.AccountTransferService;
import org.example.accounts.services.AccountCardsService;
import org.example.cards.services.ATM;
import org.example.cards.services.CardStorageService;
import org.example.entries.cron.AccountTransferEntryCronService;
import org.example.persons.customers.Customer;
import org.example.persons.customers.factories.CustomerFactory;

public class App {

    @Inject
    private CustomerFactory customerFactory;

    @Inject
    private BankAccountFactory bankAccountFactory;

    @Inject
    private AccountTransferService accountTransferService;

    @Inject
    private AccountCardsService accountCardsService;

    @Inject
    private ATM atm;

    @Inject
    private CardStorageService cardStorageService;

    @Inject
    private InterestCronService interestCronService;

    @Inject
    private AccountTransferEntryCronService accountTransferEntryCronService;

    public void run(){

        Customer customer = customerFactory.createCustomer("Filip", "Kalvach");

        StudentAccount account = bankAccountFactory.createStudentAccount(
                customer,
                "DELTA-SŠIE");

        System.out.println("UUID: " + account.getUuid());
        System.out.println("Bank account number: " + account.getBankAccountNumber());
        System.out.println("Customer: " + account.getCustomer().getFullName());
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Student of: " + account.getStudentOf());

        accountTransferService.deposit(account, 5000);

        System.out.println("\nBalance after adding: " + account.getBalance());

        accountCardsService.addCard(account);

        System.out.println("\nCards: ");
        account.getCards().forEach(card -> System.out.println(card.getCardNumber() + " " + card.getBankAccount().getBankAccountNumber()));

        atm.withdraw(cardStorageService.getAllCards().getFirst(), 5000);

        System.out.println(cardStorageService.getAllCards().getFirst().getBankAccount().getCustomer().getFullName());

        cardStorageService.getAllCards().forEach(card -> System.out.println(card.getCardNumber()));

        SaveAccount saveAccount = bankAccountFactory.createSaveAccount(customer, 0.05f);

        accountTransferService.deposit(saveAccount, 5000);

        interestCronService.start();
        accountTransferEntryCronService.start();
    }
}
