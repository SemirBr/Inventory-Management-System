package Classes;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class FragileItemManager {
    static String database = "C:\\Users\\MyPc\\Downloads\\E-Commerce\\src\\FragileItems.txt";

    public ArrayList<FragileItem> listOfFragileItems() {
        ArrayList<FragileItem> fragileItemList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(database))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                int quantity = Integer.parseInt(parts[1]);
                double weightForFragileItems = Double.parseDouble(parts[2]);
                double priceForFragileItems = Double.parseDouble(parts[2]);

                FragileItem fragileItem = new FragileItem(id, quantity, weightForFragileItems, priceForFragileItems);
                fragileItemList.add(fragileItem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fragileItemList;
    }

    public void saveFragileItem(FragileItem fragileItem) {
        try (FileWriter fileWriter = new FileWriter(database, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write(fragileItem.getId() + "," + fragileItem.getQuantity() + "," + fragileItem.getWeightForFragileItems() + "," + fragileItem.getPriceForFragileItems());
            bufferedWriter.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeFragileItemById(int id) {
        ArrayList<FragileItem> itemList = listOfFragileItems();
        Iterator<FragileItem> iterator = itemList.iterator();
        while (iterator.hasNext()) {
            FragileItem fragileItem = iterator.next();
            if (fragileItem.getId() == id) {
                iterator.remove();
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(database))) {
            for (FragileItem fragileItem : itemList) {
                writer.write(fragileItem.getId() + "," + fragileItem.getQuantity() + "," + fragileItem.getWeightForFragileItems() + "," + fragileItem.getPriceForFragileItems());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
