/**
 * 访问者模式
 * 定义：封装一些作用于某种数据结构中的各元素的操作，它可以在不改变数据结构的前提下定义作用于这些元素的新的操作。
 * 类型：行为型
 *
 * 适用场景：
 * 1. 一个对象结构包含多个类型的对象，希望对这些对象实施一些依赖其具体类型的操作。
 * 2. 需要对一个对象结构中的对象进行很多不同的且不相关的操作，而需要避免这些操作“污染”这些对象的类。
 *
 * 优点：
 * 1. 增加新的访问操作很方便，不破坏原有系统。
 * 2. 将有关元素对象的访问行为集中到一个访问者对象中，而不是分散在一个个的元素类中。
 *
 * 缺点：
 * 1. 具体元素对访问者公布细节，违反了迪米特原则。
 * 2. 具体元素变更比较困难。
 * 3. 违反了依赖倒置原则，为了达到“区别对待”而依赖了具体类，没有依赖抽象。
 *
 * 结构：
 * 1. 抽象访问者（Visitor）：定义了对每一个元素类访问时所要执行的操作。
 * 2. 具体访问者（ConcreteVisitor）：实现了抽象访问者定义的操作。
 * 3. 抽象元素类（Element）：定义了一个接受访问者的方法。
 * 4. 具体元素类（ConcreteElement）：实现了抽象元素类定义的接受方法。
 * 5. 对象结构（Object Structure）：是一个包含元素的容器，提供让访问者遍历容器中的所有元素的方法，通常由 List、Set、Map 等聚合类实现。
 *
 * 案例：
 * 以购物车为例，购物车中有多种商品，每种商品都有自己的价格和数量，购物车中的商品可以被添加、删除、修改数量等操作，
 * 而且购物车中的商品价格也可能随时变化，我们需要计算购物车中的商品总价，这时候就可以使用访问者模式。
 *
 * 代码实现：
 * 以购物车为例，购物车中有多种商品，每种商品都有自己的价格和数量，购物车中的商品可以被添加、删除、修改数量等操作，
 * 而且购物车中的商品价格也可能随时变化，我们需要计算购物车中的商品总价，这时候就可以使用访问者模式。
 *
 * 首先，定义商品类 Item，包含商品名称、价格、数量等属性，以及 accept 方法，接受访问者访问。
 */
public interface Item {
    String name();
    double price();
    int count();
    double accept(Visitor visitor);
}

/**
 * 定义了一个访问者接口 Visitor，包含了对商品的访问方法 visit(Item item)。
 */
public interface Visitor {
    double visit(Item item);
}

/**
 * 定义了一个具体的访问者类 DiscountVisitor，实现了 Visitor 接口，实现了对商品的访问方法 visit(Item item)，
 * 计算商品的折扣价。
 */
public class DiscountVisitor implements Visitor {
    @Override
    public double visit(Item item) {
        return item.price() * item.count() * 0.8;
    }
}

/**
 * 定义了一个具体的访问者类 OriginalVisitor，实现了 Visitor 接口，实现了对商品的访问方法 visit(Item item)，
 * 计算商品的原价。
 */
public class OriginalVisitor implements Visitor {
    @Override
    public double visit(Item item) {
        return item.price() * item.count();
    }
}

/**
 * 定义了一个具体的商品类 Book，实现了 Item 接口，实现了 accept 方法，接受访问者访问。
 */
public class Book implements Item {
    private String name;
    private double price;
    private int count;

    public Book(String name, double price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public double price() {
        return price;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}

/**
 * 定义了一个具体的商品类 Food，实现了 Item 接口，实现了 accept 方法，接受访问者访问。
 */
public class Food implements Item {
    private String name;
    private double price;
    private int count;

    public Food(String name, double price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public double price() {
        return price;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}

/**
 * 定义了一个购物车类 ShoppingCart，包含了多个商品，以及 add、remove、accept 等方法。
 */
public class ShoppingCart {
    private List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public void remove(Item item) {
        items.remove(item);
    }

    public double accept(Visitor visitor) {
        double total = 0;
        for (Item item : items) {
            total += item.accept(visitor);
        }
        return total;
    }
}

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.add(new Book("Java编程思想", 79.8, 2));
        cart.add(new Food("牛肉干", 28.5, 3));
        cart.add(new Book("设计模式", 59.9, 1));
        cart.add(new Food("薯片", 6.5, 5));

        Visitor originalVisitor = new OriginalVisitor();
        Visitor discountVisitor = new DiscountVisitor();

        System.out.println("原价：" + cart.accept(originalVisitor));
        System.out.println("折扣价：" + cart.accept(discountVisitor));
    }
}
