package de.javaeinstieg;

import java.util.Scanner;

import static de.javaeinstieg.ScannerUtils.*;

@SuppressWarnings("SpellCheckingInspection")
public final class A01 {

    public static void main(final String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final String name = string(scanner, "Bitte geben Sie Ihren Vornamen ein:");
            final String familyName = string(scanner, "Bitte geben Sie Ihren Nachnamen ein:");
            final String street = string(scanner, "Bitte geben Sie Ihre Straße ein:");
            final String houseNumber = string(scanner, "Bitte geben Sie Ihre Hausnummer ein:");
            final String city = string(scanner, "Bitte geben Sie Ihren Wohnort ein:");
            final int postalCode = integer(scanner, "Bitte geben Sie Ihre Postleitzahl ein:");

            System.out.println("Ihre Adresse ist:");
            System.out.println(name + " " + familyName);
            System.out.println(street + " " + houseNumber);
            System.out.println(postalCode + " " + city);
        }
    }


}
