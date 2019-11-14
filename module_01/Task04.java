package by.yevstratyev.java_intro.module_01;

/*
 * Module 1. Basics of software code development
 * Линейные программы
 * Задача 4
 * Условие:
 *   Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях).
 *   Поменять местами дробную и целую части числа и вывести полученное значение числа.
 */

public class Task04 {
    public static void main(String[] args) {
        double r = 222.333;

        int n = (int) r;
        int d = (int) Math.round((r - n) * 1000);
        double result = d + (double) n / 1000;

        System.out.print("Result is " + result);
    }
}