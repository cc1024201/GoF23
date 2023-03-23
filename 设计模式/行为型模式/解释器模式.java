/**
 * 解释器模式
 * 定义：给定一个语言，定义它的文法的一种表示，并定义一个解释器，该解释器使用该表示来解释语言中的句子。
 * 类型：行为型
 *
 * 适用场景：
 * 1.某个特定类型问题发生频率足够高
 * 2.优点：可扩展性、灵活性好
 *
 * 优点：
 * 1.可扩展性、灵活性好
 * 2.增加了新的解释表达式的方式
 * 3.易于实现文法
 *
 * 缺点：
 * 1.执行效率较低
 * 2.对于复杂的文法比较难维护
 * 3.会引起类膨胀
 *
 * 结构：
 * 1.抽象表达式（Expression）：声明一个所有的具体表达式角色都需要实现的抽象接口。
 * 2.终结符表达式（Terminal Expression）：实现与文法中的终结符相关联的解释操作。
 * 3.非终结符表达式（Nonterminal Expression）：为文法中的非终结符实现解释操作。
 * 4.环境（Context）：包含解释器之外的一些全局信息。
 *
 * 案例：
 * 以计算器为例，实现加减乘除四则运算
 * 代码实现：
 * 以计算器为例，实现加减乘除四则运算
 */
public class InterpreterPattern {
    public static void main(String[] args) {
        String expression = "3 * 2 * 4 / 6 + 8 - 1";
        Calculator calculator = new Calculator(expression);
        System.out.println(calculator.calculate());
    }
}

/**
 * 抽象表达式
 */
interface Expression {
    int interpret();

    void setNext(Expression next);
}

/**
 * 终结符表达式
 */
class TerminalExpression implements Expression {
    private final int value;

    public TerminalExpression(int value) {
        this.value = value;
    }

    @Override
    public int interpret() {
        return value;
    }

    @Override
    public void setNext(Expression next) {
        throw new UnsupportedOperationException();
    }
}

/**
 * 非终结符表达式
 */
abstract class NonterminalExpression implements Expression {
    protected Expression left;
    protected Expression right;

    public NonterminalExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void setNext(Expression next) {
        if (left == null) {
            left = next;
        } else {
            right = next;
        }
    }
}

/**
 * 加法表达式
 */
class AddExpression extends NonterminalExpression {
    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

/**
 * 减法表达式
 */
class SubtractExpression extends NonterminalExpression {
    public SubtractExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return left.interpret() - right.interpret();
    }
}

/**
 * 乘法表达式
 */
class MultiplyExpression extends NonterminalExpression {
    public MultiplyExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return left.interpret() * right.interpret();
    }
}

/**
 * 除法表达式
 */
class DivideExpression extends NonterminalExpression {
    public DivideExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return left.interpret() / right.interpret();
    }
}

/**
 * 环境
 */
class Calculator {
    private final Expression expression;

    public Calculator(String expression) {
        this.expression = build(expression);
    }

    private Expression build(String expression) {
        Stack<Expression> stack = new Stack<>();
        String[] elements = expression.split(" ");
        for (int i = 0; i < elements.length; i++) {
            String element = elements[i];
            if (isOperator(element)) {
                Expression right = stack.pop();
                Expression left = stack.pop();
                stack.push(buildExpression(element, left, right));
            } else {
                stack.push(new TerminalExpression(Integer.parseInt(element)));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String element) {
        return "+".equals(element) || "-".equals(element) || "*".equals(element) || "/".equals(element);
    }

    private NonterminalExpression buildExpression(String operator, Expression left, Expression right) {
        switch (operator) {
            case "+":
                return new AddExpression(left, right);
            case "-":
                return new SubtractExpression(left, right);
            case "*":
                return new MultiplyExpression(left, right);
            case "/":
                return new DivideExpression(left, right);
            default:
                throw new UnsupportedOperationException();
        }
    }

    public int calculate() {
        return expression.interpret();
    }
}
