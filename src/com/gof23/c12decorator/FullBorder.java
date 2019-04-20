package src.com.gof23.c12decorator;

/**
 * @program: GoF23
 * @description: 会在字符串上下左右加上装饰边框的类
 * @author: Cc.
 * @create: 2019-04-20 09:21
 **/
public class FullBorder extends Border {
    public FullBorder(Display display) {
        super(display);
    }

    @Override
    public int getColumns() {
        return 1+display.getColumns()+1;
    }

    @Override
    public int getRows() {
        return 1+display.getRows()+1;
    }

    @Override
    public String getRowText(int row) {
        if(row == 0){
            return "+" + makeLine('-', display.getColumns()) + "+";
        }else if(row == display.getRows() + 1){
            return "+" + makeLine('-', display.getColumns()) + "+";
        }else{
            return "|" + display.getRowText(row-1) + "|";
        }
    }
    private String makeLine(char ch, int count){
        StringBuffer buffer = new StringBuffer();
        for(int i=0; i<count; i++){
            buffer.append(ch);
        }
        return buffer.toString();
    }
}
