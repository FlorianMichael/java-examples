package de.javaeinstieg;

import java.util.Scanner;

import static de.javaeinstieg.ScannerUtils.*;

@SuppressWarnings("SpellCheckingInspection")
public final class A09 {

    private static final double MAX_LIMIT = -40.0;
    private static double balance = 0.0;

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        while (true) {
            final int action = rangedInteger(scanner, 0, 2, "Möchten sie Geld einzahlen (0), auszahlen (1) oder einsehen (2)?");
            if (action == 0) {                
                final double add = rangedDecimal(scanner, 0, Double.MAX_VALUE, "Wie viel möchtest du einzahlen?");
                balance += add;   
                System.out.println("Dein Kontostand beträgt jetzt " + balance + " Euro."); 
            } else if (action == 1) {
                final double remove = getInput(
                    scanner, 
                    "Wie viel möchtest du abheben?",
                    Double::parseDouble,
                    value -> balance - value >= MAX_LIMIT,
                    "Bitte gebe eine gültige Dezimalzahl ein, die das Kontolimit (" + MAX_LIMIT + " Euro) nicht überschreitet."
                );
                balance -= remove;
                System.out.println("Dein Kontostand beträgt jetzt " + balance + " Euro."); 
            } else if (action == 2) {
                System.out.println("Dein Kontostand beträgt " + balance + " Euro."); 
            }
        }
    }

}
