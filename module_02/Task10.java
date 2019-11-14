package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Одномерные массивы
 * Задача 10
 * Условие:
 *  Дан целочисленный массив с количеством элементов n.
 *  Сжать массив, выбросив из него каждый второй элемент
 *  (освободившиеся элементы заполнить нулями).
 *  Примечание. Дополнительный массив не использовать.
 */

public class Task10 {
    public static void main(String[] args) {
        // Определение длины массива - от 2 до 20 элементов включительно.
        final byte N = (byte) (2 + (byte) (Math.random() * 19));
        byte[] array = new byte[N];

        // Заполнение массива числами от -10 до 10 включительно.
        for (int i = 0; i < array.length; i++) {
            array[i] = (byte) ((byte) (Math.random() * 21) - 10);
        }

        System.out.println("Initial array:");
        for (int element : array) {
            System.out.print(element + " | ");
        }

        // Сжатие массива путем "обнуления" каждого второго элемента
        // и перемещения его в конец массива.
        for (int i = 1; i < array.length; i++) {
            array[i] = 0;
            for (int j = i + 1, k = i; j <= array.length - i; j++, k++) {
                array[k] = array[j];
            }
        }

        System.out.println("\nModified array:");
        for (int element : array) {
            System.out.print(element + " | ");
        }
    }
}