package by.yevstratyev.java_intro.module_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Module 1. Basics of software code development
 * Ветвления
 * Задача 3
 * Условие:
 *   Даны три точки A(x1, y1), B(x2, y2) и C(x3, y3).
 *   Определить, будут ли они расположены на одной прямой.
 */

public class Task09 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            // Я использовал целочисленные переменные на вводе, чтобы избежать погрешностей при сравнении.
            System.out.println("Please enter A(x1, y1):");
            int x1 = Integer.parseInt(reader.readLine());
            int y1 = Integer.parseInt(reader.readLine());
            System.out.println("Please enter B(x2, y2):");
            int x2 = Integer.parseInt(reader.readLine());
            int y2 = Integer.parseInt(reader.readLine());
            System.out.println("Please enter C(x3, y3):");
            int x3 = Integer.parseInt(reader.readLine());
            int y3 = Integer.parseInt(reader.readLine());

            if (x1 == x2 && x2 == x3 && y1 == y2 && y2 == y3) {
                System.out.print("You've created a point, not a line");
            } else {
                int a = x3 * (y2 - y1) - y3 * (x2 - x1);
                int b = x1 * y2 - x2 * y1;
                if (a == b) {
                    System.out.print("Points lie on a single straight line");
                } else {
                    System.out.print("Points don't lie on a single straight line");
                }
            }

        } catch (NumberFormatException e) {
            System.err.print("Error! Only integers can be entered!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}