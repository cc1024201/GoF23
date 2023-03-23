/**
 * 备忘录模式
 * 定义：在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态，以便之后恢复对象的状态。
 * 类型：行为型
 *
 * 适用场景：
 * 1. 需要保存和恢复数据的相关状态场景。
 * 2. 提供一个可回滚的操作。
 * 3. 需要监控的副本场景中。
 *
 * 优点：
 * 1. 提供一种状态恢复的机制。
 * 2. 实现了信息的封装，使得用户不需要关心状态的保存细节。
 *
 * 缺点：
 * 1. 资源消耗大，如果类的成员变量过多，势必会占用比较大的资源。
 * 2. 由于需要保存历史状态，因此类的实现会增加程序的复杂度。
 *
 * 结构：
 * 1. 发起人（Originator）角色：记录当前时刻的内部状态，并负责创建和恢复备忘录数据。
 * 2. 备忘录（Memento）角色：负责存储发起人的内部状态，在需要的时候提供这些内部状态给发起人。
 * 3. 管理者（Caretaker）角色：对备忘录进行管理，提供保存与获取备忘录的功能，但其不能对备忘录的内容进行访问与修改。
 *
 * 案例：
 * 以游戏存档为例，游戏中有多个关卡，每个关卡都有不同的状态，玩家可以在任意关卡进行存档，也可以在任意关卡进行读档。
 * 代码实现：
 * 以游戏存档为例，实现游戏存档和读档
 */
public class MementoPattern {
    public static void main(String[] args) {
        // 创建游戏对象
        Game game = new Game();
        // 打通第一关
        game.play();
        // 存档
        Memento memento = game.save();
        // 打通第二关
        game.play();
        // 读档
        game.load(memento);
    }
}

/**
 * 发起人角色
 */
class Game {
    private int level = 1;

    /**
     * 打通关卡
     */
    public void play() {
        System.out.println("打通第" + level + "关");
        level++;
    }

    /**
     * 存档
     *
     * @return
     */
    public Memento save() {
        return new Memento(level);
    }

    /**
     * 读档
     *
     * @param memento
     */
    public void load(Memento memento) {
        level = memento.getLevel();
        System.out.println("读取存档，当前关卡为：" + level);
    }
}

/**
 * 备忘录角色
 */
class Memento {
    private int level;

    public Memento(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
