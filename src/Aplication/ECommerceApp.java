package Aplication;

import Classes.*;

import java.util.Scanner;

public class ECommerceApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            InventoryManager inventoryManager = new InventoryManager();
            ElectronicsItemManager electronicsItemManager = new ElectronicsItemManager();
            FragileItemManager fragileItemManager= new FragileItemManager();
            GroceryItemManager groceryItemManager= new GroceryItemManager();
            PaymentProcessor paymentProcessor = new PaymentProcessor();
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
                            InventoryItem inventoryItem = new InventoryItem();
                            System.out.println("Insert ID:");
                            inventoryItem.setId(Integer.parseInt(scanner.nextLine()));
                            System.out.println("Insert quantity:");
                            inventoryItem.setQuantity(Integer.parseInt(scanner.nextLine()));
                            System.out.println("Insert name:");
                            inventoryItem.setName(scanner.nextLine());
                            System.out.println("Insert price:");
                            inventoryItem.setPrice(Double.parseDouble(scanner.nextLine()));
                            inventoryManager.saveInventory(inventoryItem);
                            System.out.println("You have inserted new General Item");
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
                            System.out.println("Invalid command. Please try again.");
                    }
                } else if (category.equals("Electronic Items")) {
                    System.out.print("Enter command (1-4): ");
                    int choice2 = Integer.parseInt(scanner.nextLine());
                    switch (choice2) {
                        case 1:
                            System.out.println(electronicsItemManager.listOfElectronicsItems());
                            break;
                        case 2:
                            ElectronicsItem electronicsItem = new ElectronicsItem();
                            System.out.println("Insert ID:");
                            electronicsItem.setId(Integer.parseInt(scanner.nextLine()));
                            System.out.println("Insert quantity:");
                            electronicsItem.setQuantity(Integer.parseInt(scanner.nextLine()));
                            System.out.println("Insert name:");
                            electronicsItem.setName(scanner.nextLine());
                            System.out.println("Insert price:");
                            electronicsItem.setPrice(Double.parseDouble(scanner.nextLine()));
                            System.out.println("Insert power:");
                            electronicsItem.setPower(Double.parseDouble(scanner.nextLine()));
                            System.out.println("Insert color:");
                            electronicsItem.setColor(scanner.nextLine());
                            electronicsItemManager.saveElectronicsItem(electronicsItem);
                            System.out.println("You have inserted new General Item");
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
                            System.out.println("Invalid command. Please try again.");
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
                            FragileItem fragileItem = new FragileItem();
                            System.out.println("Insert ID:");
                            fragileItem.setId(Integer.parseInt(scanner.nextLine()));
                            System.out.println("Insert quantity:");
                            fragileItem.setQuantity(Integer.parseInt(scanner.nextLine()));
                            System.out.println("Insert name:");
                            fragileItem.setName(scanner.nextLine());
                            System.out.println("Insert price:");
                            fragileItem.setPrice(Double.parseDouble(scanner.nextLine()));
                            System.out.println("Insert weight for Fragile Item:");
                            fragileItem.setWeightForFragileItems(Double.parseDouble(scanner.nextLine()));
                            System.out.println("Insert height for Fragile Item:");
                            fragileItem.setHeightForFragileItems(Double.parseDouble(scanner.nextLine()));
                            fragileItemManager.saveFragileItem(fragileItem);
                            System.out.println("You have inserted new Fragile Item");
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
                            GroceryItem groceryItem = new GroceryItem();
                            System.out.println("Insert ID:");
                            groceryItem.setId(Integer.parseInt(scanner.nextLine()));
                            System.out.println("Insert quantity:");
                            groceryItem.setQuantity(Integer.parseInt(scanner.nextLine()));
                            System.out.println("Insert name:");
                            groceryItem.setName(scanner.nextLine());
                            System.out.println("Insert price:");
                            groceryItem.setPrice(Double.parseDouble(scanner.nextLine()));
                            System.out.println("Is it available? (true/false):");
                            groceryItem.setAvailability(Boolean.parseBoolean(scanner.nextLine()));
                            System.out.println("Insert calories:");
                            groceryItem.setCalories(Double.parseDouble(scanner.nextLine()));
                            groceryItemManager.saveGroceryItem(groceryItem);
                            System.out.println("You have inserted new Grocery Item");
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
                    System.out.println("Invalid category. Please try again.");
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
