package by.it.drankevich.callcenter.servise;

import by.it.drankevich.callcenter.entity.CallCenter;
import by.it.drankevich.callcenter.entity.Client;
import by.it.drankevich.callcenter.entity.Operator;
import by.it.drankevich.callcenter.entity.Queue;
import by.it.drankevich.callcenter.helper.RandomMaker;
import by.it.drankevich.callcenter.helper.Timeout;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CallCenterWorker extends Thread{

    private final CallCenter callCenter;

    public CallCenterWorker(CallCenter callCenter) {
        this.callCenter=callCenter;
    }
    int counter=1;

    @Override
    public void run() {
        System.out.println("CallCenter opened");

        ExecutorService executorService= Executors.newFixedThreadPool(2);
        for (int i = 1; i < 3; i++) {
            Operator operator=new Operator(i);
            OperatorWorker operatorWorker=new OperatorWorker(operator,callCenter);
            executorService.execute(operatorWorker);
        }
        executorService.shutdown();

        while (callCenter.getWorkingDayPlan().isOpened()) {

                Client client = new Client(counter++);
                ClientWorker clientWorker = new ClientWorker(client,callCenter);
                clientWorker.start();
            Timeout.sleep(1);


        }

        try {
            executorService.awaitTermination(100, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("CallCenter closed");


    }
}
