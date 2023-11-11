package Classes;

public class GroceryItem extends InventoryItem {
     private boolean availability;
     private double calories;

     public GroceryItem(int id, int quantity, boolean availability, double calories) {
          super(id, quantity);
          this.availability = availability;
          this.calories = calories;
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
                  ", availability=" + availability +
                  ", calories=" + calories +
                  '}';
     }
}
