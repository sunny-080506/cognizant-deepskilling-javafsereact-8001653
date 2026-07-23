import java.util.*;
class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName,
                   int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return productId + " " + productName +
               " Qty:" + quantity + " Price:" + price;
    }
}
public class Inventory {
    HashMap<Integer, Product> products = new HashMap<>();

    public void addProduct(Product p) {
        products.put(p.productId, p);
    }

    public void updateProduct(int id, int quantity, double price) {
        Product p = products.get(id);

        if (p != null) {
            p.quantity = quantity;
            p.price = price;
        }
    }

    public void deleteProduct(int id) {
        products.remove(id);
    }

    public void displayProducts() {
        products.values().forEach(System.out::println);
    }
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        Product P=new Product(1,"PRODUCT 1", 3, 34.50);
        System.out.println(P.toString());
        Inventory i=new Inventory();
        i.addProduct(P);
        i.displayProducts();
        i.updateProduct(1,5,90.00);
        i.displayProducts();
        i.deleteProduct(1);
        i.displayProducts();
    }
}