//抽象工厂模式（Abstract Factory）：当需要创建一组相关或相互依赖的对象时，可以使用抽象工厂模式。抽象工厂模式可以将对象的创建过程封装在一个工厂类中，从而使得客户端无需关心对象的创建过程，只需要向工厂类请求所需的对象即可。
//抽象工厂模式的代码示例
//抽象产品类
interface ProductA {
    void use();
}
interface ProductB {
    void eat();
}
//具体产品类
class ConcreteProductA1 implements ProductA {
    @Override
    public void use() {
        System.out.println("使用具体产品A1");
    }
}
class ConcreteProductA2 implements ProductA {
    @Override
    public void use() {
        System.out.println("使用具体产品A2");
    }
}
class ConcreteProductB1 implements ProductB {
    @Override
    public void eat() {
        System.out.println("吃具体产品B1");
    }
}
class ConcreteProductB2 implements ProductB {
    @Override
    public void eat() {
        System.out.println("吃具体产品B2");
    }
}
//抽象工厂类
interface AbstractFactory {
    ProductA createProductA();
    ProductB createProductB();
}
//具体工厂类
class ConcreteFactory1 implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ConcreteProductA1();
    }
    @Override
    public ProductB createProductB() {
        return new ConcreteProductB1();
    }
}
class ConcreteFactory2 implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ConcreteProductA2();
    }
    @Override
    public ProductB createProductB() {
        return new ConcreteProductB2();
    }
}
//客户端
public class Client {
    public static void main(String[] args) {
        AbstractFactory factory1 = new ConcreteFactory1();
        ProductA productA1 = factory1.createProductA();
        ProductB productB1 = factory1.createProductB();
        productA1.use();
        productB1.eat();
        AbstractFactory factory2 = new ConcreteFactory2();
        ProductA productA2 = factory2.createProductA();
        ProductB productB2 = factory2.createProductB();
        productA2.use();
        productB2.eat();
    }
}
