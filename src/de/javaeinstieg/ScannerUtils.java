package de.javaeinstieg;

import java.util.Scanner;

@SuppressWarnings("SpellCheckingInspection")
public final class ScannerUtils {

    private ScannerUtils() {
    }

    public static void optionalContinue(final Scanner scanner) {
        final boolean repeat = bool(scanner, "Möchtest du das Programm erneut benutzen?");
        if (!repeat) {
            scanner.close();
            System.exit(0);
        }
    }

    public static boolean bool(final Scanner scanner, final String prompt) {
        return getInput(scanner, prompt, input -> {
            if (input.equalsIgnoreCase("ja")) {
                return true;
            } else if (input.equalsIgnoreCase("nein")) {
                return false;
            }
            throw new IllegalArgumentException("Ungültige Eingabe. Bitte mit \"Ja\" oder \"Nein\" antworten.");
        }, input -> input, "Bitte mit Ja oder Nein antworten.");
    }

    public static String string(final Scanner scanner, final String prompt) {
        return getInput(scanner, prompt, input -> input, input -> !input.isEmpty(), "Eingabe darf nicht leer sein.");
    }

    public static char character(final Scanner scanner, final int index, final String prompt) {
        return getValidatedInput(scanner, prompt, string -> string.charAt(index), "Ungültige Eingabe. Bitte erneut eingeben.");
    }

    public static char letter(final Scanner scanner, final int index, final String prompt) {
        return getInput(scanner, prompt, string -> string.charAt(index), Character::isLetter, "Bitte nur Buchstaben verwenden.");
    }

    public static int integer(final Scanner scanner, final String prompt) {
        return getValidatedInput(scanner, prompt, Integer::parseInt, "Ungültige Zahl. Bitte erneut eingeben.");
    }

    public static int nonNegativeInteger(final Scanner scanner, final String prompt) {
        return getInput(scanner, prompt, Integer::parseInt, value -> value > 0, "Bitte eine Zahl größer als null eingeben.");
    }

    public static int rangedInteger(final Scanner scanner, final int min, final int max, final String prompt) {
        if (max <= min) {
            throw new IllegalStateException("Invalid range parameters. Expecting max > min");
        }
        return getInput(scanner, prompt, Integer::parseInt, value -> value >= min && value <= max, "Bitte eine Zahl zwischen " + min + " und " + max + " eingeben.");
    }

    public static double decimal(final Scanner scanner, final String prompt) {
        return getValidatedInput(scanner, prompt, Double::parseDouble, "Ungültige Dezimalzahl. Bitte erneut eingeben.");
    }

    public static double nonNegativeDecimal(final Scanner scanner, final String prompt) {
        return getInput(scanner, prompt, Double::parseDouble, value -> value > 0, "Bitte eine Dezimalzahl größer als null eingeben.");
    }

    public static double rangedDecimal(final Scanner scanner, final double min, final double max, final String prompt) {
        if (max <= min) {
            throw new IllegalStateException("Invalid range parameters. Expecting max > min");
        }
        return getInput(scanner, prompt, Double::parseDouble, value -> value >= min && value <= max, "Bitte eine Dezimalzahl zwischen " + min + " und " + max + " eingeben.");
    }

    private static <T> T getValidatedInput(final Scanner scanner, final String prompt, final Parser<T> parser, final String errorMessage) {
        while (true) {
            System.out.print(prompt + " ");
            String input = scanner.nextLine();
            try {
                return parser.parse(input);
            } catch (Exception e) {
                System.out.println(errorMessage);
            }
        }
    }

    public static <T> T getInput(final Scanner scanner, final String prompt, final Parser<T> parser, final Validator<T> validator, final String errorMessage) {
        while (true) {
            final T value = getValidatedInput(scanner, prompt, parser, errorMessage);
            if (validator.isValid(value)) {
                return value;
            }

            System.out.println(errorMessage);
        }
    }

    @FunctionalInterface
    public interface Parser<T> {

        T parse(final String input) throws NumberFormatException;

    }

    @FunctionalInterface
    public interface Validator<T> {

        boolean isValid(final T value);

    }

}