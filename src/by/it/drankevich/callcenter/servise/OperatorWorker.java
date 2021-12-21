package by.it.drankevich.callcenter.servise;

import by.it.drankevich.callcenter.entity.CallCenter;
import by.it.drankevich.callcenter.entity.Client;
import by.it.drankevich.callcenter.entity.Operator;
import by.it.drankevich.callcenter.helper.Timeout;

public class OperatorWorker extends Thread implements OperatorAction {

    private final Operator operator;
    private final CallCenter callCenter;

    public OperatorWorker(Operator operator, CallCenter callCenter) {
        this.callCenter = callCenter;
        this.operator = operator;

    }

    @Override
    public void run() {
        takeCall();
    }

    @Override
    public void takeCall() {
        while (!callCenter.getWorkingDayPlan().isClosed()) {

            Client client = callCenter.getQueue().extract();
            if (client != null) {
                synchronized (client) {
                    System.out.println(operator + " process the call of the " + client);
                    Timeout.sleep(1000);
                    System.out.println(operator + " Finished process the call of the " + client);
                    client.setFlagWaiting(false);
                    client.notify();
                }

            } else Timeout.sleep(300);

        }
    }
}
