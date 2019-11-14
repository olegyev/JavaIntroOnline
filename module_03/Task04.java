package by.yevstratyev.java_intro.module_03;

/*
 * Module 3. Strings and basics of text processing
 * Работа со строкой как с массивом символов
 * Задача 4
 * Условие:
 *  В строке найти количество чисел.
 */

public class Task04 {
    public static void main(String[] args) {
        System.out.println("Initial string:");
        String string = "Here are numbers: 0, 1/2, 1, 23, 34, .345, 567, 777.89. Here also: 5.0, 55. And here: 0987, 10.";
        System.out.println(string);

        System.out.println("Number of numbers in the string:");
        int numOfNums = countNumsInString(string);
        System.out.println(numOfNums);
    }

    // Алгоритм подсчитывает только числа, состоящие из арабских цифр.
    // В качестве разделителей для дробных чисел использованы знаки '.' и '/'.
    // Метод Character.isDigit() счел возможным не использовать в обучающих целях.
    public static int countNumsInString(String string) {
        final int ZERO = 48;
        final int NINE = 57;

        char[] chars = string.toCharArray();
        int numsCounter = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= ZERO && chars[i] <= NINE) {
                numsCounter++;
                while ((i + 1) < chars.length && ((chars[i] >= ZERO && chars[i] <= NINE) || chars[i] == '.' || chars[i] == '/')) {
                    if (chars[i] == '.' && chars[i + 1] == '.' || chars[i] == '/' && chars[i + 1] == '/'
                            || chars[i] == '.' && chars[i + 1] == '/' || chars[i] == '/' && chars[i + 1] == '.') {
                        break;
                    }
                    i++;
                }
            }
        }

        return numsCounter;
    }
}