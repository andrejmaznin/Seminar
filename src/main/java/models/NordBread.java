package models;

public class NordBread extends Addition {
    private final float price = 7;

    public NordBread(IStew stew) {
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
        return super.toString() + ", Нордская лепешка";
    }
}
