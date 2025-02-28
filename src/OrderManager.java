import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class OrderManager {
    private List<Order> orders = new ArrayList<>();
    private ExecutorService executor = Executors.newFixedThreadPool(3); // Thread pool for processing orders

    public void processOrder(Order order) {
        orders.add(order);
        System.out.println("Order received: " + order);

        executor.submit(() -> {
            try {
                Thread.sleep(3000); // Simulate processing time
                updateOrderStatus(order, OrderStatus.SHIPPED);

                Thread.sleep(3000); // Simulate delivery time
                updateOrderStatus(order, OrderStatus.DELIVERED);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private void updateOrderStatus(Order order, OrderStatus newStatus) {
        order.setOrderStatus(newStatus);
        logOrder(order);
    }
    //add commit on feature-stock branch on 30 line
    //add comment on line 30 by feature-orders branch
    private void logOrder(Order order) {
        System.out.println("Order Update: " + order);
    }

    public void shutdown() {
        executor.shutdown();
    }
}
