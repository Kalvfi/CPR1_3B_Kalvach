package org.example.cards.generators;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.Scanner;

@Singleton
public class CardPinGenerator {

    @Inject
    Scanner scanner;

    public String generatePin(){


        System.out.print("Enter your PIN code (4 digits): ");
        String pin = scanner.nextLine();

        while (!pin.matches("\\d{4}")) {
            System.out.print("Invalid PIN. Please enter exactly 4 digits: ");
            pin = scanner.nextLine();
        }

        return pin;
    }
}
