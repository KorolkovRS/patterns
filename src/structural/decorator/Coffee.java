package structural.decorator;

interface Coffee {
    int getPrice();
}

class Cappuccino implements Coffee {
    private final int price = 100;

    @Override
    public int getPrice() {
        return price;
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    @Override
    public int getPrice() {
        return coffee.getPrice();
    }
}

class Topping extends CoffeeDecorator {
    private final int toppingPrice = 50;

    public Topping(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public int getPrice() {
        return super.getPrice() + toppingPrice;
    }
}

class IceCream extends CoffeeDecorator {
    private final int iceCream = 150;

    public IceCream(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public int getPrice() {
        return super.getPrice() + iceCream;
    }
}

class Solution {
    public static void main(String[] args) {
        CoffeeDecorator coffee = new IceCream(new Topping(new Topping(new Cappuccino())));
        System.out.println(coffee.getPrice());
    }
}
