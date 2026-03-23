package models;

public class SnowBerries extends Addition {
    private final float price = 5;


    public SnowBerries(IStew stew) {
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
        return stew.toString() + ", Снежные ягоды";
    }
}
