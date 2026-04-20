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
        return super.checkout() + this.price;
    }

    public String toString() {
        return super.toString() + ", Снежные ягоды";
    }
}
