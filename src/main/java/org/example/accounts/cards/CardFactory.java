package org.example.accounts.cards;

import org.example.accounts.BankAccount;

public class CardFactory {

    CardNumberGenerator cng = new CardNumberGenerator();
    CardCvcGenerator ccg = new CardCvcGenerator();
    CardExpireCalculator cec = new CardExpireCalculator();

    public PaymentCard createPaymentCard(String owner, BankAccount account)
    {
        String cardNumber = "0000111122223333";
        String cvc = "000";
        String expireMonth = "01";
        String expireYear = "30";

        return new PaymentCard(owner,expireYear,expireMonth,cvc,cardNumber, account);
    }
}
