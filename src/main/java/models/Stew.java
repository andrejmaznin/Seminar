package models;

public class Stew implements IStew {
    private float price = 50;

    @Override
    public float checkout() {
        return this.price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Рагу";
    }

}
