package Classes;

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

    public void saveInventory(InventoryItem inventory) {
        try (FileWriter fileWriter = new FileWriter(database, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write(inventory.getId() + "," + inventory.getQuantity()+ "," + inventory.getName()+ "," + inventory.getPrice());
            bufferedWriter.newLine();

        } catch (IOException e) {
            e.printStackTrace();
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
}

