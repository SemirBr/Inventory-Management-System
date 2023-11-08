public class GroceryItem extends InventoryItem{
     public boolean availability;
     public Double calories;

     public GroceryItem(int id, Double quantity, boolean availability, Double calories) {
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
}
