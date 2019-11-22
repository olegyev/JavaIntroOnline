package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Декомпозиция с использованием методов (подпрограммы)
 * Задача 16
 * Условие:
 *  Написать программу, определяющую сумму n-значных чисел, содержащих только нечетные цифры.
 *  Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию.
 */

public class Task50 {
    public static void main(String[] args) {
        Task50 solution = new Task50();
        int n = solution.generateRandomNum();

        try {
            long oddSum = solution.findOddDigitsNumsSum(n);
            System.out.println("Sum of " + n + "-digits numbers with only odd digits: " + oddSum);
            int evenDigitsInSum = solution.findEvenDigitsInSum(oddSum);
            System.out.println("Number of even digits in sum: " + evenDigitsInSum);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // От 1 до 9 разрядов включительно.
    public int generateRandomNum() {
        return (int) (1 + Math.random() * 9);
    }

    public long findOddDigitsNumsSum(int n) throws Exception {
        if (n < 1) {
            throw new Exception("We can't find only odd-digits numbers for " + n + "-digits number.");
        }

        long firstNum = calcFirstNum(n);
        long oddSum = 0;
        for (long i = firstNum; i < (firstNum * 10); i++) {
            if (isOdd(i)) {
                oddSum += i;
            }
        }

        return  oddSum;
    }

    public int findEvenDigitsInSum(long oddSum) {
        int evenDigitsCounter = 0;

        while (oddSum > 0) {
            if ((oddSum % 10) % 2 == 0) {
                evenDigitsCounter++;
            }
            oddSum /= 10;
        }

        return evenDigitsCounter;
    }

    private long calcFirstNum(int n) {
        long num = 1;

        for (int i = 1; i < n; i++) {
            num *= 10;
        }

        return num;
    }

    private boolean isOdd(long num) {
        boolean isOdd = true;

        while (num > 0) {
            if ((num % 10) % 2 == 0) {
                isOdd = false;
                break;
            }
            num /= 10;
        }

        return isOdd;
    }
}