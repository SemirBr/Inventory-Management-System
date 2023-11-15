package Classes;

import Validation.Validation;

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
                String name= (parts[2]);
                double price=Double.parseDouble(parts[3]);
                double weightForFragileItems = Double.parseDouble(parts[4]);
                double heightForFragileItems = Double.parseDouble(parts[5]);

                FragileItem fragileItem = new FragileItem(id, quantity, name, price, weightForFragileItems, heightForFragileItems);
                fragileItemList.add(fragileItem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fragileItemList;
    }

    public void saveFragileItem() {
        FragileItem validatedFragileItem = validateFragileItemData();
        ArrayList<FragileItem> fragileItems = listOfFragileItems();
        boolean idExists = false;

        for (FragileItem item : fragileItems) {
            if (item.getId() == validatedFragileItem.getId()) {
                System.err.println("ID already exists.");
                return;
            }
        }

        if (!idExists) {
            try (FileWriter fileWriter = new FileWriter(database, true);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                bufferedWriter.write(validatedFragileItem.getId() + "," + validatedFragileItem.getQuantity() + ","
                        + validatedFragileItem.getName() + "," + validatedFragileItem.getPrice() + ","
                        + validatedFragileItem.getWeightForFragileItems() + ","
                        + validatedFragileItem.getHeightForFragileItems());
                bufferedWriter.newLine();

                System.out.println("You have inserted a new Fragile Item.");
            } catch (IOException e) {
                e.printStackTrace();
            }
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
                writer.write(fragileItem.getId() + "," + fragileItem.getQuantity() + fragileItem.getName()+ "," + fragileItem.getPrice()+ "," + fragileItem.getWeightForFragileItems() + "," + fragileItem.getHeightForFragileItems());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private Validation validation= new Validation();
    private FragileItem validateFragileItemData() {
        System.out.println("Insert Id:");
        int Id = validation.validateNumber();
        System.out.println("Insert quantity:");
        int quantity = validation.validateNumber();
        System.out.println("Insert name:");
        String name = validation.validateString();
        System.out.println("Insert price:");
        double price = validation.validateDouble();
        System.out.println("Insert weightForFragileItem:");
        double weightForFragileItems = validation.validateDouble();
        System.out.println("Insert heightForFragileItem:");
        double heightForFragileItems = validation.validateDouble();


        return new FragileItem(Id, quantity,name,price,weightForFragileItems,heightForFragileItems);
    }
}
