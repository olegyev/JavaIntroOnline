package by.yevstratyev.java_intro.module_01;

/*
 * Module 1. Basics of software code development
 * Циклы
 * Задача 3
 * Условие:
 *   Найти сумму квадратов первых ста чисел.
 */

public class Task14 {
    public static void main(String[] args) {
        int result = 0;
        int hundred = 100;
        for (int i = 1; i <= hundred; i++) {
            result = result + i * i;
        }
        System.out.print("Result is " + result);
    }
}