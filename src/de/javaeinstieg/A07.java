package de.javaeinstieg;

import java.util.Scanner;

import static de.javaeinstieg.ScannerUtils.*;

@SuppressWarnings("SpellCheckingInspection")
public final class A07 {

    public static void main(final String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final int year = nonNegativeInteger(scanner, "Geben sie ein Jahr ein:");

            final boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            if (isLeapYear) {
                System.out.println(year + " ist ein Schaltjahr.");
            } else {
                System.out.println(year + " ist kein Schaltjahr.");
            }
        }
    }

}
