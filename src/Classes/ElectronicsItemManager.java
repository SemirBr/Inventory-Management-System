package Classes;

import Validation.Validation;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ElectronicsItemManager {
    static String database = "C:\\Users\\MyPc\\Downloads\\E-Commerce\\src\\Electronics.txt";

    public ArrayList<ElectronicsItem> listOfElectronicsItems() {
        ArrayList<ElectronicsItem> electronicsItemList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(database))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                int quantity = Integer.parseInt(parts[1]);
                String name= (parts[2]);
                double price=Double.parseDouble(parts[3]);
                double power = Double.parseDouble(parts[4]);
                String color = (parts[5]);

                ElectronicsItem electronicsItem = new ElectronicsItem(id,quantity,name,price,power,color);
                electronicsItemList.add(electronicsItem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return electronicsItemList;
    }

    public void saveElectronicsItem() {
        ElectronicsItem validatedElectronicsItem = validateElectronicsItemData();
        ArrayList<ElectronicsItem> electronicsItems = listOfElectronicsItems();
        boolean idExists = false;

        for (ElectronicsItem item : electronicsItems) {
            if (item.getId() == validatedElectronicsItem.getId()) {
                System.err.println("ID already exists.");
                return;
            }
        }

        if (!idExists) {
            try (FileWriter fileWriter = new FileWriter(database, true);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                bufferedWriter.write(validatedElectronicsItem.getId() + "," + validatedElectronicsItem.getQuantity() + ","
                        + validatedElectronicsItem.getName() + "," + validatedElectronicsItem.getPrice() + ","
                        + validatedElectronicsItem.getPower() + "," + validatedElectronicsItem.getColor());
                bufferedWriter.newLine();

                System.out.println("You have inserted a new Electronics Item.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void removeElectronicItemById(int id) {
        ArrayList<ElectronicsItem> itemList = listOfElectronicsItems();
        Iterator<ElectronicsItem> iterator = itemList.iterator();
        while (iterator.hasNext()) {
            ElectronicsItem electronics = iterator.next();
            if (electronics.getId() == id) {
                iterator.remove();
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(database))) {
            for (ElectronicsItem electronics : itemList) {
                writer.write(electronics.getId() + "," + electronics.getQuantity() + electronics.getName()+ "," + electronics.getPrice()+ "," + electronics.getPower() + "," + electronics.getColor());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private Validation validation= new Validation();
    private ElectronicsItem validateElectronicsItemData() {
        System.out.println("Insert Id:");
        int Id = validation.validateNumber();
        System.out.println("Insert quantity:");
        int quantity = validation.validateNumber();
        System.out.println("Insert name:");
        String name = validation.validateString();
        System.out.println("Insert price:");
        double price = validation.validateDouble();
        System.out.println("Insert power:");
        double power = validation.validateDouble();
        System.out.println("Insert color:");
        String color = validation.validateString();


        return new ElectronicsItem(Id, quantity,name,price,power,color);
    }
}

