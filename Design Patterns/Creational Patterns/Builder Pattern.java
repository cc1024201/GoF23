/**
 * Builder Pattern
 * Definition: Separate the construction of a complex object from its representation so that the same construction process can create different representations.
 * Type: Creational Pattern
 *
 * Applicable scenarios:
 * 1. When the algorithm for creating a complex object should be independent of the parts that make up the object and how they're assembled.
 * 2. When the construction process must allow different representations for the object that's constructed.
 *
 * Advantages:
 * 1. It provides a clear separation between the construction and representation of an object.
 * 2. It allows you to vary a product's internal representation.
 * 3. It isolates code for construction and representation.
 * 4. It gives you finer control over the construction process.
 *
 * Disadvantages:
 * 1. It requires creating a separate ConcreteBuilder for each different type of product.
 * 2. It requires the builder classes to be mutable.
 *
 * Structure:
 * 1. Builder: specifies an abstract interface for creating parts of a Product object.
 * 2. ConcreteBuilder: constructs and assembles parts of the product by implementing the Builder interface.
 * 3. Director: constructs the complex object using the Builder interface.
 * 4. Product: represents the complex object being built.
 *
 * Example:
 * We want to build a car with different features such as engine, wheels, and color. We can use the Builder pattern to create a CarBuilder interface that specifies methods for building each feature. We can then create a ConcreteBuilder class for each type of car we want to build, such as a SportsCarBuilder and a SUVBuilder. Finally, we can use a Director class to construct the car by calling the appropriate methods on the builder.
 *
 * Code implementation:
 * Taking the car example as an example, we can implement the Builder pattern as follows:
 */

interface CarBuilder {
    void buildEngine();
    void buildWheels();
    void buildColor();
    Car getCar();
}

class SportsCarBuilder implements CarBuilder {
    private Car car = new Car();

    @Override
    public void buildEngine() {
        car.setEngine("V8");
    }

    @Override
    public void buildWheels() {
        car.setWheels("18 inch");
    }

    @Override
    public void buildColor() {
        car.setColor("Red");
    }

    @Override
    public Car getCar() {
        return car;
    }
}

class SUVBuilder implements CarBuilder {
    private Car car = new Car();

    @Override
    public void buildEngine() {
        car.setEngine("V6");
    }

    @Override
    public void buildWheels() {
        car.setWheels("20 inch");
    }

    @Override
    public void buildColor() {
        car.setColor("Black");
    }

    @Override
    public Car getCar() {
        return car;
    }
}

class Car {
    private String engine;
    private String wheels;
    private String color;

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setWheels(String wheels) {
        this.wheels = wheels;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", wheels='" + wheels + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

class Director {
    private CarBuilder carBuilder;

    public Director(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

    public void constructCar() {
        carBuilder.buildEngine();
        carBuilder.buildWheels();
        carBuilder.buildColor();
    }

    public Car getCar() {
        return carBuilder.getCar();
    }
}

public class BuilderPatternDemo {
    public static void main(String[] args) {
        CarBuilder sportsCarBuilder = new SportsCarBuilder();
        Director director = new Director(sportsCarBuilder);
        director.constructCar();
        Car sportsCar = director.getCar();
        System.out.println(sportsCar);

        CarBuilder suvBuilder = new SUVBuilder();
        director = new Director(suvBuilder);
        director.constructCar();
        Car suv = director.getCar();
        System.out.println(suv);
    }
}
