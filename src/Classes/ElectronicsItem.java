package Classes;

public class ElectronicsItem extends InventoryItem {
    private double power;
    private String color;

    public ElectronicsItem(int id, int quantity, double power, String color) {
        super(id, quantity);
        this.power = power;
        this.color = color;
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
}
