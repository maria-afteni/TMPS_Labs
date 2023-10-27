package Domain.Production.Patterns.Structural.Composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeOrder extends OrderComponent {
    private List<OrderComponent> orders = new ArrayList<>();

    @Override
    public void display() {
        for (OrderComponent order : orders) {
            order.display();
        }
    }

    @Override
    public double getTotalPrice() {
        double totalPrice = 0;
        for (OrderComponent order : orders) {
            totalPrice += order.getTotalPrice();
        }
        return totalPrice;
    }

    public void addOrder(OrderComponent order) {
        orders.add(order);
    }

    void removeOrder(OrderComponent order) {
        orders.remove(order);
    }
}