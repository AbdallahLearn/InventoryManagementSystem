import java.io.*;
import java.util.List;

public class FileHandler {
    public static void saveOrdersToFile(List<Order> orders) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("orders.txt"))) {
            for (Order order : orders) {
                writer.write(order.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
