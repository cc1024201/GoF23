package src.com.gof23.c12decorator2;

/**
 * @program: GoF23
 * @description: 上下边框
 * @author: Cc.
 * @create: 2019-04-20 09:55
 **/
public class UpDownBorder extends Border {
    private char borderChar;

    public UpDownBorder(Display display, char borderChar) {
        super(display);
        this.borderChar = borderChar;
    }

    @Override
    public int getColumns() {
        return display.getColumns();
    }

    @Override
    public int getRows() {
        return 1+display.getRows()+1;
    }

    @Override
    public String getRowText(int row) {
        if(row == 0 || row == getRows()-1){
            return makeLine(borderChar, getColumns());
        }else{
            return display.getRowText(row - 1);
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
