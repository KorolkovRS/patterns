package creational.singleton.lazy.not_multithreading;

public class Singleton {
    private static Singleton instance;
    private String data;

    private Singleton() {
        data = "Init data";
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public String getData() {
        return data;
    }
}

class Solution {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
        System.out.println(singleton1.getData());
    }
}
