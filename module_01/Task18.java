package by.yevstratyev.java_intro.module_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Module 1. Basics of software code development
 * Циклы
 * Задача 7
 * Условие:
 *   Для каждого натурального числа в промежутке от m до n вывести все делители,
 *   кроме единицы и самого числа. m и n вводятся с клавиатуры.
 */

public class Task18 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int m;
            int n;
            boolean flag = false;

            while(true) {
                System.out.print("Please enter m: ");
                m = Integer.parseInt(reader.readLine());
                System.out.print("Please enter n: ");
                n = Integer.parseInt(reader.readLine());
                if (m <= 0 || n <= 0) { // Ноль исключил, т.к. делитель числа 0 - любое ненулевое число.
                    System.err.println("You've entered a zero or a negative number. Please enter again!");
                } else {
                    break;
                }
            }

            if (m > n) {
                int tmp = n;
                n = m;
                m = tmp;
            }

            for (int i = m; i <= n; i++) {
                System.out.print("Divisors of the number " + i + ": ");
                for (int j = 2; j <= (i / 2); j++) {
                    if (i % j == 0) {
                        System.out.print(j + " | ");
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.print("only 1 and the number itself");
                }
                System.out.println();
                flag = false;
            }

        } catch (NumberFormatException e) {
            System.err.print("Error! Only numbers (natural) can be entered!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}