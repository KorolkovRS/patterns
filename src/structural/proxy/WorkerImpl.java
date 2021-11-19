package structural.proxy;

interface Worker {
    void doWork();
}

class WorkerImpl implements Worker {
    public WorkerImpl() {
        System.out.println("Worker implementation create");
    }

    @Override
    public void doWork() {
        System.out.println("Worker do work");
    }
}

class WorkerInterfaceProxy implements Worker {
    private Worker worker;

    public WorkerInterfaceProxy() {
        System.out.println("Worker interface proxy");
    }

    @Override
    public void doWork() {
        System.out.println(worker);
        if (worker == null) {
            lazyInit();
        }
        worker.doWork();
    }

    private void lazyInit() {
        worker = new WorkerImpl();
    }
}

class Solution {
    public static void main(String[] args) {
        Worker worker = new WorkerInterfaceProxy();
        worker.doWork();
    }
}
