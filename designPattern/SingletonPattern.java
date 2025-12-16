// Singleton Pattern

/*
✅ When to Use

Use Singleton when:

Only one object is needed in the whole system

Global access is required

Example: Database connection, Logger, Configuration

📘 Scenario

A University System uses one Database Connection for all modules
(Student, Teacher, Result).
To avoid multiple connections, only one instance is created.
*/

class DatabaseConnection {

    private static DatabaseConnection instance;

    // Private constructor
    private DatabaseConnection() {}

    // Public method to get instance
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    void connect() {
        System.out.println("Database Connected");
    }
}

// Client
public class SingletonPattern {
    public static void main(String[] args) {
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();

        db1.connect();
        System.out.println(db1 == db2); // true
    }
}
