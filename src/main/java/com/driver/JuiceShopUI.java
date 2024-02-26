package com.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JuiceShopUI {
    private static List<JuiceDTO> juiceList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addJuice(scanner);
                    break;
                case 2:
                    displaySummary();
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Add Juice");
        System.out.println("2. Display Summary");
        System.out.println("3. Exit");
    }

    private static void addJuice(Scanner scanner) {
        System.out.println("Enter Juice Name:");
        scanner.nextLine(); // Consume the newline character
        String name = scanner.nextLine();

        System.out.println("Enter Ingredients (comma-separated):");
        String ingredientsInput = scanner.nextLine();
        List<String> ingredients = List.of(ingredientsInput.split(","));

        System.out.println("Enter Juice Price:");
        double price = scanner.nextDouble();

        JuiceDTO juiceDTO = new JuiceDTO(name, ingredients, price);
        juiceList.add(juiceDTO);

        System.out.println("Juice added successfully!");
    }

    private static void displaySummary() {
        System.out.println("Juice Summary:");

        if (juiceList.isEmpty()) {
            System.out.println("No juices added yet.");
        } else {
            for (JuiceDTO juice : juiceList) {
                System.out.println("Name: " + juice.getName());
                System.out.println("Ingredients: " + juice.getIngredients());
                System.out.println("Price: $" + juice.getPrice());
                System.out.println("------------------------");
            }
        }
    }
}
