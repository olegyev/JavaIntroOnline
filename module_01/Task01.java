package by.yevstratyev.java_intro.module_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Module 1. Basics of software code development
 * Линейные программы
 * Задача 1
 * Условие:
 *   Найдите значение функции: z = ((a - 3) * b / 2) + c.
 */

public class Task01 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Please enter integer a: ");
            int a = Integer.parseInt(reader.readLine());
            System.out.print("Please enter integer b: ");
            int b = Integer.parseInt(reader.readLine());
            System.out.print("Please enter integer c: ");
            int c = Integer.parseInt(reader.readLine());

            double z = ((double) (a - 3) * b / 2) + c;
            System.out.print("Result is " + z);

        } catch (NumberFormatException e) {
            System.err.print("Error! Only integers can be entered!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}