package by.yevstratyev.java_intro.module_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Module 1. Basics of software code development
 * Циклы
 * Задача 2
 * Условие:
 *   Вычислить значение функции на отрезке [a, b] с шагом h:
 *       x, x > 2
 *   y =
 *       -x, x <= 2
 */

public class Task13 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Please enter a: ");
            int a = Integer.parseInt(reader.readLine());
            System.out.print("Please enter b: ");
            int b = Integer.parseInt(reader.readLine());
            System.out.print("Please enter h (greater than zero!): ");
            int h = Integer.parseInt(reader.readLine());

            int x = Math.min(a, b);
            int tmp = Math.max(a, b);
            int y;

            if (a != b && h > 0) {
                while (x <= tmp) {
                    y = x > 2 ? x : -x;
                    System.out.println("y = " + y);
                    x = x + h;
                }
            } else if (h <= 0) {
                System.err.print("h should be greater than zero!");
            } else {
                System.err.print("You've created a point, not a line segment");
            }

        } catch (NumberFormatException e) {
            System.err.print("Error! Only integers can be entered!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}