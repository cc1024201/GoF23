package src.com.gof23.c12decorator2;

import java.util.ArrayList;

/**
 * @program: GoF23
 * @description: 可以显示多行字符串
 * @author: Cc.
 * @create: 2019-04-20 10:02
 **/
public class MultiStringDisplay extends Display {
    private ArrayList body = new ArrayList();
    private int columns = 0;
    public void add(String msg){
        body.add(msg);
        updateColumn(msg);
    }
    @Override
    public int getColumns() {
        return columns;
    }

    @Override
    public int getRows() {
        return body.size();
    }

    @Override
    public String getRowText(int row) {
        return (String) body.get(row);
    }
    private void updateColumn(String msg){
        if(msg.getBytes().length > columns){
            columns = msg.getBytes().length;
        }
        for(int row=0; row<body.size(); row++){
            int fills = columns - ((String)body.get(row)).getBytes().length;
            if(fills > 0){
                body.set(row, body.get(row) + spaces(fills));
            }
        }
    }
    private String spaces(int count){
        StringBuffer buffer = new StringBuffer();
        for(int i=0; i<count; i++){
            buffer.append(' ');
        }
        return buffer.toString();
    }
}
