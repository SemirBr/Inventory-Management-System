package Classes;

public class ElectronicsItem extends InventoryItem {
    private double power;
    private String color;

    public ElectronicsItem(int id, int quantity,String name,double price, double power, String color) {
        super(id, quantity,name,price);
        this.power = power;
        this.color = color;
    }
    public ElectronicsItem(){

    }
    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "ElectronicsItem{" +
                "id=" + super.getId()+
                ", quantity=" + super.getQuantity()+
                ", name=" + super.getName()+
                ", price=" + super.getPrice()+
                ", power=" + power +
                ", color='" + color + '\'' +
                '}';
    }
}
