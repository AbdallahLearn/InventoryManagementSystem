public class StockPredictor {
    public static void predictStock(Product product, int avgDailySales) {
        int daysUntilStockOut = product.getStockLevel() / avgDailySales;
        String suggestion = getRestockSuggestion(daysUntilStockOut, product.getReorderThreshold());

        System.out.println("\nStock Prediction for " + product.getName() + ":");
        System.out.println("Days until stock out: " + daysUntilStockOut);
        System.out.println("Restock Suggestion: " + suggestion);
    }

    private static String getRestockSuggestion(int daysUntilStockOut, int reorderThreshold) {
        if (daysUntilStockOut <= reorderThreshold) {
            return "Urgent: Restock immediately!";
        } else if (daysUntilStockOut <= reorderThreshold * 2) {
            return "Moderate: Consider restocking soon.";
        }
        return "Stock is sufficient.";
    }
}
