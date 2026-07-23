class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order(101, "Amit", 2500.50),
            new Order(102, "Bhavana", 1500.75),
            new Order(103, "Chandan", 3200.00),
            new Order(104, "Deepa", 1800.25),
            new Order(105, "Eshan", 2900.10)
        };

        System.out.println("Original Orders:");
        for (Order o : orders) {
            System.out.println(o);
        }

        bubbleSort(orders);
        System.out.println("\nOrders Sorted by Bubble Sort:");
        for (Order o : orders) {
            System.out.println(o);
        }

        Order[] orders2 = {
            new Order(101, "Amit", 2500.50),
            new Order(102, "Bhavana", 1500.75),
            new Order(103, "Chandan", 3200.00),
            new Order(104, "Deepa", 1800.25),
            new Order(105, "Eshan", 2900.10)
        };

        quickSort(orders2, 0, orders2.length - 1);
        System.out.println("\nOrders Sorted by Quick Sort:");
        for (Order o : orders2) {
            System.out.println(o);
        }
    }
}
