package src.com.gof23.c4factorymethod.framework;

/**
 * @program: GoF23
 * @description: 工厂类
 * @author: Cc.
 * @create: 2019-04-18 11:45
 **/
public abstract class Factory {
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    protected abstract Product createProduct(String owner);

    protected abstract void registerProduct(Product product);
}
