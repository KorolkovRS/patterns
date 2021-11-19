package creational.builder;

import java.util.ArrayList;
import java.util.List;

public class Burger {
    private Bun bun;
    private Cutlet cutlet;
    private List<Vegetable> vegetables;
    private List<Souse> souses;

    public Burger() {
        this.vegetables = new ArrayList<>();
        this.souses = new ArrayList<>();
    }

    public void setBun(Bun bun) throws IllegalArgumentException {
        this.bun = bun;
    }

    public void setCutlet(Cutlet cutlet) throws IllegalArgumentException {
        this.cutlet = cutlet;
    }

    public void setVegetable(Vegetable vegetable) throws IllegalArgumentException {
        this.vegetables.add(vegetable);
    }

    public void setSouse(Souse souse) throws IllegalArgumentException {
        this.souses.add(souse);
    }

    public enum Bun {
        WHITE_BUN,
        BLACK_BUN,
        CHEESE_BUN
    }

    public enum Cutlet {
        MEET,
        CHICKEN,
        FISH
    }

    public enum Vegetable {
        TOMATO,
        LETTUCE,
        ONION,
        CUCUMBER
    }

    public enum Souse {
        TOMATO,
        CHEESE,
        BBQ
    }

    @Override
    public String toString() {
        return "Burger{" +
                "bun=" + bun +
                ", cutlet=" + cutlet +
                ", vegetables=" + vegetables +
                ", souses=" + souses +
                '}';
    }
}
