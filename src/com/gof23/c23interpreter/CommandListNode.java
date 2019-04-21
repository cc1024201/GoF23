package src.com.gof23.c23interpreter;

import java.util.ArrayList;

/**
 * @program: GoF23
 * @description: 对应<command list>的类
 * @author: Cc.
 * @create: 2019-04-21 14:04
 **/
//<command list> ::= <command>* end
public class CommandListNode extends Node{
    private ArrayList list = new ArrayList();
    @Override
    public void parse(Context context) throws ParseException {
        while(true){
            if(context.currentToken() == null){
                throw new ParseException("Missing 'end'");
            }else if(context.currentToken().equals("end")){
                context.skipToken("end");
                break;
            }else{
                Node commandNode = new CommandNode();
                commandNode.parse(context);
                list.add(commandNode);
            }
        }
    }
    @Override
    public String toString(){
        return list.toString();
    }
}
