package src.com.gof23.c12decorator;

/**
 * @program: GoF23
 * @description: 一种具体的装饰边框
 * @author: Cc.
 * @create: 2019-04-20 09:16
 **/
public class SideBorder extends Border {
    private char borderChar;    //表示装饰边框的字符

    public SideBorder(Display display, char borderChar) {
        super(display);
        this.borderChar = borderChar;
    }

    @Override
    public int getColumns() {
        return 1+display.getColumns()+1;
    }

    @Override
    public int getRows() {
        return display.getRows();
    }

    @Override
    public String getRowText(int row) {
        return borderChar + display.getRowText(row) + borderChar;
    }
}
