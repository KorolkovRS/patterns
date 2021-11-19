package creational.factory_method;

import creational.factory_method.factory.AbstractFactory;
import creational.factory_method.factory.ConcreteFactoryA;
import creational.factory_method.factory.ConcreteFactoryB;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<AbstractFactory> factories = new ArrayList<>();
        factories.add(new ConcreteFactoryA());
        factories.add(new ConcreteFactoryB());

        for(AbstractFactory factory : factories) {
            factory.createProduct();
        }
    }
}
