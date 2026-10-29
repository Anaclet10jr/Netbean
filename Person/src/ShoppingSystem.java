
class Product {
    String productName;
    double price;
    int quantity;

    // Constructor
    Product(String name, double productPrice, int productQuantity) {
        productName = name;
        price = productPrice;
        quantity = productQuantity;
    }

    // Displays product details
    void displayProduct() {
        System.out.println("Product: " + productName);
        System.out.printf("Price: %.2f%n", price);
        System.out.println("Quantity: " + quantity);
        System.out.printf("Total: %.2f%n", calculateTotalValue());
    }

    // Increases the quantity
    void increaseQuantity(int amount) {
        if (amount > 0) {
            quantity = quantity + amount;
        } else {
            System.out.println("Invalid quantity.");
        }
    }

    // Decreases the quantity
    void decreaseQuantity(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid quantity.");
        } else if (amount > quantity) {
            System.out.println("Not enough products in stock.");
        } else {
            quantity = quantity - amount;
        }
    }

    // Calculates the value of this product
    double calculateTotalValue() {
        return price * quantity;
    }
}

class ShoppingCart {
    Product[] products;
    int productCount;

    // Creates a cart with a maximum capacity
    ShoppingCart(int capacity) {
        products = new Product[capacity];
        productCount = 0;
    }

    // Adds a product to the cart
    void addProduct(Product product) {
        if (productCount < products.length) {
            products[productCount] = product;
            productCount++;
        } else {
            System.out.println("Shopping cart is full.");
        }
    }

    // Displays all products
    void displayProducts() {
        System.out.println("===== SHOPPING CART =====");

        for (int i = 0; i < productCount; i++) {
            products[i].displayProduct();
            System.out.println();
        }

        System.out.println("=========================");
        System.out.printf("Total Cost: %.2f%n", calculateTotalCost());
    }

    // Calculates the total cost
    double calculateTotalCost() {
        double total = 0;

        for (int i = 0; i < productCount; i++) {
            total = total + products[i].calculateTotalValue();
        }

        return total;
    }

    // Challenge: applies a percentage discount
    double applyDiscount(double percentage) {
        if (percentage < 0 || percentage > 100) {
            System.out.println("Invalid discount percentage.");
            return calculateTotalCost();
        }

        double total = calculateTotalCost();
        return total - (total * percentage / 100);
    }
}

public class ShoppingSystem {
    public static void main(String[] args) {
        Product laptop = new Product("Laptop", 800, 2);
        Product mouse = new Product("Mouse", 25, 3);
        Product keyboard = new Product("Keyboard", 50, 1);

        ShoppingCart cart = new ShoppingCart(10);

        cart.addProduct(laptop);
        cart.addProduct(mouse);
        cart.addProduct(keyboard);

        // Modify the mouse quantity
        mouse.increaseQuantity(1);

        cart.displayProducts();

        System.out.printf(
            "Total after 10%% discount: %.2f%n",
            cart.applyDiscount(10)
        );
    }
}
