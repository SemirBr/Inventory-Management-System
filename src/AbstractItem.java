public abstract class AbstractItem implements Item,
        Categorizable, Breakable, Perishable, Sellable{
    @Override
    public boolean isBreakable() {
        return false;
    }

    @Override
    public void handleBreakage() {

    }

    @Override
    public void setCategory(String category) {

    }

    @Override
    public String getCategory() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getWeight() {
        return 0;
    }

    @Override
    public double getValue() {
        return 0;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public boolean isPerishable() {
        return false;
    }

    @Override
    public void handleExpiration() {

    }

    @Override
    public void setPrice(double price) {

    }

    @Override
    public double getPrice() {
        return 0;
    }
}
