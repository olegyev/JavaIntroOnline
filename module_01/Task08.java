package by.yevstratyev.java_intro.module_01;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Module 1. Basics of software code development
 * Ветвления
 * Задача 2
 * Условие:
 *   Найти max{min(a, b), min(c, d)}.
 */

public class Task08 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter a & b: ");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println("Please enter c & d: ");
            int c = scanner.nextInt();
            int d = scanner.nextInt();

            if (a != b && c != d) {
                int min1 = a < b ? a : b;
                int min2 = c < d ? c : d;
                if (min1 != min2) {
                    int max = min1 > min2 ? min1 : min2;
                    System.out.print("Maximum is " + max);
                } else {
                    System.out.print("Minimums are equal, we can't find maximum :(");
                }
            } else {
                System.out.print("One of the pairs (or both) has equal numbers, we can't find minimum :(");
            }

        } catch (InputMismatchException e) {
            System.err.print("Error! Only integers can be entered!");
        }
    }
}