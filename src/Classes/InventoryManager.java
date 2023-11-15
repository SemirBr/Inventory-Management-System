package Classes;

import Validation.Validation;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class InventoryManager {

    static String database = "C:\\Users\\MyPc\\Downloads\\E-Commerce\\src\\database.txt";

    public ArrayList<InventoryItem> listItems() {
        ArrayList<InventoryItem> itemList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(database))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                int quantity = Integer.parseInt(parts[1]);
                String name= (parts[2]);
                double price=Double.parseDouble(parts[3]);
                InventoryItem inventoryItem = new InventoryItem(id, quantity, name, price);
                itemList.add(inventoryItem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return itemList;
    }

    public void saveInventory() {
        InventoryItem inventoryItem = validateInventoryItemData();
        ArrayList<InventoryItem> inventoryItems = listItems();
        boolean idExists = false;

        for (InventoryItem item : inventoryItems) {
            if (item.getId() == inventoryItem.getId()) {
                System.err.println("ID already exists.");
                return;
            }
        }

        if (!idExists) {
            try (FileWriter fileWriter = new FileWriter(database, true);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                bufferedWriter.write(inventoryItem.getId() + "," + inventoryItem.getQuantity() + ","
                        + inventoryItem.getName() + "," + inventoryItem.getPrice());
                bufferedWriter.newLine();

                System.out.println("You have inserted a new Inventory Item.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeById(int id){
        ArrayList<InventoryItem> itemList = listItems();
        Iterator<InventoryItem> iterator = itemList.iterator();
        while (iterator.hasNext()) {
            InventoryItem item = iterator.next();
            if (item.getId() == id) {
                iterator.remove();
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(database))) {
            for (InventoryItem item : itemList) {
                writer.write(item.getId() + "," + item.getQuantity());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private Validation validation= new Validation();
    private InventoryItem validateInventoryItemData() {
        System.out.println("Insert Id:");
        int Id = validation.validateNumber();
        System.out.println("Insert quantity:");
        int quantity = validation.validateNumber();
        System.out.println("Insert name:");
        String name = validation.validateString();
        System.out.println("Insert price:");
        double price = validation.validateDouble();


        return new InventoryItem(Id, quantity,name,price);
    }
}

