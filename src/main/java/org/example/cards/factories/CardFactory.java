package org.example.cards.factories;

import org.example.accounts.BankAccount;
import org.example.cards.*;
import org.example.cards.generators.CardCvcGenerator;
import org.example.cards.generators.CardExpireCalculator;
import org.example.cards.generators.CardNumberGenerator;
import org.example.cards.generators.CardPinGenerator;

public class CardFactory {

    CardNumberGenerator cardNumberGenerator = new CardNumberGenerator();
    CardCvcGenerator cardCvcGenerator = new CardCvcGenerator();
    CardExpireCalculator cardExpireCalculator = new CardExpireCalculator();
    CardPinGenerator cardPinGenerator = new CardPinGenerator();

    public PaymentCard createPaymentCard(String owner, BankAccount account)
    {
        String cardNumber = cardNumberGenerator.generateCardNumber();
        String cvc = cardCvcGenerator.generateCvc();
        String expireMonth = cardExpireCalculator.generateExpireMonth();
        String expireYear = cardExpireCalculator.generateExpireYear();
        String pin = cardPinGenerator.generatePin();

        return new PaymentCard(owner,expireYear,expireMonth,cvc,cardNumber, pin, account);
    }
}
