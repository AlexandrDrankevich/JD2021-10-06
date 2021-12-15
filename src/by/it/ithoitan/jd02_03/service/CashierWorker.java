package by.it.ithoitan.jd02_03.service;


import by.it.ithoitan.jd02_03.helper.RandomGenerator;
import by.it.ithoitan.jd02_03.helper.TimeOut;
import by.it.ithoitan.jd02_03.entity.Cashier;
import by.it.ithoitan.jd02_03.entity.Customer;
import by.it.ithoitan.jd02_03.entity.Store;

public class CashierWorker implements Runnable {
    private final Cashier cashier;
    private final Store store;

    public CashierWorker(Store store, Cashier cashier) {
        this.cashier = cashier;
        this.store = store;
    }

    @Override
    public void run() {
        System.out.println(cashier + " opened");
        while (!store.getManager().isCloseStore()) {
            Customer customer = store.getQueue().extract();
            if (customer != null) {
                synchronized (customer.getMonitor()) {
                    System.out.println(cashier + " started to service " + customer);
                    int timeout = RandomGenerator.get(2000, 5000);
                    TimeOut.sleep(timeout);
                    System.out.println(cashier + " finished to service " + customer);
                    customer.setFlagWaining(false);
                    customer.getMonitor().notify();
                }
            } else {
                TimeOut.sleep(100);
            }
        }
        System.out.println(cashier + " closed");

    }
}