package by.yevstratyev.java_intro.module_01;

/*
 * Module 1. Basics of software code development
 * Циклы
 * Задача 6
 * Условие:
 *   Вывести на экран соответствия между символами и их численными обозначениями в памяти компьютера.
 */

public class Task17 {
    public static void main(String[] args) {
        byte firstChar = 32;
        byte lastChar = 127;
        for (byte i = firstChar; i < lastChar; i++) {
            System.out.print(i + "=" + (char) i + " ");
            if ((i - 1) % 10 == 0) {
                System.out.println();
            }
        }
    }
}