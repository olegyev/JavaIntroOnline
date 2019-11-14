package by.yevstratyev.java_intro.module_02;

/*
 * Module 2. Algorithmization
 * Декомпозиция с использованием методов (подпрограммы)
 * Задача 17
 * Условие:
 *  Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д.
 *  Сколько таких действий надо произвести, чтобы получился нуль? Для решения задачи использовать декомпозицию.
 */

public class Task51 {
    public static void main(String[] args) {
        int num = generateRandomNum();
        try {
            int numOfSubtractions = subtractToZero(num);
            if (numOfSubtractions == 1) {
                System.out.println("It is " + numOfSubtractions + " subtraction between " + num + " and zero.");
            } else {
                System.out.println("There are " + numOfSubtractions + " subtractions between " + num + " and zero.");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // От 0 до 10000 включительно.
    public static int generateRandomNum() {
        return (int) (Math.random() * 10001);
    }

    public static int subtractToZero(int num) throws Exception {
        if (num < 0) {
            throw new Exception("We need to add, not subtract.");
        }

        int counter = 0;

        while (num > 0) {
            num -= calcSumOfDigits(num);
            counter++;
        }

        return counter;
    }

    private static int calcSumOfDigits(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}