package src.com.gof23.c12decorator2;

/**
 * @program: GoF23
 * @description: 显示单行字符串的类
 * @author: Cc.
 * @create: 2019-04-20 09:05
 **/
public class StringDisplay extends Display {
    private String string;  //要显示的字符串

    public StringDisplay(String string) {
        this.string = string;
    }

    @Override
    public int getColumns() {
        return string.getBytes().length;
    }

    @Override
    public int getRows() {
        return 1;
    }

    @Override
    public String getRowText(int row) {     //仅当row为0时返回值
        if(row == 0){
            return string;
        }else{
            return null;
        }
    }
}
