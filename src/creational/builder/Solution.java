package creational.builder;

public class Solution {
    public static void main(String[] args) {
        BurgerBuilder burgerBuilder = new BurgerBuilderImpl();
        Burger burger = burgerBuilder.setBun(Burger.Bun.BLACK_BUN)
                .setCutlet(Burger.Cutlet.MEET)
                .setVegetable(Burger.Vegetable.TOMATO)
                .setVegetable(Burger.Vegetable.LETTUCE)
                .setSouse(Burger.Souse.TOMATO)
                .build();
        System.out.println(burger);
    }
}
