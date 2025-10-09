package org.example.accounts.cards;

import java.util.ArrayList;
import java.util.List;

public class CardStorageService {
    static List<PaymentCard> allCards = new ArrayList<PaymentCard>();

    public static List<PaymentCard> getAllCards() {
        return allCards;
    }

    public static PaymentCard getCardByCardNumber(String cardNumber) {
        for (PaymentCard card : allCards) {
            if (card.getCardNumber().equals(cardNumber)) {
                return card;
            }
        }
        throw new IllegalArgumentException();
    }
}
