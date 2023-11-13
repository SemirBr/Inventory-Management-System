package Classes;

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
                boolean availability = Boolean.parseBoolean(parts[4]);
                double calories = Double.parseDouble(parts[5]);

                GroceryItem groceryItem = new GroceryItem(id, quantity, name, price, availability, calories);
                groceryItemList.add(groceryItem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return groceryItemList;
    }

    public void saveGroceryItem(GroceryItem grocery) {
        try (FileWriter fileWriter = new FileWriter(database, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write(grocery.getId() + "," + grocery.getQuantity() + "," + grocery.getName()+ "," + grocery.getPrice()+ ","  + grocery.isAvailability() + "," + grocery.getCalories());
            bufferedWriter.newLine();

        } catch (IOException e) {
            e.printStackTrace();
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
                writer.write(grocery.getId() + "," + grocery.getQuantity() + "," + grocery.getName()+ "," + grocery.getPrice()+ "," + grocery.isAvailability() + "," + grocery.getCalories());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
