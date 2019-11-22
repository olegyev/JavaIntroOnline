package by.yevstratyev.java_intro.module_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Module 2. Algorithmization
 * Декомпозиция с использованием методов (подпрограммы)
 * Задача 2
 * Условие:
 *  Написать метод (методы) для нахождения наибольшего общего делителя четырех натуральных чисел.
 */

public class Task36 {
    public static void main(String[] args) {
        final int N = 4;
        int[] fourNumsArray = new int[N];

        System.out.println("Please enter four natural numbers:");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < N; i++) {
                System.out.print((i + 1) + " number > ");
                fourNumsArray[i] = Integer.parseInt(reader.readLine());
                if (fourNumsArray[i] < 1) {
                    System.err.println("Wrong number, try again:");
                    i--;
                }
            }

            Task36 solution = new Task36();
            int gcd = solution.calcMultGcd(fourNumsArray);

            System.out.print("Greatest Common Divisor of ");
            for (int i = 0; i < N; i++) {
                if (i < N - 1) {
                    System.out.print(fourNumsArray[i] + ", ");
                } else {
                    System.out.print(fourNumsArray[i]);
                }
            }
            System.out.println(" is " + gcd);
        } catch (NumberFormatException e) {
            System.err.println("Error! Only natural numbers can be entered!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int calcMultGcd(int[] array) {
        int gcd = array[0];
        for (int i = 1; i < array.length; i++) {
            gcd = calcGcd(gcd, array[i]);
        }
        return gcd;
    }

    private int calcGcd(int a, int b) {
        return b == 0 ? a : calcGcd(b, a % b);
    }
}