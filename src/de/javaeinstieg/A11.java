package de.javaeinstieg;

import java.util.Scanner;

import static de.javaeinstieg.ScannerUtils.*;

@SuppressWarnings("SpellCheckingInspection")
public final class A11 {

    private static final String CODE = "Code";

    public static void main(final String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final int max = nonNegativeInteger(scanner, "Bitte gebe an wie viele versuche jeder Gast haben soll, um den Code einzugeben!");
            int counter = 0;
            while (counter++ < max) {
                final String code = string(scanner, "Bitte gebe den Code ein:");
                if (code.equals(CODE)) {
                    System.out.println("Willkommen auf der Party!");
                    break;
                }
                System.out.print("Falsch! ");
            }
        }
    }

}
