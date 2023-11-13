package Classes;

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

    public void saveElectronicsItem(ElectronicsItem electronics) {
        try (FileWriter fileWriter = new FileWriter(database, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write(electronics.getId() + "," + electronics.getQuantity() + "," +electronics.getName()+ "," + electronics.getPrice()+ "," + electronics.getPower() + "," + electronics.getColor());
            bufferedWriter.newLine();

        } catch (IOException e) {
            e.printStackTrace();
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
}

