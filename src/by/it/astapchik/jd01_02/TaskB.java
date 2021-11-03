package by.it.astapchik.jd01_02;

import java.util.Scanner;

class TaskB {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int month = sc.nextInt();

        double a = sc.nextInt();
        double b = sc.nextInt();
        double c = sc.nextInt();

        step1();
        step2(month);
        step3(a, b, c);
    }
    private static void step1() {
        for (int i = 0; i <= 25; i++) {
            System.out.print(i + " ");
            if (i % 5 == 0) System.out.println();
        }
    }

    private static void step2(int month) {
        switch (month){
            case 1: System.out.println("январь"); break;
            case 2: System.out.println("февраль"); break;
            case 3: System.out.println("март"); break;
            case 4: System.out.println("апрель"); break;
            case 5: System.out.println("май"); break;
            case 6: System.out.println("июнь"); break;
            case 7: System.out.println("июль"); break;
            case 8: System.out.println("август"); break;
            case 9: System.out.println("сентябрь"); break;
            case 10: System.out.println("октябрь"); break;
            case 11: System.out.println("ноябрь"); break;
            case 12: System.out.println("декабрь"); break;
            default: System.out.println("нет такого месяца"); break;
        }
    }

    public static void step3(double a, double b, double c){
        double d = b * b - 4 * a * c;
        if (d < 0) System.out.println("корней нет");
        else if (d == 0){
            double y = -b / (2 * a);
            System.out.println(y);
        }
        else {
            double y1 = (-b + Math.sqrt(d)) / (2 * a);
            double y2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println(y1 + " " + y2);
        }
    }
}


