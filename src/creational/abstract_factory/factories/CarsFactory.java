package creational.abstract_factory.factories;

import creational.abstract_factory.cars.Coupe;
import creational.abstract_factory.cars.Sedan;

public interface CarsFactory {
    Sedan createSedan();
    Coupe createCoupe();
}
