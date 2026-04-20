package models;

public abstract class Addition implements IStew {
    private IStew stew;

    public Addition(IStew stew) {
        this.stew = stew;
    }

    @Override
    public String toString() {
        return stew.toString();
    }

    @Override
    public float checkout() {
        return stew.checkout();
    }

    public IStew getStew() {
        return stew;
    }

    public void setStew(IStew stew) {
        this.stew = stew;
    }
}
