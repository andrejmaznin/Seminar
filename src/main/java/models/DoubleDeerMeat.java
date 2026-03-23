package models;

public class DoubleDeerMeat extends Addition {
    private float price = 20;

    public DoubleDeerMeat(IStew stew) {
        super(stew);
    }

    public float getPrice() {
        return price;
    }

    @Override
    public float checkout() {
        return stew.checkout() + this.price;
    }

    public String toString() {
        return stew.toString() + ", Двойная порция оленины";
    }
}
