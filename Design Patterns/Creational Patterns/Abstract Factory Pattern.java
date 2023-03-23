/**
 * Abstract Factory Pattern
 * Definition: Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
 * Type: Creational Pattern
 *
 * Applicable scenarios:
 * 1. A system should be independent of how its products are created, composed and represented.
 * 2. A system should be configured with one of multiple families of products.
 * 3. A family of related product objects is designed to be used together, and you need to enforce this constraint.
 * 4. You want to provide a class library of products, and you want to reveal just their interfaces, not their implementations.
 *
 * Advantages:
 * 1. You can be sure that the products you're getting from a factory are compatible with each other.
 * 2. You avoid tight coupling between concrete products and client code.
 * 3. Single Responsibility Principle. You can extract the product creation code into one place, making the code easier to support.
 * 4. Open/Closed Principle. You can introduce new variants of products without breaking existing client code.
 *
 * Disadvantages:
 * 1. The code may become more complicated than it should be, since a lot of new interfaces and classes are introduced along with the pattern.
 * 2. Applying the pattern can lead to an increase in the number of source code files.
 *
 * Structure:
 * AbstractFactory: declares an interface for operations that create abstract products.
 * ConcreteFactory: implements operations to create concrete products.
 * AbstractProduct: declares an interface for a type of product object.
 * ConcreteProduct: defines a product object to be created by the corresponding concrete factory.
 * Client: uses only interfaces declared by AbstractFactory and AbstractProduct classes.
 *
 * Example:
 * We have two types of products: cars and engines. We have two factories: Toyota and Honda. Toyota produces Toyota cars and Toyota engines, while Honda produces Honda cars and Honda engines.
 * Code implementation:
 * Taking cars and engines as an example, we have two abstract products: Car and Engine. We have two concrete products: ToyotaCar and HondaCar, and ToyotaEngine and HondaEngine. We have two abstract factories: CarFactory and EngineFactory. We have two concrete factories: ToyotaFactory and HondaFactory. The client uses only interfaces declared by AbstractFactory and AbstractProduct classes.
 */
public interface AbstractFactory {
    Car createCar();
    Engine createEngine();
}

public interface Car {
    void run();
}

public interface Engine {
    void start();
}

public class ToyotaFactory implements AbstractFactory {
    @Override
    public Car createCar() {
        return new ToyotaCar();
    }

    @Override
    public Engine createEngine() {
        return new ToyotaEngine();
    }
}

public class HondaFactory implements AbstractFactory {
    @Override
    public Car createCar() {
        return new HondaCar();
    }

    @Override
    public Engine createEngine() {
        return new HondaEngine();
    }
}

public class ToyotaCar implements Car {
    @Override
    public void run() {
        System.out.println("Toyota car is running.");
    }
}

public class HondaCar implements Car {
    @Override
    public void run() {
        System.out.println("Honda car is running.");
    }
}

public class ToyotaEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Toyota engine is starting.");
    }
}

public class HondaEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Honda engine is starting.");
    }
}

public class Client {
    public static void main(String[] args) {
        AbstractFactory toyotaFactory = new ToyotaFactory();
        Car toyotaCar = toyotaFactory.createCar();
        Engine toyotaEngine = toyotaFactory.createEngine();
        toyotaCar.run();
        toyotaEngine.start();

        AbstractFactory hondaFactory = new HondaFactory();
        Car hondaCar = hondaFactory.createCar();
        Engine hondaEngine = hondaFactory.createEngine();
        hondaCar.run();
        hondaEngine.start();
    }
}
