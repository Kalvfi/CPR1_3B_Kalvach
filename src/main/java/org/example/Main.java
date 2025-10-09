package org.example;


import org.example.accounts.BankAccount;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.StudentAccount;
import org.example.accounts.cards.CardStorageService;
import org.example.accounts.factories.BankAccountFactory;
import org.example.accounts.services.AccountBalanceService;
import org.example.accounts.services.AccountCardsService;
import org.example.persons.customers.Customer;

public class Main {
    public static void main(String[] args) {

        BankAccountFactory baf = new BankAccountFactory();
        AccountBalanceService abs = new AccountBalanceService();
        AccountCardsService acs = new AccountCardsService();

        Customer customer = new Customer( "c-123", "Filip", "Kalvach");

        StudentAccount account = baf.createStudentAccount(
                "u-123",
                customer,
                "DELTA-SŠIE");

        System.out.println("UUID: " + account.getUuid());
        System.out.println("Bank account number: " + account.getBankAccountNumber());
        System.out.println("Customer: " + account.getCustomer().getFullName());
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Student of: " + account.getStudentOf());

        abs.deposit(account, 5000);

        System.out.println("\nBalance after adding: " + account.getBalance());

        acs.addCard(account);

        System.out.println("\nCards: ");
        account.getCards().forEach(card -> System.out.println(card.getCardNumber() + " " + card.getBankAccount().getBankAccountNumber()));

        abs.withdraw(CardStorageService.getAllCards().getFirst().getBankAccount(), 5000);

        System.out.println(CardStorageService.getCardByCardNumber("0000111122223333").getBankAccount().getCustomer().getFullName());

        CardStorageService.getAllCards().forEach(card -> System.out.println(card.getCardNumber()));

    }
}