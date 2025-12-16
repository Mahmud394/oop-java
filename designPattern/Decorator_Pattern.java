// Decorator_Pattern

/*
📘 Scenario

An Online Food Delivery App sells a Basic Burger.
Customers can add Cheese, Extra Sauce, or Fries.
Each add-on increases price dynamically.
Decorator pattern allows adding features without changing base class.
*/
// Component
interface FoodItem {
    int getPrice();
    String getDescription();
}

// Base Item
class Burger implements FoodItem {
    public int getPrice() {
        return 150;
    }

    public String getDescription() {
        return "Burger";
    }
}

// Abstract Decorator
abstract class FoodDecorator implements FoodItem {
    FoodItem item;

    FoodDecorator(FoodItem item) {
        this.item = item;
    }
}

// Concrete Decorator
class Cheese extends FoodDecorator {
    Cheese(FoodItem item) {
        super(item);
    }

    public int getPrice() {
        return item.getPrice() + 30;
    }

    public String getDescription() {
        return item.getDescription() + " + Cheese";
    }
}

// Client
public class Decorator_Pattern {
    public static void main(String[] args) {
        FoodItem order = new Cheese(new Burger());
        System.out.println(order.getDescription());
        System.out.println("Total Price: " + order.getPrice());
    }
}
