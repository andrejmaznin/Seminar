package models;

public class Stew implements IStew {
    private float price = 50;

    public float checkout() {
        return this.price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String toString() {
        return "Рагу";
    }

}
