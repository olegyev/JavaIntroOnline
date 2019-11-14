package by.yevstratyev.java_intro.module_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Module 1. Basics of software code development
 * Циклы
 * Задача 1
 * Условие:
 *   Напишите программу, где пользователь вводит любое целое положительное число.
 *   А программа суммирует все числа от 1 до введенного пользователем числа.
 */

public class Task12 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter a positive integer: ");
            int userNumber = Integer.parseInt(reader.readLine());
            int counter = 1;
            int result = 0;

            if (userNumber >= 1) {
                while (counter <= userNumber) {
                    result += counter;
                    counter++;
                }
                System.out.print("Result is " + result);
            } else {
                System.err.print("You've entered a number less than or equal to zero");
            }

        } catch (NumberFormatException e) {
            System.err.print("Error! Only an integer can be entered!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}