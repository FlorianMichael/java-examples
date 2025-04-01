package de.javaeinstieg;

import java.util.Scanner;

import static de.javaeinstieg.ScannerUtils.*;

@SuppressWarnings("SpellCheckingInspection")
public final class A05 {

    public static void main(final String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final int people = nonNegativeInteger(scanner, "Guten Abend. Wir haben nur noch 5 Restplätze. Wie viele Personen seid ihr?");
            if (people > 5) {
                System.out.println("Ihr seid " + (people - 5) + " zu viele. Ihr könnt den Film nicht schauen.");
            } else if (people == 5) {
                System.out.println("Ihr könnt den Film schauen. Das Kino ist nun ausgebucht.");
            } else /*if (people < 5)*/ {
                System.out.println("Ihr könnt den Film schauen. Es sind noch " + (5 - people) + " Plätze frei.");
            }
        }
    }

}
