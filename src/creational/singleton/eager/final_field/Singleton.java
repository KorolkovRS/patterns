package creational.singleton.eager.final_field;

class Singleton {
    public static final Singleton INSTANCE = new Singleton();
    private String data = "Init data";

    public String getData() {
        return data;
    }
}

class Solution {
    public static void main(String[] args) {
        Singleton finalFieldSingleton1 = Singleton.INSTANCE;
        Singleton finalFieldSingleton2 = Singleton.INSTANCE;
        System.out.println(finalFieldSingleton1 == finalFieldSingleton2);
        System.out.println(finalFieldSingleton1.getData());
    }
}
