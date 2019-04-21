package src.com.gof23.c23interpreter;

/**
 * @program: GoF23
 * @description: 对应<primitive command>的类
 * @author: Cc.
 * @create: 2019-04-21 14:20
 **/
//<primitive command> ::= go | right | left
public class PrimitiveCommandNode extends Node{
    private String name;
    @Override
    public void parse(Context context) throws ParseException{
        name = context.currentToken();
        context.skipToken(name);
        if(!name.equals("go") && !name.equals("right") && !name.equals("left")){
            throw new ParseException(name + " is undefined");
        }
    }
    @Override
    public String toString(){
        return name;
    }
}
