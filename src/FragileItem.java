public class FragileItem extends InventoryItem{
    public Double weightForFragileItems;
    public Double priceForFragileItems;

    public FragileItem(int id, Double quantity, Double weightForFragileItems, Double priceForFragileItems) {
        super(id, quantity);
        this.weightForFragileItems = weightForFragileItems;
        this.priceForFragileItems = priceForFragileItems;
    }

    public Double getWeightForFragileItems() {
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
}
