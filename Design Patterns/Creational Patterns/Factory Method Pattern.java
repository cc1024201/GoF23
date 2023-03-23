/**
 * Factory Method Pattern
 * Definition: Define an interface for creating an object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.
 * Type: Creational Pattern
 *
 * Applicable scenarios:
 * 1. When a class can't anticipate the type of objects it needs to create.
 * 2. When a class wants its subclasses to specify the objects it creates.
 * 3. When a class wants to delegate the responsibility of object creation to its subclasses.
 *
 * Advantages:
 * 1. Provides a way to delegate the object creation responsibility to the subclasses.
 * 2. Provides a way to easily add new products to the system without modifying the existing code.
 * 3. Provides a way to easily switch between different product implementations.
 *
 * Disadvantages:
 * 1. Increases the number of classes in the system.
 * 2. Can make the code more complex.
 *
 * Structure:
 * 1. Creator: The abstract class or interface that defines the factory method.
 * 2. ConcreteCreator: The concrete class that implements the factory method and creates the product.
 * 3. Product: The abstract class or interface that defines the object being created.
 * 4. ConcreteProduct: The concrete class that implements the Product interface.
 *
 * Example:
 * We have a PizzaStore that creates different types of pizzas. The PizzaStore has a createPizza() method that is responsible for creating the pizzas. The PizzaStore is an abstract class and the createPizza() method is an abstract method. The PizzaStore has two subclasses: NYStylePizzaStore and ChicagoStylePizzaStore. Each subclass implements the createPizza() method to create different types of pizzas.
 *
 * Code implementation:
 * Taking the PizzaStore example, we have the following code implementation:
 */

// Product interface
interface Pizza {
    void prepare();
    void bake();
    void cut();
    void box();
}

// ConcreteProduct class
class NYStyleCheesePizza implements Pizza {
    public void prepare() {
        System.out.println("Preparing NY Style Cheese Pizza");
    }
    public void bake() {
        System.out.println("Baking NY Style Cheese Pizza");
    }
    public void cut() {
        System.out.println("Cutting NY Style Cheese Pizza");
    }
    public void box() {
        System.out.println("Boxing NY Style Cheese Pizza");
    }
}

// ConcreteProduct class
class ChicagoStyleCheesePizza implements Pizza {
    public void prepare() {
        System.out.println("Preparing Chicago Style Cheese Pizza");
    }
    public void bake() {
        System.out.println("Baking Chicago Style Cheese Pizza");
    }
    public void cut() {
        System.out.println("Cutting Chicago Style Cheese Pizza");
    }
    public void box() {
        System.out.println("Boxing Chicago Style Cheese Pizza");
    }
}

// Creator abstract class
abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
    protected abstract Pizza createPizza(String type);
}

// ConcreteCreator class
class NYStylePizzaStore extends PizzaStore {
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new NYStyleCheesePizza();
        } else {
            return null;
        }
    }
}

// ConcreteCreator class
class ChicagoStylePizzaStore extends PizzaStore {
    protected Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        } else {
            return null;
        }
    }
}

// Test class
public class Test {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYStylePizzaStore();
        PizzaStore chicagoStore = new ChicagoStylePizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getClass().getName() + "\n");

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getClass().getName() + "\n");
    }
}
