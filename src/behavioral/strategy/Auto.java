package behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

abstract class Auto {
    private FillBehavior fillBehavior;

    public Auto(FillBehavior fillBehavior) {
        this.fillBehavior = fillBehavior;
    }

    public void accelerate() {
        System.out.println("Accelerate");
    }
    public void stop() {
        System.out.println("Break");
    }
    public void fill() {
        fillBehavior.fill();
    }
}

@FunctionalInterface
interface FillBehavior {
    void fill();
}

class DieselAuto extends Auto {
    public DieselAuto(FillBehavior fillBehavior) {
        super(fillBehavior);
    }
}

class GasolineAuto extends Auto {
    public GasolineAuto(FillBehavior fillBehavior) {
        super(fillBehavior);
    }
}

class ElectricalAuto extends Auto {
    public ElectricalAuto(FillBehavior fillBehavior) {
        super(fillBehavior);
    }
}

class MuscleAuto extends Auto {
    public MuscleAuto(FillBehavior fillBehavior) {
        super(fillBehavior);
    }
}

class DieselCarFillBehavior implements FillBehavior {

    @Override
    public void fill() {
        System.out.println("Fill diesel");
    }
}

class GasolineCarFillBehavior implements FillBehavior {

    @Override
    public void fill() {
        System.out.println("Fill Gasoline");
    }
}

class ElectricalCarFillBehavior implements FillBehavior {

    @Override
    public void fill() {
        System.out.println("Charge");
    }
}

class Solution {
    public static void main(String[] args) {
        List<Auto> cars = new ArrayList<>();
        cars.add(new DieselAuto(new DieselCarFillBehavior()));
        cars.add(new ElectricalAuto(new ElectricalCarFillBehavior()));
        cars.add(new MuscleAuto(() -> System.out.println("Davi!")));

        cars.stream().forEach(Auto::fill);
    }
}
