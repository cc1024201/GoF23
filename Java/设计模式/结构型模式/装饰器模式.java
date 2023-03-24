/**
 * 装饰器模式
 * 定义：在不改变原有对象的基础上，将功能附加到对象上，提供了比继承更有弹性的替代方案（扩展原有对象功能）
 * 类型：结构型
 *
 * 适用场景：
 * 1. 扩展一个类的功能或给一个类添加附加职责
 * 2. 动态的给一个对象添加功能，这些功能可以再动态的撤销
 *
 * 优点：
 * 1. 装饰器是继承的有力补充，比继承灵活，不会导致类个数急剧增加
 * 2. 可以通过一种动态的方式来扩展一个对象的功能，通过配置文件可以在运行时选择不同的装饰器，从而实现不同的行为
 * 3. 通过使用不同的装饰类及这些装饰类的排列组合，可以实现不同的效果
 * 4. 装饰器模式完全遵守开闭原则
 *
 * 缺点：
 * 1. 装饰器模式会增加许多小对象的数量，过度使用会增加程序的复杂性
 * 2. 装饰器模式比继承更加灵活，但是多次装饰后的对象比较复杂
 *
 * 结构：
 * 1. 抽象构件(Component)角色：定义一个抽象接口以规范准备接收附加责任的对象
 * 2. 具体构件(ConcreteComponent)角色：实现抽象构件，通过装饰角色为其添加一些职责
 * 3. 抽象装饰(Decorator)角色：实现抽象构件，并包含一个抽象构件的实例，可以通过其子类扩展该抽象构件的功能
 * 4. 具体装饰(ConcreteDecorator)角色：实现抽象装饰的相关方法，并给具体构件对象添加附加的责任
 *
 * 案例：
 * 以咖啡为例，可以加入各种调料，如牛奶、糖、巧克力等，而每种调料都有不同的价格，可以通过装饰器模式来实现。
 *
 * 代码实现：
 * 以咖啡为例，可以加入各种调料，如牛奶、糖、巧克力等，而每种调料都有不同的价格，可以通过装饰器模式来实现。
 * 具体实现请参考下方代码：
 */

/**
 * 抽象构件
 */
interface Drink {
    /**
     * 获取价格
     *
     * @return
     */
    double cost();

    /**
     * 获取描述
     *
     * @return
     */
    String getDescription();
}

/**
 * 具体构件
 */
class Coffee implements Drink {
    @Override
    public double cost() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "咖啡";
    }
}

/**
 * 抽象装饰
 */
abstract class Decorator implements Drink {
    private Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public double cost() {
        return drink.cost();
    }

    @Override
    public String getDescription() {
        return drink.getDescription();
    }
}

/**
 * 具体装饰
 */
class Milk extends Decorator {
    public Milk(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost() + 2;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "加牛奶";
    }
}

class Sugar extends Decorator {
    public Sugar(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost() + 1;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "加糖";
    }
}

class Chocolate extends Decorator {
    public Chocolate(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost() + 3;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "加巧克力";
    }
}

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Drink coffee = new Coffee();
        System.out.println(coffee.getDescription() + " 价格：" + coffee.cost());

        Drink milkCoffee = new Milk(coffee);
        System.out.println(milkCoffee.getDescription() + " 价格：" + milkCoffee.cost());

        Drink sugarCoffee = new Sugar(coffee);
        System.out.println(sugarCoffee.getDescription() + " 价格：" + sugarCoffee.cost());

        Drink chocolateCoffee = new Chocolate(coffee);
        System.out.println(chocolateCoffee.getDescription() + " 价格：" + chocolateCoffee.cost());

        Drink milkSugarCoffee = new Milk(new Sugar(coffee));
        System.out.println(milkSugarCoffee.getDescription() + " 价格：" + milkSugarCoffee.cost());

        Drink milkSugarChocolateCoffee = new Milk(new Sugar(new Chocolate(coffee)));
        System.out.println(milkSugarChocolateCoffee.getDescription() + " 价格：" + milkSugarChocolateCoffee.cost());
    }
}
