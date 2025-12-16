// Adapter_Pattern

/*
📘 Scenario

A University Management System processes all payments using a PaymentSystem interface.
The system already supports Credit Card payments.
Now the university wants to add Bkash payment, but Bkash API uses a different method name.
We use Adapter Pattern to integrate Bkash without changing existing code.
*/
// Target Interface
interface PaymentSystem {
    void payAmount(int amount);
}

// Existing System
class CreditCardPayment implements PaymentSystem {
    public void payAmount(int amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

// Third-party class (Incompatible)
class BkashService {
    void sendMoney(int amount) {
        System.out.println("Paid " + amount + " using Bkash");
    }
}

// Adapter
class BkashAdapter implements PaymentSystem {
    BkashService bkash = new BkashService();

    public void payAmount(int amount) {
        bkash.sendMoney(amount);
    }
}

// Client
public class Adapter_Pattern {
    public static void main(String[] args) {
        PaymentSystem payment1 = new CreditCardPayment();
        payment1.payAmount(5000);

        PaymentSystem payment2 = new BkashAdapter();
        payment2.payAmount(3000);
    }
}
