package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Декомпозиция с использованием методов (подпрограммы)
 * Задача 5
 * Условие:
 *  Составить программу, которая в массиве A[N] находит второе по величине число
 *  (вывести на печать число, которое меньше максимального элемента массива,
 *  но больше всех других элементов).
 */

public class Task39 {
    public static void main(String[] args) {
        Task39 solution = new Task39();
        int[] array = solution.generateRandomArray();
        solution.printRandomArray(array);

        try {
            int resultOne = solution.findSecondLargestNumber(array);
            System.out.println("Second largest number = " + resultOne);

            int resultTwo = solution.findSecondLargestNumberWithSort(array);
            System.out.println("Second largest number with sort = " + resultTwo);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public int[] generateRandomArray() {
        final int N = (int) (2 + (Math.random() * 9)); // от 2 до 10 включительно
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = (int) (Math.random() * 21) - 10; // от -10 до 10 включительно
        }
        return array;
    }

    public void printRandomArray(int[] array) {
        System.out.println("Initial numbers:");
        for (int element : array) {
            System.out.print(element + " | ");
        }
        System.out.println();
    }

    public int findSecondLargestNumber(int[] array) throws Exception {
        int maxNumber = Integer.MIN_VALUE;
        boolean areEquals = true;

        for (int element : array) {
            if (element != array[0]) {
                areEquals = false;
            }

            if (element > maxNumber) {
                maxNumber = element;
            }
        }

        if (areEquals) {
            throw new Exception("All array elements are equal");
        } else {
            return findPreMaxNumber(array, maxNumber);
        }
    }

    public int findSecondLargestNumberWithSort(int[] array) throws Exception {
        boolean areEquals = true;

        for (int step = array.length / 2; step >= 1; step /= 2) {
            for (int inc = 0; inc < step; inc++) {
                for (int i = inc; i < array.length - step; i += step) {
                    for (int j = i + step; j - step >= 0; j -= step) {
                        if (array[j] != array[0]) {
                            areEquals = false;
                        }

                        if (array[j - step] < array[j]) {
                            int tmp = array[j];
                            array[j] = array[j - step];
                            array[j - step] = tmp;
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        if (areEquals) {
            throw new Exception("All array elements are equal");
        } else {
            return findPreMaxNumberWithSort(array);
        }
    }

    private int findPreMaxNumber(int[] array, int maxNumber) {
        int preMaxNumber = Integer.MIN_VALUE;

        for (int element : array) {
            if (element < maxNumber && element > preMaxNumber) {
                preMaxNumber = element;
            }
        }

        return preMaxNumber;
    }

    private int findPreMaxNumberWithSort(int[] array) {
        int i = 0;
        int preMaxNumber;

        while (true) {
            if (array[++i] < array[0]) {
                preMaxNumber = array[i];
                break;
            }
        }

        return preMaxNumber;
    }
}