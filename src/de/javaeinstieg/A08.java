package de.javaeinstieg;

import java.time.LocalDate;
import java.util.Scanner;

import static de.javaeinstieg.ScannerUtils.*;

@SuppressWarnings("SpellCheckingInspection")
public final class A08 {

    public static void main(final String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final char familyName = Character.toLowerCase(letter(scanner, 0, "Bitte geben Sie Ihren Nachnamen ein:"));
            if (familyName <= 'j') {
                System.out.println("Herr Müller");
            } else if (familyName <= 'r') {
                System.out.println("Frau Wolf");
            } else {
                final int age = nonNegativeInteger(scanner, "Bitte geben Sie Ihr Alter ein:");
                if (LocalDate.now().getYear() - age >= 2_000) {
                    System.out.println("Herr Kaya");
                } else {
                    System.out.println("Frau Jahn");
                }
            }
        }
    }

}
