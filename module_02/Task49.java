package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Декомпозиция с использованием методов (подпрограммы)
 * Задача 15
 * Условие:
 *  Найти все натуральные n-значные числа, цифры в которых образуют строго
 *  возрастающую последовательность (например, 1234, 5789).
 *  Для решения задачи использовать декомпозицию.
 */

public class Task49 {
    public static void main(String[] args) {
        int n = generateRandomNum();
        System.out.println("Ascending sequences for " + n + "-digit numbers:");
        try {
            findAscendingDigits(n);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // От 2 до 9 разрядов включительно.
    public static int generateRandomNum() {
        return (int) (2 + Math.random() * 8);
    }

    public static void findAscendingDigits(int n) throws Exception {
        if (n < 2 || n >= 10) {
            throw new Exception("We can't find ascending sequence for " + n + "-digits number.");
        }

        int firstNum = calcFirstNum(n);

        for (int i = firstNum; i < (firstNum * 10); i++) {
            if (isAscending(i)) {
                printAscendingNum(i);
            }
        }
    }

    private static int calcFirstNum(int n) {
        int num = 1;

        for (int i = 1; i < n; i++) {
            num *= 10;
        }

        return num;
    }

    private static boolean isAscending(int num) {
        boolean isAscending = true;

        while (num / 10 > 0) {
            if (num % 10 <= (num / 10) % 10) {
                isAscending = false;
                break;
            }
            num /= 10;
        }

        return isAscending;
    }

    private static void printAscendingNum(int num) {
        System.out.println(num);
    }
}