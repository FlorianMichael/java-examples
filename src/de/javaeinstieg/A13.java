package de.javaeinstieg;

import java.util.Scanner;

import static de.javaeinstieg.ScannerUtils.*;

@SuppressWarnings("SpellCheckingInspection")
public final class A13 {

    private static void sum(final int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    public static void main(final String[] args) {
        for (int i = 7; i <= 70; i += 7) {
            System.out.println(i);
        }

        System.out.println("----");

        for (int i = 17; i <= 170; i += 17) {
            System.out.println(i / 17 + " x 17 = " + i);
        }

        System.out.println("----");

        sum(100);

        System.out.println("----");

        try (final Scanner scanner = new Scanner(System.in)) {
            final int number = nonNegativeInteger(scanner, "Bitte gebe die Zahl an, von der du die Summe berechnen willst!");
            sum(number);
        }

        System.out.println("----");

        for (int i = 0; i < 70; i++) {
            if (i % 4 == 0 || i % 7 == 0) {
                System.out.println(i);
            }
        }

        System.out.println("----");

        try (final Scanner scanner = new Scanner(System.in)) {
            final String text = string(scanner, "Bitte gebe den Text an von dem der Buchstabe E gezählt werden soll");
            int count = 0;
            for (final char character : text.toCharArray()) {
                if (character == 'e' || character == 'E') {
                    count++;
                }
            }
            System.out.println("Der Buchstabe E kommt " + count + " mal vor.");
        }
    }

}
