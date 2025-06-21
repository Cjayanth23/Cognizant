import java.util.Arrays;
import java.util.Comparator;
public class SearchOptimizationDemo {

    
    public static class Product {
        int productId;
        String productName;
        String category;

        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "productId=" + productId +
                    ", productName='" + productName + '\'' +
                    ", category='" + category + '\'' +
                    '}';
        }
    }


    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.productId == targetId) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].productId == targetId) {
                return products[mid];
            } else if (products[mid].productId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void explainBigONotation() {
        System.out.println("=== Asymptotic Notation (Big O) ===");
        System.out.println("- Big O notation describes algorithm efficiency in terms of input size.");
        System.out.println("- Best Case: O(1) → Immediate match.");
        System.out.println("- Average Case: O(n/2) for linear → O(n), O(log n) for binary.");
        System.out.println("- Worst Case: O(n) for linear, O(log n) for binary.\n");
    }

    public static void main(String[] args) {
        explainBigONotation();

        Product[] products = {
                new Product(105, "Laptop", "Electronics"),
                new Product(202, "T-Shirt", "Clothing"),
                new Product(309, "Smartphone", "Electronics"),
                new Product(407, "Shoes", "Footwear"),
                new Product(112, "Book", "Stationery")
        };

        int targetId = 309;

        System.out.println("=== Linear Search ===");
        Product resultLinear = linearSearch(products, targetId);
        System.out.println(resultLinear != null ? "Product found: " + resultLinear : "Product not found.");

        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        System.out.println("\n=== Binary Search (Sorted by Product ID) ===");
        Product resultBinary = binarySearch(products, targetId);
        System.out.println(resultBinary != null ? "Product found: " + resultBinary : "Product not found.");

        System.out.println("\n=== Time Complexity Comparison ===");
        System.out.println("Linear Search → O(n)");
        System.out.println("Binary Search → O(log n), but requires sorted input.");
        System.out.println("Conclusion: Use Binary Search for large, sorted datasets for better performance.");
    }
}
