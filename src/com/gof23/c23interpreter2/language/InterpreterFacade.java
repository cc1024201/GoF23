package src.com.gof23.c23interpreter2.language;

/**
 * @program: GoF23
 * @description: 使解释器更好用的类
 * @author: Cc.
 * @create: 2019-04-21 14:47
 **/
public class InterpreterFacade implements Executor{
    private ExecutorFactory factory;
    private Context context;
    private Node programNode;

    public InterpreterFacade(ExecutorFactory factory) {
        this.factory = factory;
    }

    public boolean parse(String text){
        boolean ok = true;
        this.context = new Context(text);
        this.context.setExecutorFactory(factory);
        this.programNode = new ProgramNode();
        try {
            programNode.parse(context);
            System.out.println(programNode.toString());
        } catch (ParseException e) {
            e.printStackTrace();
            ok = false;
        }
        return ok;
    }
    @Override
    public void execute() throws ExecuteException {
        try {
            programNode.execute();
        } catch (ExecuteException e) {
            e.printStackTrace();
        }
    }
}
