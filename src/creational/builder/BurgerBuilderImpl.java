package creational.builder;

public class BurgerBuilderImpl implements BurgerBuilder {
    private Burger burger;

    public BurgerBuilderImpl() {
        this.burger = new Burger();
    }

    @Override
    public BurgerBuilder setBun(Burger.Bun bun) {
        burger.setBun(bun);
        return this;
    }

    @Override
    public BurgerBuilder setCutlet(Burger.Cutlet cutlet) {
        burger.setCutlet(cutlet);
        return this;
    }

    @Override
    public BurgerBuilder setVegetable(Burger.Vegetable vegetable) {
        burger.setVegetable(vegetable);
        return this;
    }

    @Override
    public BurgerBuilder setSouse(Burger.Souse sauce) {
        burger.setSouse(sauce);
        return this;
    }

    @Override
    public Burger build() {
        return burger;
    }
}
