package logbook.week5;

import java.util.ArrayList;

// Product Class
class Product {
    private final int id;
    private final String name;
    private int quantity;

    // Constructor
    public Product(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    // Set quantity
    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Quantity cannot be negative!");
        }
    }

    // Print product details
    public void printProduct() {
        System.out.println("ID: " + id + ", Name: " + name + ", Quantity: " + quantity);
    }
}

// StockList Class
class StockList {
    private final ArrayList<Product> products;

    // Constructor to initialize the product list
    public StockList() {
        products = new ArrayList<>();
    }

    // Add a product to the stock list
    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " added to stock.");
    }

    // Remove a product by ID
    public void removeProduct(int id) {
        Product productToRemove = findProduct(id);
        if (productToRemove != null) {
            products.remove(productToRemove);
            System.out.println(productToRemove.getName() + " removed from stock.");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Find a product by ID
    public Product findProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    // Print all products
    public void printStock() {
        System.out.println("\nStock List:");
        for (Product product : products) {
            product.printProduct();
        }
    }
}

// StockDemo Class
class StockDemo {
    private final StockList stockList;

    // Constructor to initialize StockList
    public StockDemo() {
        stockList = new StockList();
    }

    // Test: Adding products
    public void testAddProducts() {
        Product p1 = new Product(101, "Laptop", 5);
        Product p2 = new Product(102, "Smartphone", 10);
        Product p3 = new Product(103, "Headphones", 15);

        stockList.addProduct(p1);
        stockList.addProduct(p2);
        stockList.addProduct(p3);
    }

    // Test: Removing a product
    public void testRemoveProduct() {
        stockList.removeProduct(102); // Remove the smartphone
    }

    // Test: Printing all stock
    public void testPrintStock() {
        stockList.printStock();
    }

    // Test: Finding a product
    public void testFindProduct() {
        Product found = stockList.findProduct(101);
        if (found != null) {
            System.out.println("\nProduct Found: ");
            found.printProduct();
        } else {
            System.out.println("Product not found.");
        }
    }

    // Run all tests
    public void run() {
        testAddProducts();
        testPrintStock();
        testFindProduct();
        testRemoveProduct();
        testPrintStock();
    }
}

// Main Class to run the program
public class Main {
    public static void main(String[] args) {
        StockDemo demo = new StockDemo();
        demo.run();
    }
}
