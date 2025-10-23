package org.example;

import org.example.cards.generators.CardNumberGenerator;
import org.example.cards.generators.CardCvcGenerator;
import org.example.cards.generators.CardExpireCalculator;
import org.example.cards.generators.CardPinGenerator;
import org.example.cards.factories.CardFactory;
import org.example.cards.services.CardStorageService;
import org.example.accounts.generators.AccountNumberGenerator;
import org.example.accounts.factories.BankAccountFactory;
import org.example.accounts.services.AccountBalanceService;
import org.example.accounts.services.AccountCardsService;
import org.example.accounts.services.InputValidationService;
import org.example.cards.services.ATM;
import org.example.persons.customers.factories.CustomerFactory;
import org.example.persons.customers.serialization.factories.CustomerSerializationFactory;
import org.example.persons.customers.serialization.services.CustomerJsonSerializationService;
import org.example.persons.customers.serialization.services.CustomerXmlSerializationService;

public class Container {

    public Logger logger;

    public CardNumberGenerator cardNumberGenerator;
    public CardCvcGenerator cardCvcGenerator;
    public CardExpireCalculator cardExpireCalculator;
    public CardPinGenerator cardPinGenerator;
    public CardFactory cardFactory;
    public CardStorageService cardStorageService;

    public InputValidationService inputValidationService;
    public AccountNumberGenerator accountNumberGenerator;
    public BankAccountFactory bankAccountFactory;
    public AccountBalanceService accountBalanceService;
    public AccountCardsService accountCardsService;

    public ATM atm;

    public CustomerFactory customerFactory;
    public CustomerSerializationFactory customerSerializationFactory;
    public CustomerJsonSerializationService customerJsonSerializationService;
    public CustomerXmlSerializationService customerXmlSerializationService;

    public Container() {
        this.logger = new Logger();

        this.cardNumberGenerator = new CardNumberGenerator();
        this.cardCvcGenerator = new CardCvcGenerator();
        this.cardExpireCalculator = new CardExpireCalculator();
        this.cardPinGenerator = new CardPinGenerator();
        this.cardFactory = new CardFactory(cardNumberGenerator, cardCvcGenerator, cardExpireCalculator, cardPinGenerator);
        this.cardStorageService = new CardStorageService();

        this.inputValidationService = new InputValidationService();
        this.accountNumberGenerator = new AccountNumberGenerator();
        this.bankAccountFactory = new BankAccountFactory(accountNumberGenerator);
        this.accountBalanceService = new AccountBalanceService(logger, inputValidationService);
        this.accountCardsService = new AccountCardsService(cardFactory, cardStorageService);

        this.atm = new ATM(accountBalanceService, logger);

        this.customerFactory = new CustomerFactory();
        this.customerSerializationFactory = new CustomerSerializationFactory();
        this.customerJsonSerializationService = new CustomerJsonSerializationService(customerSerializationFactory);
        this.customerXmlSerializationService = new CustomerXmlSerializationService(customerSerializationFactory);
    }
}
