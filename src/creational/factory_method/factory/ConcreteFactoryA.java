package creational.factory_method.factory;

import creational.factory_method.product.Product;
import creational.factory_method.product.ProductA;

public class ConcreteFactoryA extends AbstractFactory {
    @Override
    public Product createProduct() {
        System.out.println("Factory A creating product");
        return new ProductA();
    }
}
