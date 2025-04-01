package de.javaeinstieg;

import java.util.Scanner;

import static de.javaeinstieg.ScannerUtils.*;

@SuppressWarnings("SpellCheckingInspection")
public final class A03_4 {

    public static void main(final String[] args) {
        System.out.println("Kinder: 2,50 Euro");
        System.out.println("Jugendliche: 4,00 Euro");
        System.out.println("Erwachsene: 6,50 Euro");
        System.out.println("Rabatt pro Gutschein: 1,50 Euro");

        try (final Scanner scanner = new Scanner(System.in)) {
            final int children = nonNegativeInteger(scanner, "Anzahl Kinder:");
            final int teenagers = nonNegativeInteger(scanner, "Anzahl Jugendliche:");
            final int adults = nonNegativeInteger(scanner, "Anzahl Erwachsene:");
            final int giftCards = nonNegativeInteger(scanner, "Anzahl Gutscheine:");

            final int totalPeople = children + teenagers + adults;
            final double totalPrice = (children * 2.5) + (teenagers * 4.0) + (adults * 6.5);
            final double giftCardsValue = giftCards * 1.5;

            if (totalPrice <= 0) {
                System.out.printf("Ihr seid insgesamt %d Personen, der Eintritt ist kostenlos!%n", totalPeople);
                if (giftCards > 0) {
                    System.out.printf("Die %d Gutschein(e) könnt ihr behalten!%n", giftCards);
                }
                return;
            }

            if (giftCardsValue >= totalPrice) {
                final int usedGiftCards = (int) Math.round(totalPrice / 1.5);
                final int remainingGiftCards = giftCards - usedGiftCards;
                System.out.printf("Ihr seid insgesamt %d Personen, der Gesamtpreis beträgt %d Gutscheine. Die restlichen %d könnt ihr behalten.%n", totalPeople, usedGiftCards, remainingGiftCards);
            } else {
                final double averagePrice = totalPrice / totalPeople;
                System.out.printf("Ihr seid insgesamt %d Personen, der Gesamtpreis beträgt %.2f Euro. Das sind pro Person durchschnittlich %.2f Euro.%n", totalPeople, totalPrice, averagePrice);
            }
        }
    }

}
