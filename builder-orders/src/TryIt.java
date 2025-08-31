import com.example.orders.*;

public class TryIt {
    public static void main(String[] args) {
        OrderLine l1 = new OrderLine("A", 1, 200);
        OrderLine l2 = new OrderLine("B", 3, 100);
        Order.Builder b = new Order.Builder().setId("o2").setCustomerEmail( "a@b.com");
        b.addLine(l1);
        b.addLine(l2);
        b.setDiscountPercent(10);
        Order o = b.build();
        System.out.println("Before: " + o.totalAfterDiscount());
        l1.setQuantity(999); 
        System.out.println("After:  " + o.totalAfterDiscount());
        System.out.println("=> In the solution, totals remain stable due to defensive copies.");
    }
}
