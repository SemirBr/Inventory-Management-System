package Classes;

public class InventoryItem extends AbstractItem {
    private int id;
    private int quantity;

    public InventoryItem(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public InventoryItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "InventoryItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
