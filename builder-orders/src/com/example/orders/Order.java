package com.example.orders;

import java.util.ArrayList;
import java.util.List;

/**
 * Telescoping constructors + setters. Allows invalid states.
 */
public class Order {
    private String id;
    private String customerEmail;
    private final List<OrderLine> lines = new ArrayList<>();
    private Integer discountPercent; // 0..100 expected, but not enforced
    private boolean expedited;
    private String notes;

    public Order(Builder b){
        this.id = b.id;
        this.customerEmail = b.customerEmail;
        for(OrderLine line : b.lines) {
            this.lines.add(new OrderLine(line));
        }
        this.discountPercent = b.discountPercent;
        this.expedited = b.expedited;
        this.notes = b.notes;
        
    }

 

    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public List<OrderLine> getLines() { 
        List<OrderLine> copy = new ArrayList<>();
        for (OrderLine line : lines) {
            copy.add(new OrderLine(line));
        }
        return copy;
    }

    public Integer getDiscountPercent() { return discountPercent; }
    public boolean isExpedited() { return expedited; }
    public String getNotes() { return notes; }

    public int totalBeforeDiscount() {
        int sum = 0;
        for (OrderLine l : lines) sum += l.getQuantity() * l.getUnitPriceCents();
        return sum;
    }

    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null) return base;
        return base - (base * discountPercent / 100);
    }
    public static class Builder {
        private String id;
        private String customerEmail;
        private final List<OrderLine> lines = new ArrayList<>();
        private Integer discountPercent;
        private boolean expedited;
        private String notes;
        public Builder setId(String id) {
            this.id = id;
            return this;
        }
        public Builder setCustomerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
            return this;
        }
        public Builder addLine(OrderLine line) {
            this.lines.add(line);
            return this;
        }
        public Builder setDiscountPercent(Integer discountPercent) {
            this.discountPercent = discountPercent;
            return this;
        }
        public Builder setExpedited(boolean expedited) {
            this.expedited = expedited;
            return this;
        }
        public Builder setNotes(String notes) {
            this.notes = notes;
            return this;
        }
        public Order build(){
            return new Order(this);
        }
    }
}
