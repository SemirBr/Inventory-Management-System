package Aplication;

import Classes.InventoryItem;
import Classes.InventoryManager;

import java.util.Scanner;
public class ECommerceApp {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            InventoryManager inventoryManager = new InventoryManager();

            System.out.println("Welcome to the E-commerce Console Application");
            displayMenu();

            boolean isRunning = true;
            while (isRunning) {
                System.out.print("Enter Category ");
                Scanner category = new Scanner(System.in);
                if(category.equals("Inventory Manager")) {
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
                            break;
                        case 3:
                            System.out.println("Enter the ID of the item you want to remove:");
                            int idToRemove = Integer.parseInt(scanner.nextLine());
                            inventoryManager.removeById(idToRemove);
                            System.out.println("You has removed Id");
                            break;
                        case 4:
                            isRunning = false;
                            break;
                        default:
                            System.out.println("Invalid command. Please try again.");
                    }
                }
                    else if(category.equals("Electronic Item")) {
                        System.out.print("Enter command (1-4): ");
                        int choice2 = Integer.parseInt(scanner.nextLine());
                        switch (choice2) {
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
                                break;
                            case 3:
                                System.out.println("Enter the ID of the item you want to remove:");
                                int idToRemove = Integer.parseInt(scanner.nextLine());
                                inventoryManager.removeById(idToRemove);
                                System.out.println("You has removed Id");
                                break;
                            case 4:
                                isRunning = false;
                                break;
                            default:
                                System.out.println("Invalid command. Please try again.");
                        }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void displayMenu() {
        System.out.println("Menu");
        System.out.println("1. List Items");
        // Add more menu options if needed
    }
}