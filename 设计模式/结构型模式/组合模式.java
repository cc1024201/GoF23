/**
 * 组合模式
 * 定义：将对象组合成树形结构以表示“部分-整体”的层次结构，使得用户对单个对象和组合对象的使用具有一致性。
 * 类型：结构型
 *
 * 适用场景：
 * 1. 希望客户端可以忽略组合对象与单个对象的差异时
 * 2. 处理树形结构时
 *
 * 优点：
 * 1. 清楚地定义分层次的复杂对象，表示对象的全部或部分层次
 * 2. 让客户端代码更加简单，忽略了层次的差异，方便对整个层次结构进行控制和管理
 * 3. 符合开闭原则，增加新的容器构件和叶子构件都很方便
 *
 * 缺点：
 * 1. 设计较复杂，需要正确地识别出容器构件和叶子构件
 * 2. 不容易限制容器中的构件
 *
 * 结构：
 * 1. 抽象构件（Component）：定义叶子和容器构件的共同点
 * 2. 叶子构件（Leaf）：无子节点
 * 3. 容器构件（Composite）：有容器特征，可以包含子节点
 *
 * 案例：
 * 以公司组织架构为例，公司由多个部门组成，每个部门又由多个员工组成，员工可以是叶子节点，部门可以是容器节点。
 * 代码实现：
 * 以公司组织架构为例，实现一个简单的组合模式。
 */
public class CompositePattern {
    public static void main(String[] args) {
        // 创建公司
        Company company = new ConcreteCompany("ABC公司");
        // 创建部门
        Department department1 = new ConcreteDepartment("技术部");
        Department department2 = new ConcreteDepartment("市场部");
        // 创建员工
        Employee employee1 = new Employee("张三");
        Employee employee2 = new Employee("李四");
        Employee employee3 = new Employee("王五");
        Employee employee4 = new Employee("赵六");
        // 将员工添加到部门中
        department1.add(employee1);
        department1.add(employee2);
        department2.add(employee3);
        department2.add(employee4);
        // 将部门添加到公司中
        company.add(department1);
        company.add(department2);
        // 显示公司组织架构
        company.display(0);
    }
}

/**
 * 抽象构件：公司、部门、员工
 */
interface Component {
    void add(Component component);
    void remove(Component component);
    void display(int depth);
}

/**
 * 具体构件：公司
 */
class ConcreteCompany implements Component {
    private String name;
    private List<Component> children = new ArrayList<>();

    public ConcreteCompany(String name) {
        this.name = name;
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void display(int depth) {
        System.out.println(String.join("", Collections.nCopies(depth, "-")) + name);
        for (Component component : children) {
            component.display(depth + 2);
        }
    }
}

/**
 * 具体构件：部门
 */
class ConcreteDepartment implements Component {
    private String name;
    private List<Component> children = new ArrayList<>();

    public ConcreteDepartment(String name) {
        this.name = name;
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void display(int depth) {
        System.out.println(String.join("", Collections.nCopies(depth, "-")) + name);
        for (Component component : children) {
            component.display(depth + 2);
        }
    }
}

/**
 * 具体构件：员工
 */
class Employee implements Component {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void display(int depth) {
        System.out.println(String.join("", Collections.nCopies(depth, "-")) + name);
    }
}
