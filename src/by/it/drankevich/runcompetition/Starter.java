package by.it.drankevich.runcompetition;

public class Starter {
    public static void main(String[] args) {

         Competitions competitions = new Competitions();

        Thread thread=new Thread(competitions);
        thread.start();



    }
}
