package com.example.orders;

import java.util.List;

public class OrderService {

    public Order createOrder(String id, String email, List<OrderLine> lines, Integer discount, boolean expedited, String notes) {
        // Order o = new Order(id, email, discount);
        Order.Builder b = new Order.Builder().setId(id).setCustomerEmail(email).setDiscountPercent(discount);
        if (lines != null) for (OrderLine l : lines) b.addLine(l);
        b.setExpedited(expedited);
        b.setNotes(notes);
        return b.build();
    }
}
