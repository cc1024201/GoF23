package src.com.gof23.c14chainofresponsibility;

/**
 * @program: GoF23
 * @description: 解决问题的抽象类
 * @author: Cc.
 * @create: 2019-04-20 11:39
 **/
public abstract class Support {
    private String name;    //解决问题的实例的名字
    private Support next;   //要推卸给的对象

    public Support(String name) {   //生成解决问题的实例
        this.name = name;
    }

    public Support setNext(Support next){   //设置要推卸给的对象
        this.next = next;
        return next;
    }

    public final void support(Trouble trouble){ //解决问题的步骤
        if (resolve(trouble)) {
            done(trouble);
        }else if(next != null){
            next.support(trouble);
        }else{
            fail(trouble);
        }
    }

    @Override
    public String toString() {
        return "Support{" +
                "name='" + name + '\'' +
                '}';
    }

    protected abstract boolean resolve(Trouble trouble);    //解决问题的方法
    protected void done(Trouble trouble){   //解决
        System.out.println(trouble + "is resolved by" + this + ".");
    }
    protected void fail(Trouble trouble){   //未解决
        System.out.println(trouble + "cannot be resolved.");
    }
}
