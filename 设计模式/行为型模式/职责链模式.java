/**
 * 职责链模式
 * 定义：将请求的发送者和接收者解耦，使多个对象都有机会处理这个请求。将这些对象连成一条链，
 * 并沿着这条链传递该请求，直到有一个对象处理它为止。
 * 类型：行为型
 *
 * 适用场景：
 * 1. 有多个对象可以处理同一个请求，具体哪个对象处理该请求由运行时刻自动确定。
 * 2. 在不明确指定接收者的情况下，向多个对象中的一个提交一个请求。
 * 3. 可动态指定一组对象处理请求。
 *
 * 优点：
 * 1. 降低耦合度。它将请求的发送者和接收者解耦。
 * 2. 简化了对象。使得对象不需要知道链的结构。
 * 3. 增强了系统的可扩展性。可以增加新的请求处理类，满足开闭原则。
 * 4. 增强了给对象指派职责的灵活性。通过改变链内的成员或者调动它们的次序，
 * 允许动态地新增或者删除责任。
 * 5. 增加新的请求处理类很方便。
 *
 * 缺点：
 * 1. 不能保证请求一定被接收。
 * 2. 系统性能将受到一定影响，而且在进行代码调试时不太方便。
 * 3. 可能不容易观察运行时的特征，有碍于除错。
 *
 * 结构：
 * 1. 抽象处理者（Handler）角色：定义出一个处理请求的接口。如果需要，接口可以定义出一个方法
 * 以设定和返回对下家的引用。这个角色通常由一个Java抽象类或接口实现。
 * 2. 具体处理者（ConcreteHandler）角色：具体处理请求的角色。如果不能处理该请求，
 * 那么就把该请求转发给下一个节点上的处理者。这个角色通常由一个Java类实现。
 * 3. 客户端（Client）角色：提交请求的对象。
 *
 * 案例：
 * 请假审批流程
 *
 * 代码实现：
 * 以请假审批流程为例，实现职责链模式
 */
public class LeaveApprovalChain {
    public static void main(String[] args) {
        // 构造各个领导对象
        Leader director = new Director("张三");
        Leader manager = new Manager("李四");
        Leader generalManager = new GeneralManager("王五");

        // 设置各个责任链上的关系
        director.setNextLeader(manager);
        manager.setNextLeader(generalManager);

        // 构造请假条
        LeaveRequest request = new LeaveRequest("小明", 5, "回家探亲");

        // 提交请假条
        director.handleRequest(request);
    }
}

/**
 * 抽象处理者（Handler）角色
 */
abstract class Leader {
    protected String name;
    protected Leader nextLeader; // 责任链上的后继对象

    public Leader(String name) {
        this.name = name;
    }

    /**
     * 设定责任链上的后继对象
     */
    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    /**
     * 处理请求的核心业务方法
     */
    public abstract void handleRequest(LeaveRequest request);
}

/**
 * 具体处理者（ConcreteHandler）角色：主任
 */
class Director extends Leader {
    public Director(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() <= 3) {
            System.out.println("员工：" + request.getEmpName() + "请假，天数：" + request.getLeaveDays() + "，理由：" + request.getReason());
            System.out.println("主任：" + name + "审批通过");
        } else {
            if (nextLeader != null) {
                nextLeader.handleRequest(request);
            }
        }
    }
}

/**
 * 具体处理者（ConcreteHandler）角色：经理
 */
class Manager extends Leader {
    public Manager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() <= 10) {
            System.out.println("员工：" + request.getEmpName() + "请假，天数：" + request.getLeaveDays() + "，理由：" + request.getReason());
            System.out.println("经理：" + name + "审批通过");
        } else {
            if (nextLeader != null) {
                nextLeader.handleRequest(request);
            }
        }
    }
}

/**
 * 具体处理者（ConcreteHandler）角色：总经理
 */
class GeneralManager extends Leader {
    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() <= 30) {
            System.out.println("员工：" + request.getEmpName() + "请假，天数：" + request.getLeaveDays() + "，理由：" + request.getReason());
            System.out.println("总经理：" + name + "审批通过");
        } else {
            System.out.println("请假天数太多，不予批准");
        }
    }
}

/**
 * 请假条
 */
class LeaveRequest {
    private String empName; // 请假人姓名
    private int leaveDays; // 请假天数
    private String reason; // 请假理由

    public LeaveRequest(String empName, int leaveDays, String reason) {
        this.empName = empName;
        this.leaveDays = leaveDays;
        this.reason = reason;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(int leaveDays) {
        this.leaveDays = leaveDays;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
