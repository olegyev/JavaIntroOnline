package by.yevstratyev.java_intro.module_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Module 1. Basics of software code development
 * Ветвления
 * Задача 5
 * Условие:
 *   Вычислить значение функции:
 *           x^2 - 3x + 9, если x <= 3;
 *   F(x) =
 *           1 / (x^3 + 6), если x > 3.
 */

public class Task11 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Please enter x (real number is allowed, e.g. 0.5): ");
            double x = Double.parseDouble(reader.readLine());
            double y = x <= 3 ? (Math.pow(x, 2) - 3 * x + 9) : (1 / (Math.pow(x, 3) + 6));
            System.out.print("F(x) = " + y);
        } catch (NumberFormatException e) {
            System.err.print("Error! Only a number can be entered!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}