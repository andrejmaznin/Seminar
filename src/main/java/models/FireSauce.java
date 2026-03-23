package models;

public class FireSauce extends Addition {
    private final float price = 10;

    public FireSauce(IStew stew) {
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
        return stew.toString() + ", Огненный соус";
    }

}
