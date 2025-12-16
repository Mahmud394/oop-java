// State_Pattern 
    
/*

📘 Scenario

An Online Order System has different states:

New Order

Shipped

Delivered

Order behavior changes based on state.
*/

interface OrderState {
    void status();
}

class NewOrder implements OrderState {
    public void status() {
        System.out.println("Order placed");
    }
}

class ShippedOrder implements OrderState {
    public void status() {
        System.out.println("Order shipped");
    }
}

class DeliveredOrder implements OrderState {
    public void status() {
        System.out.println("Order delivered");
    }
}

class Order {
    OrderState state;

    void setState(OrderState state) {
        this.state = state;
    }

    void showStatus() {
        state.status();
    }
}

// Client
public class State_Pattern {
    public static void main(String[] args) {
        Order order = new Order();

        order.setState(new NewOrder());
        order.showStatus();

        order.setState(new ShippedOrder());
        order.showStatus();
    }
}
