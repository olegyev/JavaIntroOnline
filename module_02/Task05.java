package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Одномерные массивы
 * Задача 5
 * Условие:
 *  Даны целые числа a(1), a(2), ..., a(n).
 *  Вывести на печать только те числа, для которых a(i) > i.
 */

public class Task05 {
    public static void main(String[] args) {
        final byte ARRAY_LENGTH = (byte) (2 + (Math.random() * 9)); // от 2 до 10 включительно
        byte[] array = new byte[ARRAY_LENGTH];

        System.out.print("Array numbers: ");
        for (byte i = 0; i < array.length; i++) {
            array[i] = (byte) ((byte) (Math.random() * 21) - 10); // от -10 до 10 включительно
            System.out.print(array[i] + " | ");
        }

        System.out.print("\nNumbers larger than their index: ");
        for (byte i = 0; i < array.length; i++) {
            if (array[i] > i) {
                System.out.print(array[i] + " | ");
            }
        }
    }
}