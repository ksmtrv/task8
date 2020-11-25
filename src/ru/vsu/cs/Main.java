package ru.vsu.cs;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int c = readSomething("the number of columns in the array:");
        int l = readSomething("the number of lines in the array:");
        int[][] arr = new int[l][c];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = readSomething("an array element [" + i + "][" + j + "]:");
            }
        }

        int stepsC = readSomething("step shear of the columns:");
        int stepsL = readSomething("line shift step:");

        printArray(arr, l, c);
        System.out.println();

        moveColumns(arr, stepsC);
        moveLine(arr, stepsL);

        printArray(arr, l, c);
    }

    private static void moveColumns(int[][] arr, int stepsC) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int stepsR = stepsC % arr[i].length;
            while (stepsR-- > 0) {
                int f = arr[i][0];
                for (int j = arr[i].length - 1; j >= 0; j--) {
                    int l = arr[i][j];
                    arr[i][j] = f;
                    f = l;
                }
            }
        }
    }

    private static void moveLine(int[][] arr, int stepsL) {
        for (int i = arr.length + stepsL; i >= 1; i--) {
            int[][] arrNew = arr.clone();
            arr[0] = arrNew[arr.length - 1];
            for (int j = 1; j < arr.length; j++) {
                arr[j] = arrNew[j - 1];
            }
        }
    }

    private static int readSomething(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter %s ", name);
        return scanner.nextInt();
    }

    private static void printArray(int[][] arr, int l, int c) {
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}