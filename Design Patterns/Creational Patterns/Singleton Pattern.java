/**
 * Singleton Pattern
 * Definition: Ensure a class has only one instance, and provide a global point of access to it.
 * Type: Creational Pattern
 *
 * Applicable scenarios:
 * When we need to ensure that only one instance of a class is created and that it is easily accessible to clients.
 *
 * Advantages:
 * 1. Saves memory by creating only one instance of a class.
 * 2. Provides a global point of access to the instance.
 * 3. Allows for lazy initialization, meaning the instance is only created when it is needed.
 *
 * Disadvantages:
 * 1. Can make unit testing difficult.
 * 2. Can make the code more difficult to understand and maintain.
 *
 * Structure:
 * Singleton: the class that is responsible for creating and managing the single instance.
 *
 * Example:
 * A database connection class that needs to ensure only one connection is created and that it is easily accessible to clients.
 * Code implementation:
 * Taking the database connection class as an example, we can create a Singleton class that manages the connection instance.
 */

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private String url;
    private String username;
    private String password;

    private DatabaseConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DatabaseConnection getInstance(String url, String username, String password) {
        if (instance == null) {
            instance = new DatabaseConnection(url, username, password);
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connecting to database: " + url);
    }

    public void disconnect() {
        System.out.println("Disconnecting from database: " + url);
    }
}

// Test case
public class SingletonPatternTest {
    public static void main(String[] args) {
        DatabaseConnection connection1 = DatabaseConnection.getInstance("jdbc:mysql://localhost:3306/mydb", "root", "password");
        DatabaseConnection connection2 = DatabaseConnection.getInstance("jdbc:mysql://localhost:3306/mydb", "root", "password");

        System.out.println(connection1 == connection2); // true
        connection1.connect();
        connection1.disconnect();
    }
}
