package by.it.drankevich.runcompetition.helper;


import by.it.drankevich.runcompetition.service.StartMaker;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.Date;

import static by.it.drankevich.runcompetition.service.StartMaker.*;

public class Timer {


    private LocalTime timeFinish;





    public long timeFinish(){
        this.timeFinish= LocalTime.now();

        return  Duration.between(timestart, timeFinish).getNano();
    }
}
