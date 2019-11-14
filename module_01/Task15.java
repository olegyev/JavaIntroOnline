package by.yevstratyev.java_intro.module_01;

import java.math.BigInteger;

/*
 * Module 1. Basics of software code development
 * Циклы
 * Задача 4
 * Условие:
 *   Составить программу нахождения произведения квадратов первых двухсот чисел.
 */

public class Task15 {
    public static void main(String[] args) {
        BigInteger result = new BigInteger("1");
        int twoHundred = 200;
        for (int i = 1; i <= twoHundred; i++) {
            result = result.multiply(BigInteger.valueOf(i * i));
        }
        System.out.print("Result is " + result);
    }
}