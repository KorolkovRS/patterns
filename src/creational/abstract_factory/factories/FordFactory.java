package creational.abstract_factory.factories;

import creational.abstract_factory.cars.*;

public class FordFactory implements CarsFactory {
    @Override
    public Sedan createSedan() {
        System.out.println("Ford factory create Ford sedan");
        return new FordSedan();
    }

    @Override
    public Coupe createCoupe() {
        System.out.println("Ford factory create Ford coupe");
        return new FordCoupe();
    }
}
