package Classes;

public class GroceryItem extends InventoryItem {
     private boolean availability;
     private double calories;

     public GroceryItem(int id, int quantity, String name, double price, boolean availability, double calories) {
          super(id, quantity, name, price);
          this.availability = availability;
          this.calories = calories;
     }

     public GroceryItem(){

     }

     public boolean isAvailability() {
          return availability;
     }

     public void setAvailability(boolean availability) {
          this.availability = availability;
     }

     public Double getCalories() {
          return calories;
     }

     public void setCalories(Double calories) {
          this.calories = calories;
     }

     @Override
     public String toString() {
          return "GroceryItem{" +
                  "id=" + super.getId()+
                  ", quantity=" + super.getQuantity()+
                  ", name=" + super.getName()+
                  ", price=" + super.getPrice()+
                  ", availability=" + availability +
                  ", calories=" + calories +
                  '}';
     }
}
