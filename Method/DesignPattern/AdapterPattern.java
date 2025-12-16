/*

✅ When to Use

Use Adapter when:

An existing class does not match the interface you need

You want to use old / third-party code without changing it

📘 Scenario

A Payment System accepts payments in Pay() format.
But a third-party PayPal service uses MakePayment() method.
Adapter converts PayPal to your system format.e the Lightning charger work with a USB-C phone using an Adapter Pattern.

*/

// Target Interface
interface Payment {
    void pay();
}

// Existing Class (Incompatible)
class PayPal {
    void makePayment() {
        System.out.println("Payment done via PayPal");
    }
}

// Adapter
class PayPalAdapter implements Payment {
    PayPal paypal = new PayPal();

    public void pay() {
        paypal.makePayment();
    }
}

// Client
public class AdapterPattern {
    public static void main(String[] args) {
        Payment payment = new PayPalAdapter();
        payment.pay();
    }
}
