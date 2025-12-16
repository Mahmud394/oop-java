// Factory Pattern

/*
✅ When to Use

Use Factory when:

Object creation logic is complex

You want to hide object creation

Decide object type at runtime

📘 Scenario

A Notification System sends:

Email

SMS

Factory decides which object to create based on user input.
*/

// Product Interface
interface Notification {
    void send();
}

// Concrete Products
class EmailNotification implements Notification {
    public void send() {
        System.out.println("Email sent");
    }
}

class SMSNotification implements Notification {
    public void send() {
        System.out.println("SMS sent");
    }
}

// Factory Class
class NotificationFactory {
    public static Notification createNotification(String type) {
        if (type.equals("EMAIL"))
            return new EmailNotification();
        else
            return new SMSNotification();
    }
}

// Client
public class FactoryPattern {
    public static void main(String[] args) {
        Notification notification =
            NotificationFactory.createNotification("EMAIL");
        notification.send();
    }
}
