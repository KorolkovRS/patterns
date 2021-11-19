package structural.composite;

import java.util.ArrayList;
import java.util.List;

interface Graphic {
    void draw();
}

class CompositeGraphic implements Graphic {
    private List<Graphic> graphics = new ArrayList<>();

    @Override
    public void draw() {
        for(Graphic graphic: graphics) {
            graphic.draw();
        }
    }

    public void add(Graphic graphic) {
        graphics.add(graphic);
    }

    public void remove(Graphic graphic) {
        graphics.remove(graphic);
    }
}

class Circle implements Graphic {
    private int x;
    private int y;
    private int radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle center = " + x + "," + y + " radius = " + radius);
    }
}

class Square implements Graphic {
    private int x;
    private int y;
    private int side;

    public Square(int x, int y, int side) {
        this.x = x;
        this.y = y;
        this.side = side;
    }

    @Override
    public void draw() {
        System.out.println("Square center = " + x + "," + y + " side = " + side);
    }
}

class Solution {
    public static void main(String[] args) {
        CompositeGraphic compositeGraphic = new CompositeGraphic();
        compositeGraphic.add(new Circle(0, 0,10));
        compositeGraphic.add(new Circle(0, 0,3));
        compositeGraphic.add(new Circle(0, 5,5));
        compositeGraphic.add(new Square(0, 0,5));

        compositeGraphic.draw();
    }
}


