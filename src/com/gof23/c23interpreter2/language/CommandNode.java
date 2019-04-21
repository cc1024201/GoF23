package src.com.gof23.c23interpreter2.language;

/**
 * @program: GoF23
 * @description: 对应<command>的类
 * @author: Cc.
 * @create: 2019-04-21 14:15
 **/
//<command> ::= <repat command> | <primitive command>
public class CommandNode extends Node{
    private Node node;
    @Override
    public void parse(Context context) throws ParseException {
        if(context.currentToken().equals("repeat")){
            node = new RepeatCommandNode();
            node.parse(context);
        }else{
            node = new PrimitiveCommandNode();
            node.parse(context);
        }
    }
    @Override
    public String toString(){
        return node.toString();
    }

    @Override
    public void execute() throws ExecuteException {
        node.execute();
    }
}
