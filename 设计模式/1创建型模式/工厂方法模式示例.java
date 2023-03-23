//工厂方法模式（Factory Method）：工厂方法模式是一种创建型设计模式，它定义了一个用于创建对象的接口，但是由子类决定要实例化的类是哪一个。工厂方法让类把实例化推迟到子类。
//定义产品接口
interface Product {
    void show();
}

//具体产品类A
class ConcreteProductA implements Product {
    @Override
    public void show() {
        System.out.println("具体产品A");
    }
}

//具体产品类B
class ConcreteProductB implements Product {
    @Override
    public void show() {
        System.out.println("具体产品B");
    }
}

//抽象工厂类
abstract class Factory {
    public abstract Product createProduct();
}

//具体工厂类A
class ConcreteFactoryA extends Factory {
    @Override
    public Product createProduct() {
        return new ConcreteProductA();
    }
}

//具体工厂类B
class ConcreteFactoryB extends Factory {
    @Override
    public Product createProduct() {
        return new ConcreteProductB();
    }
}

//客户端代码
public class Client {
    public static void main(String[] args) {
        Factory factoryA = new ConcreteFactoryA();
        Product productA = factoryA.createProduct();
        productA.show();

        Factory factoryB = new ConcreteFactoryB();
        Product productB = factoryB.createProduct();
        productB.show();
    }
}
