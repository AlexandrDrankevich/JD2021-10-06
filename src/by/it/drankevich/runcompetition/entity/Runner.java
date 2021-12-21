package by.it.drankevich.runcompetition.entity;

public class Runner {

    private final String name;



    public Runner(int number) {
        this.name="Runner № "+number;

    }

    @Override
    public String toString() {
        return name;
    }
}
