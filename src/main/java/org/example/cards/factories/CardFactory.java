package org.example.cards.factories;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.example.accounts.BankAccount;
import org.example.cards.*;
import org.example.cards.generators.CardCvcGenerator;
import org.example.cards.generators.CardExpireCalculator;
import org.example.cards.generators.CardNumberGenerator;
import org.example.cards.generators.CardPinGenerator;

@Singleton
public class CardFactory {

    @Inject
    private CardNumberGenerator cardNumberGenerator;

    @Inject
    private CardCvcGenerator cardCvcGenerator;

    @Inject
    private CardExpireCalculator cardExpireCalculator;

    @Inject
    private CardPinGenerator cardPinGenerator;

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
