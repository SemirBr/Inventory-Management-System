package Classes;

public class GroceryItem extends InventoryItem {
     private String type;
     private double calories;

     public GroceryItem(int id, int quantity, String name, double price, String type, double calories) {
          super(id, quantity, name, price);
          this.type = type;
          this.calories = calories;
     }

     public GroceryItem(){

     }

     public String getType() {
          return type;
     }

     public void setType(String type) {
          this.type = type;
     }

     public double getCalories() {
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
                  ", type=" + type +
                  ", calories=" + calories +
                  '}';
     }
}
