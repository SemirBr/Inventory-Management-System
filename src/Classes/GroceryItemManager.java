package Classes;

import Validation.Validation;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class GroceryItemManager {
    static String database = "C:\\Users\\MyPc\\Downloads\\E-Commerce\\src\\GroceryItems.txt";

    public ArrayList<GroceryItem> listOfGroceryItems() {
        ArrayList<GroceryItem> groceryItemList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(database))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                int quantity = Integer.parseInt(parts[1]);
                String name= (parts[2]);
                double price=Double.parseDouble(parts[3]);
                String type= (parts[4]);
                double calories = Double.parseDouble(parts[5]);

                GroceryItem groceryItem = new GroceryItem(id, quantity, name, price, type, calories);
                groceryItemList.add(groceryItem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return groceryItemList;
    }

    public void saveGroceryItem() {
        GroceryItem groceryItem = validateGroceryItemData();
        ArrayList<GroceryItem> groceryItems = listOfGroceryItems();
        boolean idExists = false;

        for (GroceryItem item : groceryItems) {
            if (item.getId() == groceryItem.getId()) {
                System.err.println("ID already exists.");
                return;
            }
        }

        if (!idExists) {
            try (FileWriter fileWriter = new FileWriter(database, true);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                bufferedWriter.write(groceryItem.getId() + "," + groceryItem.getQuantity() + ","
                        + groceryItem.getName() + "," + groceryItem.getPrice() + ","
                        + groceryItem.getType() + "," + groceryItem.getCalories());
                bufferedWriter.newLine();

                System.out.println("You have inserted a new Grocery Item.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void removeGroceryItemById(int id) {
        ArrayList<GroceryItem> itemList = listOfGroceryItems();
        Iterator<GroceryItem> iterator = itemList.iterator();
        while (iterator.hasNext()) {
            GroceryItem grocery = iterator.next();
            if (grocery.getId() == id) {
                iterator.remove();
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(database))) {
            for (GroceryItem grocery : itemList) {
                writer.write(grocery.getId() + "," + grocery.getQuantity() + "," + grocery.getName() + "," + grocery.getPrice() + "," + grocery.getType() + "," + grocery.getCalories());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        private Validation validation= new Validation();

        private GroceryItem validateGroceryItemData() {
            System.out.println("Insert Id:");
            int Id = validation.validateNumber();
            System.out.println("Insert quantity:");
            int quantity = validation.validateNumber();
            System.out.println("Insert name:");
            String name = validation.validateString();
            System.out.println("Insert price:");
            double price = validation.validateDouble();
            System.out.println("Insert type:");
            String type = validation.validateString();
            System.out.println("Insert calories:");
            double calories = validation.validateDouble();

            return new GroceryItem(Id, quantity,name,price,type,calories);
        }
}

