package by.yevstratyev.java_intro.module_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Module 1. Basics of software code development
 * Линейные программы
 * Задача 2
 * Условие:
 *   Вычислить значение по формуле (все переменные принимают действительные значения):
 *   (b + √(b^2 + 4ac)) / 2a - a^3c + b^(-2)
 */

public class Task02 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Please enter real number a (e.g. 0.5): ");
            double a = Double.parseDouble(reader.readLine());
            System.out.print("Please enter real number b (e.g. 0.5): ");
            double b = Double.parseDouble(reader.readLine());
            System.out.print("Please enter real number c (e.g. 0.5): ");
            double c = Double.parseDouble(reader.readLine());

            // Согласно условию (действительные значения), возможны NaN и Infinity.
            double result = (b + Math.sqrt(Math.pow(b, 2) + 4 * a * c))
                    / (2 * a) - Math.pow(a, 3) * c + Math.pow(b, -2);

            System.out.print("Result is " + result);
        } catch (NumberFormatException e) {
            System.err.print("Error! Only numbers can be entered!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}