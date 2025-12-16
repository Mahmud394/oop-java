/*

✅ When to Use

Use Decorator when:

You want to add extra features dynamically

Without changing the original class

📘 Scenario

A Coffee has a base price.
You can add Milk or Sugar without changing Coffee class.
*/

// Component
interface Coffee {
    int cost();
}

// Base Class
class SimpleCoffee implements Coffee {
    public int cost() {
        return 50;
    }
}

// Decorator
class MilkDecorator implements Coffee {
    Coffee coffee;

    MilkDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public int cost() {
        return coffee.cost() + 20;
    }
}

// Client
public class DecoratorPattern {
    public static void main(String[] args) {
        Coffee coffee = new MilkDecorator(new SimpleCoffee());
        System.out.println(coffee.cost());
    }
}
