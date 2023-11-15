package Aplication;

import Classes.*;

import java.util.Scanner;

public class ECommerceApp {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            InventoryManager inventoryManager = new InventoryManager();
            ElectronicsItemManager electronicsItemManager = new ElectronicsItemManager();
            FragileItemManager fragileItemManager= new FragileItemManager();
            GroceryItemManager groceryItemManager= new GroceryItemManager();
//            PaymentProcessor paymentProcessor = new PaymentProcessor();
            System.out.println("Welcome to the E-commerce Console Application");
            displayMenu();
            boolean isRunning = true;
            while (isRunning) {
                System.out.print("Enter Category: ");
                String category = scanner.nextLine();
//                System.out.print("Enter User: ");
//                String user = scanner.nextLine();

                if (category.equals("Inventory Items")) {
                    System.out.print("Enter command (1-4): ");
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            System.out.println(inventoryManager.listItems());
                            break;
                        case 2:
                            inventoryManager.saveInventory();
                            break;
                        case 3:
                            System.out.println("Enter the ID of the item you want to remove:");
                            int idToRemove = Integer.parseInt(scanner.nextLine());
                            inventoryManager.removeById(idToRemove);
                            System.out.println("You have removed ID " + idToRemove);
                            break;
                        case 4:
                            isRunning = false;
                            break;
                        default:
                            System.err.println("Invalid command. Please try again.");
                    }

                } else if (category.equals("Electronic Items")) {
                    System.out.print("Enter command (1-4): ");
                    int choice2 = Integer.parseInt(scanner.nextLine());
                    switch (choice2) {
                        case 1:
                            System.out.println(electronicsItemManager.listOfElectronicsItems());
                            break;
                        case 2:
                            electronicsItemManager.saveElectronicsItem();
                            break;
                        case 3:
                            System.out.println("Enter the ID of the item you want to remove:");
                            int idToRemove = Integer.parseInt(scanner.nextLine());
                            electronicsItemManager.removeElectronicItemById(idToRemove);
                            System.out.println("You have removed ID " + idToRemove);
                            break;
                        case 4:
                            isRunning = false;
                            break;
                        default:
                            System.err.println("Invalid command. Please try again.");
                    }
                }

                else if (category.equals("Fragile Items")) {
                    System.out.print("Enter command (1-4): ");
                    int choice3 = Integer.parseInt(scanner.nextLine());
                    switch (choice3) {
                        case 1:
                            System.out.println(fragileItemManager.listOfFragileItems());
                            break;
                        case 2:
                            fragileItemManager.saveFragileItem();
                            break;
                        case 3:
                            System.out.println("Enter the ID of the item you want to remove:");
                            int idToRemove = Integer.parseInt(scanner.nextLine());
                            fragileItemManager.removeFragileItemById(idToRemove);
                            System.out.println("You have removed ID " + idToRemove);
                            break;
                        case 4:
                            isRunning = false;
                            break;
                        default:
                            System.out.println("Invalid command. Please try again.");
                    }
                }

                else if (category.equals("Grocery Items")) {
                    System.out.print("Enter command (1-4): ");
                    int choice4 = Integer.parseInt(scanner.nextLine());
                    switch (choice4) {
                        case 1:
                            System.out.println(groceryItemManager.listOfGroceryItems());
                            break;
                        case 2:
                            groceryItemManager.saveGroceryItem();
                            break;
                        case 3:
                            System.out.println("Enter the ID of the item you want to remove:");
                            int idToRemove = Integer.parseInt(scanner.nextLine());
                            groceryItemManager.removeGroceryItemById(idToRemove);
                            System.out.println("You have removed ID " + idToRemove);
                            break;
                        case 4:
                            isRunning = false;
                            break;
                        default:
                            System.out.println("Invalid command. Please try again.");
                    }
                }

                else {
                    System.err.println("Invalid category. Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void displayMenu() {
        System.out.println("Menu: ");
        System.out.printf("1. List Items ");
        System.out.printf("2. Add Item ");
        System.out.printf("3. Remove Item ");
        System.out.println("4. Quit ");
        System.out.println("Categories: ");
        System.out.printf("1. Inventory Items ");
        System.out.printf("2. Electronic Items ");
        System.out.printf("3. Fragile Items ");
        System.out.println("4. Grocery Items ");
    }
}
