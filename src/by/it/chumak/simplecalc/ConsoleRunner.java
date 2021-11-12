package by.it.chumak.simplecalc;

import java.util.Scanner;

public class ConsoleRunner {

    public static final String STOP_APP_COMMAND = "end";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();
        Parser parser = new Parser();
        for (; ; ) {
            String expression = scanner.nextLine();
            if (!expression.equals(STOP_APP_COMMAND)) {
                Var result = parser.evaluate(expression);
                printer.print(result);
            } else {
                break;
            }
        }
        System.out.println("Calculator closed");
    }
}
