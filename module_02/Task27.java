package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Одномерные массивы. Сортировки
 * Задача 1
 * Условие:
 *  Заданы два одномерных массива с различным количеством элементов и натуральное число k.
 *  Объединить их в один массив, включив второй массив между k-м и (k+1)-м элементами первого,
 *  при этом не используя дополнительный массив.
 */

public class Task27 {
    public static void main(String[] args) {
        int arrayOneLength;
        int arrayTwoLength;
        int k;
        Task27 solution = new Task27();

        do {
            arrayOneLength = (int) (2 + Math.random() * 9); // от 2 до 10 включительно
            arrayTwoLength = (int) (2 + Math.random() * 9); // от 2 до 10 включительно
        } while (arrayOneLength == arrayTwoLength);

        // k принимает значения от 0 до предпоследнего элемента первого массива включительно.
        k = (int) (Math.random() * (arrayOneLength - 1));
        System.out.println("k = " + k);

        System.out.println("Array one:");
        int[] arrayOne = solution.fillAndPrintArray(arrayOneLength);

        System.out.println("\nArray two:");
        int[] arrayTwo = solution.fillAndPrintArray(arrayTwoLength);

        // Основная логика.
        int[] resultingArray = new int[arrayOneLength + arrayTwoLength];
        for (int i = 0; i < resultingArray.length; i++) {
            if (i <= k) {
                resultingArray[i] = arrayOne[i];
            } else if (i > k + arrayTwoLength) {
                resultingArray[i] = arrayOne[i - arrayTwoLength];
            } else {
                resultingArray[i] = arrayTwo[i - k - 1];
            }
        }

        System.out.println("\nResulting array:");
        for (int i : resultingArray) {
            System.out.print(i + " | ");
        }
    }

    private int[] fillAndPrintArray(int arrayLength) {
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = (int) (Math.random() * 21) - 10; // от -10 до 10 включительно
            System.out.print(array[i] + " | ");
        }
        return array;
    }
}