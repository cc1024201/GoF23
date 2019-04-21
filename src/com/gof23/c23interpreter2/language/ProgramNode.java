package src.com.gof23.c23interpreter2.language;

/**
 * @program: GoF23
 * @description: 对应<program>的类
 * @author: Cc.
 * @create: 2019-04-21 13:40
 **/
//<program> ::= program <command list>
public class ProgramNode extends Node {
    private Node commandListNode;
    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("program");
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }
    @Override
    public String toString(){
        return "[program " + commandListNode + "]";
    }

    @Override
    public void execute() throws ExecuteException {
        commandListNode.execute();
    }
}
