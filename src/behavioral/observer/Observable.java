package behavioral.observer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

interface Observable {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers();
}

interface Observer {
    void update(BigDecimal course);
}

class CentralBank implements Observable {
    private BigDecimal course;
    private List<Observer> observerList = new ArrayList<>();

    public void setCourse(BigDecimal course) {
        this.course = course;
        notifyObservers();
    }

    @Override
    public void subscribe(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer: observerList) {
            observer.update(course);
        }
    }
}

class ConcreteObserver implements Observer {
    private BigDecimal course;

    public BigDecimal getCourse() {
        return course;
    }

    @Override
    public void update(BigDecimal course) {
        this.course = course;
        System.out.println(this + " update. Current course = " + course);
    }
}

class Solution {
    public static void main(String[] args) {
        CentralBank bank = new CentralBank();
        List<Observer> observerList = new ArrayList<>();
        ConcreteObserver concreteObserver1 = new ConcreteObserver();
        ConcreteObserver concreteObserver2 = new ConcreteObserver();
        ConcreteObserver concreteObserver3 = new ConcreteObserver();
        observerList.add(concreteObserver1);
        observerList.add(concreteObserver2);

        for(Observer observer: observerList) {
            bank.subscribe(observer);
        }

        bank.setCourse(new BigDecimal(73.23));
        bank.setCourse(new BigDecimal(73.8));
    }
}
