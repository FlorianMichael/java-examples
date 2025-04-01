package de.javaeinstieg;

import java.util.Scanner;

import static de.javaeinstieg.ScannerUtils.*;

@SuppressWarnings("SpellCheckingInspection")
public final class A02 {

    public static void main(final String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final double first = decimal(scanner, "Zahl eingeben:");
            final double second = decimal(scanner, "Zahl eingeben:");

            final double sum = first + second;
            final double diff = first - second;
            final double prod = first * second;
            final double quot = first / second;
            final double pow = Math.pow(first, second);
            final double mod = first % second;

            System.out.println("Summe: " + first + " + " + second + " = " + sum);
            System.out.println("Differenz: " + first + " - " + second + " = " + diff);
            System.out.println("Produkt: " + first + " * " + second + " = " + prod);
            System.out.println("Quotient: " + first + " : " + second + " = " + quot);
            System.out.println("Potenz: " + first + " ^ " + second + " = " + pow);
            System.out.println("Modulo: " + first + " % " + second + " = " + mod);
        }
    }

}
