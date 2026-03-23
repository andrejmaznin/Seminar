package logic;

import models.Addition;
import models.IStew;
import models.OrderInfo;
import models.Stew;

import java.util.ArrayList;
import java.util.List;

public class Engine {
    private List<OrderInfo> orders = new ArrayList<>();
    private IStew currentOrder;

    public Engine() {
    }

    public Engine(List<OrderInfo> orders) {
        this.orders = orders;
    }

    public void startOrder() {
        this.currentOrder = new Stew();
    }

    public void resetCurrentOrder() {
        this.currentOrder = new Stew();
    }

    public void commitOrder() {
        if (this.currentOrder != null) {
            this.orders.add(new OrderInfo(this.currentOrder));
            this.currentOrder = null;
        }
    }

    public void addAddition(Class<? extends Addition> additionClass) {
        if (this.currentOrder == null) {
            throw new IllegalStateException("Заказ не начат");
        }
        try {
            this.currentOrder = additionClass.getConstructor(IStew.class).newInstance(this.currentOrder);
        } catch (Exception e) {
            throw new RuntimeException("Не удалось добавить добавку: " + additionClass.getSimpleName(), e);
        }
    }

    public IStew getCurrentOrder() {
        return currentOrder;
    }

    public List<OrderInfo> getOrders() {
        return orders;
    }
}
