package structural.bridge;

import java.util.ArrayList;
import java.util.List;

interface Drawer {
    void drawCircle(int x, int y, int radius);
}

class SmallCircleDrawer implements Drawer {
    private static double multiplier = 0.25;

    @Override
    public void drawCircle(int x, int y, int radius) {
        System.out.println("Small circle center = " + x + "," + y + " radius = " + radius * multiplier);
    }
}

class LargeCircleDriver implements Drawer {
    private static double multiplier = 5;

    @Override
    public void drawCircle(int x, int y, int radius) {
        System.out.println("Small circle center = " + x + "," + y + " radius = " + radius * multiplier);
    }
}

abstract class Shape {
    protected Drawer drawer;

    public Shape(Drawer drawer) {
        this.drawer = drawer;
    }

    public abstract void draw();
}

class Circle extends Shape {
    private int x;
    private int y;
    private int radius;

    public Circle(Drawer drawer, int x, int y, int radius) {
        super(drawer);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawer.drawCircle(x, y, radius);
    }
}

class Solution {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>(2);
        shapes.add(new Circle(new SmallCircleDrawer(), 0, 0, 10));
        shapes.add(new Circle(new LargeCircleDriver(), 0, 0, 10));
        for(Shape shape: shapes) {
            shape.draw();
        }

    }
}
