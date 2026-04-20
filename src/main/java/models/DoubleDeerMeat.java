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
        return super.checkout() + this.price;
    }

    @Override
    public String toString() {
        return super.toString () + ", Двойная порция оленины";
    }
}
