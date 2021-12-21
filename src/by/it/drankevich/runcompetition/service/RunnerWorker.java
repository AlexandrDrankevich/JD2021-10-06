package by.it.drankevich.runcompetition.service;

import by.it.drankevich.runcompetition.entity.Runner;
import by.it.drankevich.runcompetition.helper.Timer;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class RunnerWorker extends Thread implements RunnerAction {
  public static final AtomicInteger atomicInteger= new AtomicInteger(1);
  public static final Semaphore semaphore=new Semaphore(1);


    private final Runner runner;
    private CyclicBarrier cyclicBarrier;


    public RunnerWorker(Runner runner, CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier=cyclicBarrier;
        this.runner=runner;

    }
    Timer timer=new Timer();

    @Override
    public void run() {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        running();
    }

    @Override
    public void running() {


        System.out.println(runner+" in the middle of the distance");

        try {
            semaphore.acquire();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("FINISHED "+ atomicInteger.getAndIncrement()+" - "+ runner
            +"  running Time: "+timer.timeFinish());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            semaphore.release();
        }



    }
}
