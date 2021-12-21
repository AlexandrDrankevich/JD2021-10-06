package by.it.drankevich.callcenter.servise;

import by.it.drankevich.callcenter.entity.CallCenter;
import by.it.drankevich.callcenter.entity.Client;
import by.it.drankevich.callcenter.helper.RandomMaker;
import by.it.drankevich.callcenter.helper.Timeout;

public class ClientWorker extends Thread implements ClientAction {
    private final Client client;
    private final CallCenter callCenter;

    public ClientWorker(Client client, CallCenter callCenter) {
        this.client = client;
        this.callCenter = callCenter;
    }

    @Override
    public void run() {
        calling();
        goToQueue();


    }

    @Override
    public void calling() {
        System.out.println(client + " is calling");

    }

    @Override
    public void goToQueue() {
       if (callCenter.getQueue().getQueue().size() > 1) {
            if (RandomMaker.random()) {
                System.out.println(client+" Calling later");
               Timeout.sleep(400);
                if (callCenter.getWorkingDayPlan().isOpened()) {
                    return;
                }
            }
        }
        synchronized (client) {
            callCenter.getQueue().addQueue(client);
            callCenter.getWorkingDayPlan().addClientCall();
            client.setFlagWaiting(true);
            while (client.isFlagWaiting()) {
                try {
                    client.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
        callCenter.getWorkingDayPlan().finishedCall();

    }
}

