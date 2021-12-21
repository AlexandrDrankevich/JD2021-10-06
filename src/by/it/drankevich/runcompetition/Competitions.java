package by.it.drankevich.runcompetition;

import by.it.drankevich.runcompetition.entity.Runner;
import by.it.drankevich.runcompetition.service.RunnerWorker;
import by.it.drankevich.runcompetition.service.StartMaker;

import java.util.Locale;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Competitions implements Runnable {

    CyclicBarrier cyclicBarrier= new CyclicBarrier(10,new StartMaker());

    @Override
    public void run() {
         ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 1; i <11 ; i++) {
            Runner runner = new Runner(i);
           RunnerWorker runnerWorker = new RunnerWorker(runner, cyclicBarrier);
           executorService.execute(runnerWorker);

        }
        executorService.shutdown();

        try {
            executorService.awaitTermination(100, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Competitions Finished");


    }
}
