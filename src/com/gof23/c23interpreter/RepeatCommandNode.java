package src.com.gof23.c23interpreter;

/**
 * @program: GoF23
 * @description: 对应<repeat command>的类
 * @author: Cc.
 * @create: 2019-04-21 14:19
 **/
//<repeat command> ::= repeat <number> <command list>
public class RepeatCommandNode extends Node{
    private int number;
    private Node commandListNode;
    @Override
    public void parse(Context context) throws ParseException{
        context.skipToken("repeat");
        number = context.currentNumber();
        context.nextToken();
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }
    @Override
    public String toString(){
        return "[repeat " + number + " " + commandListNode + "]";
    }
}
