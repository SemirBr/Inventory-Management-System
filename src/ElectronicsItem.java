public class ElectronicsItem extends InventoryItem{
    public Double power;
    public String color;

    public ElectronicsItem(int id, Double quantity, Double power, String color) {
        super(id, quantity);
        this.power = power;
        this.color = color;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
