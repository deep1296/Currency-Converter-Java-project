import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private Map<String, Double> exchangeRates;

    public CurrencyConverter() {
        // Initialize exchange rates with predefined values
        exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.73);
        exchangeRates.put("JPY", 110.63);
        exchangeRates.put("INR", 80.0);
    }

    public void convertCurrency() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCurrency Converter Menu:");
            System.out.println("1. Convert Currency");
            System.out.println("2. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter the source currency (e.g., USD): ");
                String sourceCurrency = scanner.next().toUpperCase();

                if (!exchangeRates.containsKey(sourceCurrency)) {
                    System.out.println("Invalid source currency!");
                    continue;
                }

                System.out.print("Enter the amount in " + sourceCurrency + ": ");
                double amount = scanner.nextDouble();

                System.out.print("Enter the target currency (e.g., EUR): ");
                String targetCurrency = scanner.next().toUpperCase();

                if (!exchangeRates.containsKey(targetCurrency)) {
                    System.out.println("Invalid target currency!");
                    continue;
                }

                double sourceRate = exchangeRates.get(sourceCurrency);
                double targetRate = exchangeRates.get(targetCurrency);
                double convertedAmount = amount * (targetRate / sourceRate);

                System.out.println(amount + " " + sourceCurrency + " is equivalent to " + convertedAmount + " " + targetCurrency);
            } else if (choice == 2) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        converter.convertCurrency();
    }
}
