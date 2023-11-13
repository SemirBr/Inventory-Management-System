package Classes;

public class FragileItem extends InventoryItem {
    private double weightForFragileItems;
    private double heightForFragileItems;

    public FragileItem(int id, int quantity, String name, double price, double weightForFragileItems, double heightForFragileItems) {
        super(id, quantity, name, price);
        this.weightForFragileItems = weightForFragileItems;
        this.heightForFragileItems = heightForFragileItems;
    }

    public FragileItem(){

    }


    public double getWeightForFragileItems() {
        return weightForFragileItems;
    }

    public void setWeightForFragileItems(Double weightForFragileItems) {
        this.weightForFragileItems = weightForFragileItems;
    }

    public Double getHeightForFragileItems() {
        return heightForFragileItems;
    }

    public void setHeightForFragileItems(Double heightForFragileItems) {
        this.heightForFragileItems = heightForFragileItems;
    }

    @Override
    public String toString() {
        return "FragileItem{" +
                "id=" + super.getId()+
                ", quantity=" + super.getQuantity()+
                ", name=" + super.getName()+
                ", price=" + super.getPrice()+
                ", weightForFragileItems=" + weightForFragileItems +
                ", priceForFragileItems=" + heightForFragileItems +
                '}';
    }
}
