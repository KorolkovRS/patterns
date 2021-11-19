package creational.factory_method.factory;

import creational.factory_method.product.Product;
import creational.factory_method.product.ProductB;

public class ConcreteFactoryB extends AbstractFactory {
    @Override
    public Product createProduct() {
        System.out.println("Factory B creating product");
        return new ProductB();
    }
}
