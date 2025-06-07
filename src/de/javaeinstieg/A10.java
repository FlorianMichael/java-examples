package de.javaeinstieg;

import java.util.Scanner;

import static de.javaeinstieg.ScannerUtils.string;

@SuppressWarnings("SpellCheckingInspection")
public final class A10 {

    public static void main(final String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final String name = string(scanner, "Bitte gebe deinen Namen ein:");
            for (int i = 0; i < 100; i++) {
                System.out.println(name);
            }
        }
    }

}
