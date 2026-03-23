package models;

public abstract class Addition implements IStew {
    protected IStew stew;


    public Addition(IStew stew) {
        this.stew = stew;
    }

    public IStew getStew() {
        return stew;
    }

    public void setStew(IStew stew) {
        this.stew = stew;
    }
}
