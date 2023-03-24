/**
 * 外观模式
 * 定义：为子系统中的一组接口提供一个一致的界面，此模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。
 * 类型：结构型
 *
 * 适用场景： 
 * 1. 当要为一个复杂子系统提供一个简单接口时可以使用外观模式。
 * 2. 客户端与多个子系统之间存在很大的依赖性。
 * 3. 在层次化结构中，需要定义系统中每一层的入口，使得层与层之间不直接产生联系。
 *
 * 优点：
 * 1. 简化了调用过程，无需了解深入子系统，防止带来风险。
 * 2. 减少了系统的相互依赖，提高了灵活性。
 * 3. 提高了安全性。
 *
 * 缺点：
 * 1. 不符合开闭原则，修改子系统的行为需要修改外观类或客户端的源代码。
 * 2. 不能很好地限制客户端直接使用子系统类。
 *
 * 结构：
 * Facade：外观角色，为多个子系统对外提供一个共同的接口。
 * SubSystem：子系统角色，实现系统的部分功能，客户可以通过外观角色访问它。
 *
 * 案例：
 * 以购物为例，客户端需要调用多个子系统的接口，如商品查询、库存查询、下单等，使用外观模式可以将这些接口封装在一个外观类中，客户端只需要调用外观类的接口即可完成购物流程。
 *
 * 代码实现：
 */
public class FacadePattern {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.method();
    }
}

/**
 * Facade：外观角色，为多个子系统对外提供一个共同的接口。
 */
class Facade {
    private SubSystem1 subSystem1 = new SubSystem1();
    private SubSystem2 subSystem2 = new SubSystem2();
    private SubSystem3 subSystem3 = new SubSystem3();

    public void method() {
        subSystem1.method1();
        subSystem2.method2();
        subSystem3.method3();
    }
}

/**
 * SubSystem：子系统角色，实现系统的部分功能，客户可以通过外观角色访问它。
 */
class SubSystem1 {
    public void method1() {
        System.out.println("子系统1的method1()被调用！");
    }
}

class SubSystem2 {
    public void method2() {
        System.out.println("子系统2的method2()被调用！");
    }
}

class SubSystem3 {
    public void method3() {
        System.out.println("子系统3的method3()被调用！");
    }
}
