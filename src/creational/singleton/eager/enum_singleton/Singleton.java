package creational.singleton.eager.enum_singleton;

enum Singleton {
    INSTANCE("Init data");

    private String data;

    Singleton(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}

class Solution {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.INSTANCE;
        Singleton singleton2 = Singleton.INSTANCE;
        System.out.println(singleton1 == singleton2);
        System.out.println(singleton1.getData());
    }
}