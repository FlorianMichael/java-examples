package de.javaeinstieg;

import java.util.Scanner;

@SuppressWarnings("SpellCheckingInspection")
public final class ScannerUtils {

    private ScannerUtils() {
    }

    public static String string(final Scanner scanner, final String prompt) {
        return getInput(scanner, prompt, input -> input, input -> !input.isEmpty(), "Eingabe darf nicht leer sein.");
    }

    public static int integer(final Scanner scanner, final String prompt) {
        return getValidatedInput(scanner, prompt, Integer::parseInt, "Ungültige Zahl. Bitte erneut eingeben.");
    }

    public static int nonNegativeInteger(final Scanner scanner, final String prompt) {
        return getInput(scanner, prompt, Integer::parseInt, value -> value > 0, "Bitte eine Zahl größer als null eingeben.");
    }

    public static double decimal(final Scanner scanner, final String prompt) {
        return getValidatedInput(scanner, prompt, Double::parseDouble, "Ungültige Dezimalzahl. Bitte erneut eingeben.");
    }

    public static double nonNegativeDecimal(final Scanner scanner, final String prompt) {
        return getInput(scanner, prompt, Double::parseDouble, value -> value > 0, "Bitte eine Dezimalzahl größer als null eingeben.");
    }

    private static <T> T getValidatedInput(final Scanner scanner, final String prompt, final Parser<T> parser, final String errorMessage) {
        while (true) {
            System.out.print(prompt + " ");
            final String input = scanner.nextLine();
            try {
                return parser.parse(input);
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
            }
        }
    }

    private static <T> T getInput(final Scanner scanner, final String prompt, final Parser<T> parser, final Validator<T> validator, final String errorMessage) {
        while (true) {
            final T value = getValidatedInput(scanner, prompt, parser, errorMessage);
            if (validator.isValid(value)) {
                return value;
            }

            System.out.println(errorMessage);
        }
    }

    @FunctionalInterface
    private interface Parser<T> {

        T parse(final String input) throws NumberFormatException;

    }

    @FunctionalInterface
    private interface Validator<T> {

        boolean isValid(final T value);

    }

}