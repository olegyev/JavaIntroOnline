package by.yevstratyev.java_intro.module_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Module 3. Strings and basics of text processing
 * Работа со строкой как с объектом типа String или StringBuilder
 * Задача 7
 * Условие:
 *  Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы.
 *  Например, если было введено "abc cde def", то должно быть выведено "abcdef".
 */

public class Task12 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            do {
                System.out.println("Please enter a string:");
                input = reader.readLine();
            } while (input.isEmpty());

            Task12 solution = new Task12();

            System.out.println("\nA string without spaces and repeated chars with StringBuilder:");
            System.out.println(solution.removeCharDuplicatesWithStrBuilder(solution.removeSpaces(input)));

            System.out.println("\nA string without spaces and repeated chars with concatenation:");
            System.out.println(solution.removeCharDuplicatesWithConcat(solution.removeSpaces(input)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String removeCharDuplicatesWithStrBuilder(String string) {
        StringBuilder noDuplicates = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            String sub = string.substring(i, i + 1);
            if (noDuplicates.indexOf(sub) == -1) {
                noDuplicates.append(sub);
            }
        }

        return noDuplicates.toString();
    }

    public String removeCharDuplicatesWithConcat(String string) {
        String noDuplicates = new String();

        for (int i = 0; i < string.length(); i++) {
            if (!noDuplicates.contains(String.valueOf(string.charAt(i)))) {
                noDuplicates = noDuplicates.concat(String.valueOf(string.charAt(i)));
            }
        }

        return noDuplicates;
    }

    public String removeSpaces(String string) {
        return string.replaceAll(" ", "");
    }
}