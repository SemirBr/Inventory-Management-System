package Aplication;

import Classes.ElectronicsItem;
import Classes.ElectronicsItemManager;
import Classes.InventoryItem;
import Classes.InventoryManager;

import java.util.Scanner;

public class ECommerceApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            InventoryManager inventoryManager = new InventoryManager();
            ElectronicsItemManager electronicsItemManager = new ElectronicsItemManager();
            System.out.println("Welcome to the E-commerce Console Application");
            displayMenu();
            boolean isRunning = true;
            while (isRunning) {
                System.out.print("Enter Category: ");
                String category = scanner.nextLine();

                if (category.equals("Inventory Item")) {
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
                } else if (category.equals("Electronic Item")) {
                    System.out.print("Enter command (1-4): ");
                    int choice2 = Integer.parseInt(scanner.nextLine());
                    switch (choice2) {
                        case 1:
                            System.out.println(electronicsItemManager.listOfElectronicsItems());
                            break;
                        case 2:
                            ElectronicsItem electronicsItem = new ElectronicsItem(0,0,0,null);
                            System.out.println("Insert ID:");
                            electronicsItem.setId(Integer.parseInt(scanner.nextLine()));
                            System.out.println("Insert quantity:");
                            electronicsItem.setQuantity(Integer.parseInt(scanner.nextLine()));
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
                } else {
                    System.out.println("Invalid category. Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Add more menu options if needed
    private static void displayMenu() {
        System.out.println("Menu");
        System.out.println("1. List Items");
        System.out.println("2. Add Item");
        System.out.println("3. Remove Item");
        System.out.println("4. Quit");
    }
}
