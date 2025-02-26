import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderManager orderManager = new OrderManager();

        // Creating sample products
        Product laptop = new Product("Laptop", 1200.0, 20, 5);
        Product smartphone = new Product("Smartphone", 800.0, 10, 3);

        // User Input: Average daily sales
        System.out.print("Enter average daily sales for Laptop: ");
        int laptopSales = scanner.nextInt();
        System.out.print("Enter average daily sales for Smartphone: ");
        int phoneSales = scanner.nextInt();

        // Display product info
        System.out.println("\n" + laptop);
        System.out.println("----------------------------");
        System.out.println(smartphone);
        System.out.println("----------------------------");

        // Predict stock depletion
        StockPredictor.predictStock(laptop, laptopSales);
        StockPredictor.predictStock(smartphone, phoneSales);

        // Process orders
        Order order1 = new Order("Alice", laptop.getProductId(), 2);
        Order order2 = new Order("Bob", smartphone.getProductId(), 1);

        orderManager.processOrder(order1);
        orderManager.processOrder(order2);

        // Wait for orders to complete before shutting down
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        orderManager.shutdown();
        scanner.close();
    }
}
