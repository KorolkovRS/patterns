package creational.abstract_factory.factories;

import creational.abstract_factory.cars.Coupe;
import creational.abstract_factory.cars.KIACoupe;
import creational.abstract_factory.cars.KIASedan;
import creational.abstract_factory.cars.Sedan;

public class KIAFactory implements CarsFactory {
    @Override
    public Sedan createSedan() {
        System.out.println("KIA factory create KIA sedan");
        return new KIASedan();
    }

    @Override
    public Coupe createCoupe() {
        System.out.println("KIA factory create KIA coupe");
        return new KIACoupe();
    }
}
