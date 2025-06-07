package de.javaeinstieg;

import java.util.Locale;
import java.util.Scanner;

import static de.javaeinstieg.ScannerUtils.*;

@SuppressWarnings({"SpellCheckingInspection", "InfiniteLoopStatement"})
public final class A06 {

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        while (true) {
            final double weight = nonNegativeDecimal(scanner, "Bitte geben Sie Ihr Gewicht in kg ein:");
            final double height = decimal(scanner, "Bitte geben Sie Ihre Größe in cm ein:");
            final String gender = string(scanner, "Bitte geben Sie Ihr Biologisches Geschlecht ein (m/w/d):");

            final double bmi = calculateBMI(weight, height);
            System.out.println("Ihr BMI ist: " + Math.round(bmi * 100.0) / 100.0);
            System.out.println("Ihr BMI ist: " + getType(bmi, gender.toLowerCase(Locale.ROOT).equals("m")));
            optionalContinue(scanner);
        }
    }

    // https://de.wikipedia.org/wiki/Body-Mass-Index

    private static double calculateBMI(final double weight, final double height) {
        return weight / Math.pow(height / 100, 2);
    }

    public static String getType(final double bmi, final boolean male) {
        if (bmi < (male ? 20.0 : 18.5)) {
            return "Untergewicht";
        } else if (bmi < (male ? 26.0 : 25.0)) {
            return "Normalgewicht";
        } else if (bmi < (male ? 31.0 : 30.0)) {
            return "Übergewicht";
        } else {
            return "Starkes Übergewicht";
        }
    }

}
