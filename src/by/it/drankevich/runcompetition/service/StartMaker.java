package by.it.drankevich.runcompetition.service;

import by.it.drankevich.runcompetition.helper.Timer;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

public class StartMaker implements Runnable{
     public static LocalTime timestart;
    @Override
    public void run() {
        System.out.println("READY! SET! GO!\n All sportsmen running");
       timestart= LocalTime.now();
    }
}
