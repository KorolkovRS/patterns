package structural.flyweight;

import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

abstract class Shape {
    private final int color;

    public Shape(int color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return color == shape.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }
}

final class Circle extends Shape {
    private final int x = 0;
    private final int y = 0;
    private final int radius = 10;

    public Circle(int color) {
        super(color);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return x == circle.x && y == circle.y && radius == circle.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), x, y, radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                '}';
    }
}

final class Square extends Shape {
    private final int x = 0;
    private final int y = 0;
    private final int side = 5;

    public Square(int color) {
        super(color);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Square square = (Square) o;
        return x == square.x && y == square.y && side == square.side;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), x, y, side);
    }

    @Override
    public String toString() {
        return "Square{" +
                "x=" + x +
                ", y=" + y +
                ", side=" + side +
                '}';
    }
}

abstract class ShapeFactory {
    protected Map<Integer, Shape> shapeMap = new WeakHashMap<>();
    public abstract Shape createShape(Integer colorCode);
}

class CircleFactory extends ShapeFactory {
    @Override
    public Shape createShape(Integer colorCode) {
        if (shapeMap.containsKey(colorCode)) {
            return shapeMap.get(colorCode);
        }
        Shape shape = new Circle(colorCode);
        shapeMap.put(colorCode, shape);
        return shape;
    }
}

class SquareFactory extends ShapeFactory {
    @Override
    public Shape createShape(Integer colorCode) {
        if (shapeMap.containsKey(colorCode)) {
            return shapeMap.get(colorCode);
        }
        return new Square(colorCode);
    }
}

class Solution {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new CircleFactory();
        Shape shape1 = shapeFactory.createShape(12);
        Shape shape2 = shapeFactory.createShape(12);
        System.out.println(shape1);
        System.out.println(shape2);
        System.out.println(shape1.equals(shape2));
        System.out.println(shape1 == shape2);
    }
}