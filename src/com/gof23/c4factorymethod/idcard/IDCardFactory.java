package src.com.gof23.c4factorymethod.idcard;

import src.com.gof23.c4factorymethod.framework.Factory;
import src.com.gof23.c4factorymethod.framework.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: GoF23
 * @description: Factory的子类
 * @author: Cc.
 * @create: 2019-04-18 11:51
 **/
public class IDCardFactory extends Factory {
    private List owners = new ArrayList();
    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        owners.add(((IDCard)product).getOwner());
    }
    public List getOwners(){
        return owners;
    }
}
