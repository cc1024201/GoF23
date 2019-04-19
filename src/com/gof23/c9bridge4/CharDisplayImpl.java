package src.com.gof23.c9bridge4;

/**
 * @program: GoF23
 * @description: 表示以字符显示的”实现上“的类
 * @author: Cc.
 * @create: 2019-04-19 13:54
 **/
public class CharDisplayImpl extends DisplayImpl {
    private char head;
    private char body;
    private char foot;

    public CharDisplayImpl(char head, char body, char foot) {
        this.head = head;
        this.body = body;
        this.foot = foot;
    }

    @Override
    public void rawOpen() {
        System.out.print(head);
    }

    @Override
    public void rawPrint() {
        System.out.print(body);
    }

    @Override
    public void rawClose() {
        System.out.println(foot);
    }
}
