package Classes;

public class FragileItem extends InventoryItem {
    private double weightForFragileItems;
    private double priceForFragileItems;

    public FragileItem(int id, int quantity, double weightForFragileItems, double priceForFragileItems) {
        super(id, quantity);
        this.weightForFragileItems = weightForFragileItems;
        this.priceForFragileItems = priceForFragileItems;
    }

    public double getWeightForFragileItems() {
        return weightForFragileItems;
    }

    public void setWeightForFragileItems(Double weightForFragileItems) {
        this.weightForFragileItems = weightForFragileItems;
    }

    public Double getPriceForFragileItems() {
        return priceForFragileItems;
    }

    public void setPriceForFragileItems(Double priceForFragileItems) {
        this.priceForFragileItems = priceForFragileItems;
    }

    @Override
    public String toString() {
        return "FragileItem{" +
                "id=" + super.getId()+
                ", quantity=" + super.getQuantity()+
                ", weightForFragileItems=" + weightForFragileItems +
                ", priceForFragileItems=" + priceForFragileItems +
                '}';
    }
}
