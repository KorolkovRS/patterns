package creational.prototype;

class Detail implements Cloneable {
    private int weight;
    public Detail(int weight) throws InterruptedException {
        Thread.sleep(50);
        this.weight = weight;
        System.out.println("Parent detail construct");
    }

    @Override
    protected Detail clone() throws CloneNotSupportedException {
        Detail clone = (Detail) super.clone();
        return clone;
    }

    public int getWeight() {
        return weight;
    }
}

class ConcreteDetail extends Detail {
    public ConcreteDetail(int weight) throws InterruptedException {
        super(weight);
        System.out.println("Concrete detail construct");
    }
}

class Conveyor {
    private Detail detail;

    public Conveyor(Detail detail) {
        this.detail = detail;
    }

    public Detail doDetail() throws CloneNotSupportedException {
        return detail.clone();
    }
}

class Solution {
    public static void main(String[] args) throws CloneNotSupportedException, InterruptedException {
        Conveyor conveyor = new Conveyor(new ConcreteDetail(23));

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            System.out.println(conveyor.doDetail().getWeight());
        }
        long end = System.currentTimeMillis();
        System.out.println("Conveyor done behind " + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            System.out.println(new ConcreteDetail(40).getWeight());
        }
        end = System.currentTimeMillis();
        System.out.println("Manual done behind " + (end - start));
    }
}
