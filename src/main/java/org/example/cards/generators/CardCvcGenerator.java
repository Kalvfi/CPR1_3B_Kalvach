package org.example.cards.generators;

import jakarta.inject.Singleton;

import java.util.Random;

@Singleton
public class CardCvcGenerator {
    public String generateCvc(){
        Random random = new Random();

        int cvc = random.nextInt(900) + 100;
        return String.valueOf(cvc);
    }
}
