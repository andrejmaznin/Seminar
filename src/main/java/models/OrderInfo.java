package models;

import java.time.LocalDateTime;

public class OrderInfo {
    private final IStew order;
    private final LocalDateTime dateTime;

    public OrderInfo(IStew order) {
        this.order = order;
        this.dateTime = LocalDateTime.now();
    }

    public IStew getOrder() {
        return order;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
