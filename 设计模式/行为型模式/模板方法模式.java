/**
 * 模板方法模式
 * 定义：定义一个操作中的算法骨架，而将一些步骤延迟到子类中。模板方法使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
 * 类型：行为型
 *
 * 适用场景：
 * 1. 一次性实现一个算法的不变部分，并将可变的行为留给子类来实现。
 * 2. 各子类中公共的行为被提取出来并集中到一个公共父类中，从而避免代码重复。
 * 3. 控制子类扩展。
 *
 * 优点：
 * 1. 提高代码复用性。
 * 2. 提高扩展性。
 * 3. 符合开闭原则。
 *
 * 缺点：
 * 1. 模板方法会带来代码阅读的难度，会让用户觉得难以理解。
 * 2. 模板方法会在一定程度上限制子类的灵活性。
 *
 * 结构：
 * 1. 抽象类(AbstractClass)：定义抽象的基本操作和模板方法。
 * 2. 具体类(ConcreteClass)：实现抽象类中的基本操作，完成具体业务逻辑。
 *
 * 案例：
 * 制作咖啡和茶的过程中，都有相同的步骤，如加热水、加入调料等，但是具体的实现不同，可以使用模板方法模式。
 * 代码实现：
 * 以制作咖啡为例，实现模板方法模式，具体步骤如下：
 * 1. 定义抽象类，包含模板方法和基本操作方法。
 * 2. 定义具体类，实现基本操作方法。
 * 3. 在具体类中实现模板方法，调用基本操作方法。
 * 4. 编写测试用例，验证模板方法模式的正确性。
 */

/**
 * 抽象类，包含模板方法和基本操作方法
 */
abstract class AbstractClass {
    /**
     * 模板方法，定义算法骨架
     */
    public final void templateMethod() {
        // 步骤1
        step1();
        // 步骤2
        step2();
        // 步骤3
        step3();
    }

    /**
     * 基本操作方法1
     */
    protected abstract void step1();

    /**
     * 基本操作方法2
     */
    protected abstract void step2();

    /**
     * 基本操作方法3
     */
    protected abstract void step3();
}

/**
 * 具体类，实现基本操作方法
 */
class ConcreteClass extends AbstractClass {
    @Override
    protected void step1() {
        System.out.println("ConcreteClass.step1");
    }

    @Override
    protected void step2() {
        System.out.println("ConcreteClass.step2");
    }

    @Override
    protected void step3() {
        System.out.println("ConcreteClass.step3");
    }
}

/**
 * 测试用例
 */
public class TemplateMethodPatternDemo {
    public static void main(String[] args) {
        AbstractClass abstractClass = new ConcreteClass();
        abstractClass.templateMethod();
    }
}
