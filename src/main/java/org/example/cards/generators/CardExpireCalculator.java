package org.example.cards.generators;

import jakarta.inject.Singleton;

import java.util.Random;

@Singleton
public class CardExpireCalculator {
    public String generateExpireMonth(){
        Random random = new Random();
        int month = random.nextInt(12) + 1; // 1–12
        return String.format("%02d", month);
    }
    public String generateExpireYear(){
        Random random = new Random();
        int year = random.nextInt(75) + 25; // gives 26–100 (assuming 2026–2100)
        return String.format("%02d", year);
    }
}
