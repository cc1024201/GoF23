/**
 * 原型模式
 * 定义：用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
 * 类型：创建型
 *
 * 适用场景：
 * 1. 类初始化消耗较多资源
 * 2. new产生的一个对象需要非常繁琐的过程（数据准备、访问权限等）
 * 3. 构造函数比较复杂
 * 4. 循环体中生产大量对象时
 *
 * 优点：
 * 1. 原型模式性能优良，由于是内存中拷贝，所以比直接new一个对象性能好很多
 * 2. 隐藏了制造新实例的复杂性，使得创建对象就像我们在编辑文档时的复制粘贴一样简单
 *
 * 缺点：
 * 1. 需要为每一个类配备一个克隆方法，而且该克隆方法位于一个类的内部，当对已有的类进行改造时违背“开闭原则”
 * 2. 在实现深克隆时需要编写较为复杂的代码，而且当对象之间存在多重的嵌套引用时，为了实现深克隆，每一层对象对应的类都必须支持深克隆，实现起来会比较麻烦。
 *
 * 结构：
 * 1. 抽象原型类：规定了具体原型对象必须实现的接口。
 * 2. 具体原型类：实现抽象原型类的 clone() 方法，它是可被复制的对象。
 * 3. 访问类：使用具体原型类中的 clone() 方法来复制新的对象。
 *
 * 案例：
 * 以简历为例，通过原型模式实现简历的复制
 */

/**
 * 简历类
 */
class Resume implements Cloneable {
    private String name;
    private String gender;
    private String age;
    private String timeArea;
    private String company;

    public Resume(String name) {
        this.name = name;
    }

    /**
     * 设置个人信息
     *
     * @param gender 性别
     * @param age    年龄
     */
    public void setPersonInfo(String gender, String age) {
        this.gender = gender;
        this.age = age;
    }

    /**
     * 设置工作经历
     *
     * @param timeArea 工作年限
     * @param company  所在公司
     */
    public void setWorkExperience(String timeArea, String company) {
        this.timeArea = timeArea;
        this.company = company;
    }

    /**
     * 显示
     */
    public void display() {
        System.out.println(name + " " + gender + " " + age);
        System.out.println("工作经历：" + timeArea + " " + company);
    }

    /**
     * 克隆该实例
     *
     * @return 克隆后的实例
     */
    @Override
    public Object clone() {
        Resume resume = null;
        try {
            resume = (Resume) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return resume;
    }
}

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
        Resume a = new Resume("张三");
        a.setPersonInfo("男", "29");
        a.setWorkExperience("2010-2014", "XX公司");

        Resume b = (Resume) a.clone();
        b.setWorkExperience("2014-2017", "YY企业");

        Resume c = (Resume) a.clone();
        c.setPersonInfo("男", "24");

        a.display();
        b.display();
        c.display();
    }
}
