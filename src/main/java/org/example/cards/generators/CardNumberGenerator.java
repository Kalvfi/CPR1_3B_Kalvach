package org.example.cards.generators;

import jakarta.inject.Singleton;

import java.util.Random;

@Singleton
public class CardNumberGenerator {

    public String generateCardNumber(){
        Random random = new Random();
        StringBuilder cardNumber = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int quartet = random.nextInt(9000) + 1000;
            cardNumber.append(quartet);
            if (i < 3) {
                cardNumber.append(" ");
            }
        }
        return cardNumber.toString();
    }
}
