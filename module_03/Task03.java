package by.yevstratyev.java_intro.module_03;

/*
 * Module 3. Strings and basics of text processing
 * Работа со строкой как с массивом символов
 * Задача 3
 * Условие:
 *  В строке найти количество цифр.
 */

public class Task03 {
    public static void main(String[] args) {
        System.out.println("Initial string:");
        String string = "Here are digits: 1234567890. Here also: 5.0, 1/2. And here: 0987654321.";
        System.out.println(string);

        System.out.println("Number of digits in the string:");
        Task03 solution = new Task03();
        int numOfDigits = solution.countDigitsInString(string);
        System.out.println(numOfDigits);
    }

    // Алгоритм подсчитывает только арабские цифры.
    // Метод Character.isDigit() счел возможным не использовать в обучающих целях.
    public int countDigitsInString(String string) {
        final int ZERO = 0x0030;
        final int NINE = 0x0039;

        char[] chars = string.toCharArray();
        int digitsCounter = 0;

        for (char element : chars) {
            if (element >= ZERO && element <= NINE) { // или: if (Character.isDigit(element)) {...}
                digitsCounter++;
            }
        }

        return digitsCounter;
    }
}