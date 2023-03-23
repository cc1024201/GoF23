/**
 * 策略模式
 * 定义：定义一系列算法，把它们一个个封装起来，并且使它们可以相互替换。
 * 类型：行为型
 *
 * 适用场景：
 * 1. 一系列算法存在共性，即可以抽象为一个方法时。
 * 2. 多个类只有在算法或行为上稍有不同的场景。
 * 3. 算法需要自由切换的场景。
 *
 * 优点：
 * 1. 策略模式符合开闭原则。
 * 2. 避免使用多重条件判断。
 * 3. 提供算法的保密性和安全性。
 *
 * 缺点：
 * 1. 客户端必须知道所有的策略类，并自行决定使用哪一个策略类。
 * 2. 策略模式将造成产生很多策略类。
 *
 * 结构：
 * 1. 抽象策略类（Strategy）：定义了一个公共接口，各种不同的算法以不同的方式实现这个接口。
 * 2. 具体策略类（ConcreteStrategy）：实现了抽象策略定义的接口，提供具体的算法实现。
 * 3. 环境类（Context）：持有一个策略类的引用，最终给客户端调用。
 *
 * 案例：
 * 以商场打折为例，商场有多种打折方式，如无折扣、打九折、满100减20等，客户端可以根据需要选择不同的打折方式。
 * 代码实现：
 * 以商场打折为例，定义抽象策略类DiscountStrategy，具体策略类NoDiscountStrategy、Discount10Strategy、Discount20Strategy，环
 * 境类DiscountContext持有DiscountStrategy的引用，客户端通过DiscountContext调用不同的打折方式。
 */

/**
 * 抽象策略类
 */
interface DiscountStrategy {
    /**
     * 计算打折后的价格
     *
     * @param price 原价
     * @return 打折后的价格
     */
    double calculate(double price);
}

/**
 * 无折扣策略类
 */
class NoDiscountStrategy implements DiscountStrategy {
    @Override
    public double calculate(double price) {
        return price;
    }
}

/**
 * 九折策略类
 */
class Discount10Strategy implements DiscountStrategy {
    @Override
    public double calculate(double price) {
        return price * 0.9;
    }
}

/**
 * 满100减20策略类
 */
class Discount20Strategy implements DiscountStrategy {
    @Override
    public double calculate(double price) {
        return price >= 100 ? price - 20 : price;
    }
}

/**
 * 环境类
 */
class DiscountContext {
    private DiscountStrategy strategy;

    public DiscountContext(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 计算打折后的价格
     *
     * @param price 原价
     * @return 打折后的价格
     */
    public double calculate(double price) {
        return strategy.calculate(price);
    }
}

public class StrategyPatternDemo {
    public static void main(String[] args) {
        DiscountContext context;

        // 无折扣
        context = new DiscountContext(new NoDiscountStrategy());
        System.out.println("无折扣：" + context.calculate(100));

        // 九折
        context = new DiscountContext(new Discount10Strategy());
        System.out.println("九折：" + context.calculate(100));

        // 满100减20
        context = new DiscountContext(new Discount20Strategy());
        System.out.println("满100减20：" + context.calculate(100));
    }
}
