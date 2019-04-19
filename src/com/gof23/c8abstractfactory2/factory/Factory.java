package src.com.gof23.c8abstractfactory2.factory;

/**
 * @program: GoF23
 * @description: 抽象的工厂：Factory类
 * @author: Cc.
 * @create: 2019-04-18 21:44
 **/
public abstract class Factory {
    public static Factory getFactory(String classname) {
        Factory factory = null;
        try {
            factory = (Factory) Class.forName(classname).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("没有找到" + classname + "类。");
        }
        return factory;
    }

    public abstract Link createLink(String caption, String url);

    public abstract Tray createTray(String caption);

    public abstract Page createPage(String title, String author);

    public Page createYahooPage(){
        Link link = createLink("Yahoo!", "http://www.yahoo.com/");
        Page page = createPage("Yahoo!", "Yahoo!");
        page.add(link);
        return page;
    }
}
