import java.util.Scanner;
public class ECommerceApp {
    public static void main(String[] args) {
//        InventoryManager inventoryManager = new InventoryManager();
//        PaymentProcessor paymentProcessor = new PaymentProcessor();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the E-commerce Console Application");
        displayMenu();
        boolean isRunning = true;
        while (isRunning) {
            System.out.print("Enter command (1-4): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
//                    inventoryManager.listItems();
                    break;
                case 2:
// ...
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("Menu");
        System.out.println("1. List Items");
// ......
    }
}