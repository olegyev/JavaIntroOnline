package by.yevstratyev.java_intro.module_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Module 1. Basics of software code development
 * Циклы
 * Задача 5
 * Условие:
 *   Даны числовой ряд и некоторое число e. Найти сумму тех членов ряда, модуль которых больше или равен заданному e.
 *   Общий член ряда имеет вид:
 *   a(n) = 1 / 2^n + 1 / 3^n
 */

public class Task16 {
    public static void main(String[] args) {
        int n;
        double a;
        double e;
        double sum = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.print("Set the length of a series (natural number): ");
                n = Integer.parseInt(reader.readLine());
                if (n <= 0) {
                    System.err.println("The length of a series cannot be less than or equal to zero");
                } else {
                    break;
                }
            }

            System.out.print("Enter a control number (real number, e.g. 0.5): ");
            e = Double.parseDouble(reader.readLine());

            for (int i = 1; i <= n; i++) {
                a = (double) 1 / Math.pow(2, i) + 1 / Math.pow(3, i);
                // Модуль представляется излишним, т.к. a всегда принимает положительные значения,
                // но оставил в соответствии с условием задачи.
                if (Math.abs(a) >= e) {
                    sum += a;
                } else {
                    // Для избежания лишних итераций после выполнения условий задачи при e > 0.
                    // При e <= 0 цикл будет проходить все итерации.
                    break;
                }
            }

            if (sum != 0) {
                System.out.print("Result for the series with length " + n + " is: " + sum);
            } else {
                System.out.print("There are no members of a series whose modulus is greater than or equal to the control number");
            }

        } catch (NumberFormatException ex) {
            System.err.print("Error! Only numbers can be entered, natural - for a series length!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}