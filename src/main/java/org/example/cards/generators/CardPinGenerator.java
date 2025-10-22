package org.example.cards.generators;

import java.util.Scanner;

public class CardPinGenerator {
    public String generatePin(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your PIN code (4 digits): ");
        String pin = scanner.nextLine();

        while (!pin.matches("\\d{4}")) {
            System.out.print("Invalid PIN. Please enter exactly 4 digits: ");
            pin = scanner.nextLine();
        }

        return pin;
    }
}
