package de.javaeinstieg;

import java.util.Scanner;

import static de.javaeinstieg.ScannerUtils.*;

@SuppressWarnings("SpellCheckingInspection")
public final class A12 {

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        double money = nonNegativeDecimal(scanner, "Bitte gebe an wie viel Geld du einwerfen möchtest:");
        while (money > 0) {
            System.out.println("Chips (1) für 1,50 Euro");
            System.out.println("Schokolade (2) für 1,00 Euro");
            System.out.println("Limo (3) für 1,80 Euro");
            System.out.println("Abbruch (0).");

            final int product = nonNegativeInteger(scanner, "Bitte Produkt auswählen:");
            if (product == 0) {
                System.out.println("Auf wiedersehen!");
                break;
            } else {
                final double currentMoney = money;
                if (product == 1) {
                    money -= 1.5;
                } else if (product == 2) {
                    money -= 1;
                } else if (product == 3) {
                    money -= 1.8;
                } else {
                    System.out.println("Dieses Produkt existiert nicht!");
                }

                if (money < 0) {
                    System.out.println("Das Guthaben reicht für diese Aktion nicht aus!");
                    money = currentMoney;
                } else if (money > 0) {
                    System.out.println("Vielen dank für ihren Einkauf! Restguthaben: " + money + " Euro");
                } else {
                    System.out.println("Ihr Guthaben ist nun aufgebraucht!");
                }
            }
        }
    }

}
