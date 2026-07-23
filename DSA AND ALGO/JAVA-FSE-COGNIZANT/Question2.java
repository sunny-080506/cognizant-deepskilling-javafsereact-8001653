import java.util.Arrays;
class Product {
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
        return "Product ID: " + productId +
               ", Name: " + productName +
               ", Category: " + category;
    }
}
public class Question2 {
    public static Product linearSearch(Product[] products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name))
                return p;
        }
        return null;
    }
    public static Product binarySearch(Product[] products, String name) {
        int left = 0;
        int right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int compare = products[mid].productName.compareToIgnoreCase(name);

            if (compare == 0)
                return products[mid];
            if (compare < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Apple", "Fruit"),
            new Product(102, "Banana", "Fruit"),
            new Product(103, "Carrot", "Vegetable"),
            new Product(104, "Mango", "Fruit"),
            new Product(105, "Potato", "Vegetable")
        };
        Arrays.sort(products, (a, b) -> a.productName.compareToIgnoreCase(b.productName));
        String searchName1 = "Mango";
        Product result1 = linearSearch(products, searchName1);
        System.out.println("Linear Search Result for '" + searchName1 + "':");
        System.out.println(result1 != null ? result1 : "Not Found");
        String searchName2 = "Carrot";
        Product result2 = binarySearch(products, searchName2);
        System.out.println("\nBinary Search Result for '" + searchName2 + "':");
        System.out.println(result2 != null ? result2 : "Not Found");
        String searchName3 = "Orange";
        Product result3 = binarySearch(products, searchName3);
        System.out.println("\nBinary Search Result for '" + searchName3 + "':");
        System.out.println(result3 != null ? result3 : "Not Found");
    }
}
