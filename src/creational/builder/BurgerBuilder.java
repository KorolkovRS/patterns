package creational.builder;

public interface BurgerBuilder {
    BurgerBuilder setBun(Burger.Bun bun);
    BurgerBuilder setCutlet(Burger.Cutlet cutlet);
    BurgerBuilder setVegetable(Burger.Vegetable vegetable);
    BurgerBuilder setSouse(Burger.Souse sauce);
    Burger build();
}
