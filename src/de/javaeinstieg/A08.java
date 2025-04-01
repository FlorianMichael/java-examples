package de.javaeinstieg;

import java.time.LocalDate;
import java.util.Scanner;

import static de.javaeinstieg.ScannerUtils.*;

@SuppressWarnings("SpellCheckingInspection")
public final class A08 {

    public static void main(final String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final String familyName = string(scanner, "Bitte geben Sie Ihren Nachnamen ein:");

            final char sortedBy = familyName.charAt(0);
            if (sortedBy >= 'a' && sortedBy <= 'j') {
                System.out.println("Herr Müller");
            } else if (sortedBy >= 'k' && sortedBy <= 'r') {
                System.out.println("Frau Wolf");
            } else if (sortedBy >= 's' && sortedBy <= 'z') {
                final int age = nonNegativeInteger(scanner, "Bitte geben Sie Ihr Alter ein:");
                final int birthYear = LocalDate.now().getYear() - age;
                if (birthYear >= 2000) {
                    System.out.println("Herr Kaya");
                } else {
                    System.out.println("Frau Jahn");
                }
            }
        }
    }

}
