package designPattern;

/*
The PaymentGateway interface represents the common interface expected by the client code.
The LegacyPaymentGateway class is the existing class with an incompatible interface.
The PaymentGatewayAdapter class implements the PaymentGateway interface and adapts the LegacyPaymentGateway interface to match the PaymentGateway interface.
The client code can use either the modern payment gateway directly or the legacy payment gateway through the adapter, without any changes to its code.
Also you have to add method for registration and login system, which creates the user class entity only once.
Select which design patterns you need to use in this case and design the code. Must construct multiple objects of the class from the main method.
 */

 // PaymentGateway interface (Target interface)
interface PaymentGateway {
    void processPayment(double amount);
    void refundPayment(double amount);
}

// ModernPaymentGateway implementation
class ModernPaymentGateway implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " via modern gateway");
    }

    @Override
    public void refundPayment(double amount) {
        System.out.println("Refunding $" + amount + " via modern gateway");
    }
}

// LegacyPaymentGateway (Adaptee - incompatible interface)
class LegacyPaymentGateway {
    public void makePayment(double amount) {
        System.out.println("Legacy system processing payment of $" + amount);
    }

    public void issueRefund(double amount) {
        System.out.println("Legacy system issuing refund of $" + amount);
    }
}

// Adapter for LegacyPaymentGateway
class PaymentGatewayAdapter implements PaymentGateway {
    private LegacyPaymentGateway legacyGateway;

    public PaymentGatewayAdapter(LegacyPaymentGateway legacyGateway) {
        this.legacyGateway = legacyGateway;
    }

    @Override
    public void processPayment(double amount) {
        legacyGateway.makePayment(amount);
    }

    @Override
    public void refundPayment(double amount) {
        legacyGateway.issueRefund(amount);
    }
}

// User system with Singleton pattern
class User {
    private static User instance;
    private String username;
    private String email;

    private User(String username, String email) {
        this.username = username;
        this.email = email;
        System.out.println("User created: " + username + ", " + email);
    }

    public static synchronized User getInstance(String username, String email) {
        if (instance == null) {
            instance = new User(username, email);
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}

// Client code
public class sweAdapter {
    public static void main(String[] args) {
        // Create multiple payment gateway objects
        PaymentGateway modernGateway = new ModernPaymentGateway();
        LegacyPaymentGateway legacyGateway = new LegacyPaymentGateway();
        PaymentGateway adaptedGateway = new PaymentGatewayAdapter(legacyGateway);

        // Process payments using different gateways
        modernGateway.processPayment(100.0);
        modernGateway.refundPayment(25.0);

        adaptedGateway.processPayment(200.0);
        adaptedGateway.refundPayment(50.0);

        // User registration/login system
        User user1 = User.getInstance("john_doe", "john@example.com");
        User user2 = User.getInstance("jane_doe", "jane@example.com");

        System.out.println("User1: " + user1.getUsername());
        System.out.println("User2: " + user2.getUsername());
        System.out.println("Are users the same instance? " + (user1 == user2));
    }
}
