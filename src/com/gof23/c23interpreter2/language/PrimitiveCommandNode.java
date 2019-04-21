package src.com.gof23.c23interpreter2.language;

/**
 * @program: GoF23
 * @description: 对应<primitive command>的类
 * @author: Cc.
 * @create: 2019-04-21 14:20
 **/
//<primitive command> ::= go | right | left
public class PrimitiveCommandNode extends Node {
    private String name;
    private Executor executor;
    @Override
    public void parse(Context context) throws ParseException {
        name = context.currentToken();
        context.skipToken(name);
        executor = context.createExecutor(name);
    }
    @Override
    public String toString(){
        return name;
    }

    @Override
    public void execute() throws ExecuteException {
        if(executor == null){
            throw new ExecuteException(name + ": is not difined");
        }else{
            executor.execute();
        }
    }
}
