package src.com.gof23.c23interpreter;

import java.util.StringTokenizer;

/**
 * @program: GoF23
 * @description: 表示语法解析上下文的类
 * @author: Cc.
 * @create: 2019-04-21 13:50
 **/
public class Context {
    private StringTokenizer tokenizer;
    private String currentToken;
    public Context(String text){
        tokenizer = new StringTokenizer(text);
        nextToken();
    }
    public String nextToken(){
        if(tokenizer.hasMoreTokens()){
            currentToken = tokenizer.nextToken();
        }else{
            currentToken = null;
        }
        return currentToken;
    }
    public String currentToken(){
        return currentToken;
    }
    public void skipToken(String token) throws ParseException{
        if(!token.equals(currentToken)){
            throw new ParseException("Warning:" + token + " is expected, but " + currentToken + " is found.");
        }
        nextToken();
    }
    public int currentNumber() throws ParseException{
        int number = 0;

        try {
            number = Integer.parseInt(currentToken);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return number;
    }
}
