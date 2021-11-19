package creational.abstract_factory;

import creational.abstract_factory.factories.CarsFactory;
import creational.abstract_factory.factories.FordFactory;
import creational.abstract_factory.factories.KIAFactory;

public class Solution {
    public static void main(String[] args) {
        CarsFactory factory = new FordFactory();
        factory.createCoupe();
        factory.createSedan();
        factory = new KIAFactory();
        factory.createCoupe();
        factory.createSedan();
    }
}
