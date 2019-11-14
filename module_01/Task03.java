package by.yevstratyev.java_intro.module_01;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Module 1. Basics of software code development
 * Линейные программы
 * Задача 3
 * Условие:
 *   Вычислить значение по формуле (все переменные принимают действительные значения):
 *   (sin x + cos y) / (cos x - sin y) * tg xy
 */

public class Task03 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please enter a real number x (e.g. 0,5): ");
            double x = scanner.nextDouble();
            System.out.print("Please enter a real number y (e.g. 0,5): ");
            double y = scanner.nextDouble();

            // Значения переменных приводятся в радианах.
            double result = (Math.sin(x) + Math.cos(y)) / (Math.cos(x) - Math.sin(y)) * Math.tan(x * y);
            System.out.print("Result is " + result);

        } catch (InputMismatchException e) {
            System.err.print("Error! Only numbers can be entered!");
        }
    }
}