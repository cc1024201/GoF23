/**
 * 建造者模式
 * 定义：将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
 * 类型：创建型
 *
 * 适用场景：
 * 1. 需要生成的对象具有复杂的内部结构
 * 2. 需要生成的对象内部属性本身相互依赖
 *
 * 优点：
 * 1. 封装性好，构建和表示分离
 * 2. 扩展性好，各个具体的建造者相互独立，有利于系统的解耦
 * 3. 客户端不必知道产品内部组成的细节，便于控制细节风险
 *
 * 缺点：
 * 1. 产生多余的Builder对象
 * 2. 产品内部发生变化，建造者都要修改，成本较大
 *
 * 结构：
 * 1. 抽象建造者（Builder）：创建一个Product对象的各个部件指定的抽象接口
 * 2. 具体建造者（ConcreteBuilder）：实现抽象接口，构建和装配各个部件
 * 3. 产品角色（Product）：要创建的复杂对象
 * 4. 指挥者（Director）：构建一个使用Builder接口的对象，指导构建过程
 *
 * 案例：
 * 假设我们要建造一座房子，房子有墙、屋顶、地板等组成部分，我们可以使用建造者模式来构建房子。
 * 代码实现：
 * 以建造一座房子为例，使用建造者模式来构建房子。
 */

// 产品角色
class House {
    private String wall;
    private String roof;
    private String floor;

    public void setWall(String wall) {
        this.wall = wall;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "House{" +
                "wall='" + wall + '\'' +
                ", roof='" + roof + '\'' +
                ", floor='" + floor + '\'' +
                '}';
    }
}

// 抽象建造者
abstract class HouseBuilder {
    protected House house = new House();

    public abstract void buildWall();

    public abstract void buildRoof();

    public abstract void buildFloor();

    public House buildHouse() {
        return house;
    }
}

// 具体建造者
class ConcreteHouseBuilder extends HouseBuilder {
    @Override
    public void buildWall() {
        house.setWall("建造墙");
    }

    @Override
    public void buildRoof() {
        house.setRoof("建造屋顶");
    }

    @Override
    public void buildFloor() {
        house.setFloor("建造地板");
    }
}

// 指挥者
class HouseDirector {
    private HouseBuilder houseBuilder;

    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House constructHouse() {
        houseBuilder.buildWall();
        houseBuilder.buildRoof();
        houseBuilder.buildFloor();
        return houseBuilder.buildHouse();
    }
}

public class BuilderPatternDemo {
    public static void main(String[] args) {
        HouseBuilder houseBuilder = new ConcreteHouseBuilder();
        HouseDirector houseDirector = new HouseDirector(houseBuilder);
        House house = houseDirector.constructHouse();
        System.out.println(house);
    }
}
