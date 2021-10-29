package by.it.serkutsyev.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //  int arr[][] = new int[n][n];
        int array[][] = step1(n);
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d", array[i][j]);
                index++;
                if (index % n == 0) {
                    System.out.println();
                }
            }

        }
        step2();
        step3();
    }


    private static int[][] step1(int n) {

        int[][] arr1 = new int[n][n];
        boolean positiveN = false;
        boolean negativeN = false;
        if (negativeN == false || positiveN == false) {
            if (negativeN == false || positiveN == false) {
                for (int i = 0; i < n; i++) {
//                if (i==n){
//                    i=0;
//                }
                    for (int j = 0; j < n; j++) {
                        arr1[i][j] = ((int) (Math.random() * ((2 * n) + 1) - n));
                        if (arr1[i][j] == n) {
                            positiveN = true;
                        } else if (arr1[i][j] == -n) {
                            negativeN = true;
                        }
                    }
                }

                //  return arr1;
            }
            else {
                return arr1;
            }
        }
        return arr1;
    }

    private static void step2() {
    }

    private static void step3() {
    }

}