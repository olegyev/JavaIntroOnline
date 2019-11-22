package by.yevstratyev.java_intro.module_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Module 3. Strings and basics of text processing
 * Работа со строкой как с объектом типа String или StringBuilder
 * Задача 8
 * Условие:
 *  Вводится строка слов, разделенных пробелами. Найти самое длинное слово
 *  и вывести его на экран. Случай, когда самых длинных слов может быть
 *  несколько, не обрабатывать.
 */

public class Task13 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            do {
                System.out.println("Please enter a string of words separated by spaces " +
                                   "(only words with latin or cyrillic letters are allowed):");
                input = reader.readLine();
            } while (input.isEmpty());

            Task13 solution = new Task13();

            String theLongestWord = solution.findLongestWord(input);
            System.out.println("The longest word is \"" + theLongestWord + "\". " +
                               "Its length is " + theLongestWord.length() + " letters.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String findLongestWord(String string) {
        final int UP_LATIN_A = 65;
        final int UP_LATIN_Z = 90;
        final int LOW_LATIN_A = 97;
        final int LOW_LATIN_Z = 122;
        final int CYRIL_FIRST_LETTER = 1040;
        final int CYRIL_LAST_LETTER = 1103;
        final int UP_CYRIL_YO = 1025;
        final int LOW_CYRIL_YO = 1105;

        int ctrl = 0;
        int charsCounter = 0;
        int lastIndex = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= UP_LATIN_A && string.charAt(i) <= UP_LATIN_Z
                    || string.charAt(i) >= LOW_LATIN_A && string.charAt(i) <= LOW_LATIN_Z
                        || string.charAt(i) >= CYRIL_FIRST_LETTER && string.charAt(i) <= CYRIL_LAST_LETTER
                            || string.charAt(i) == UP_CYRIL_YO || string.charAt(i) == LOW_CYRIL_YO) {
                // или: is (Character.isLetter(string.charAt(i))) {...}
                // Счел такое условие (является ли символ буквой) более надежным, чем проверка на пробел
                // (if (string.charAt(i) != ' ') {...}), т.к. оно позволяет исключить подсчет знаков препинания
                // и др. символов при некорректном вводе (условие предполагает только слова и пробелы).
                ctrl++;
            } else {
                ctrl = 0;
            }

            if (ctrl > charsCounter) {
                charsCounter = ctrl;
                lastIndex = i;
            }
        }

        return string.substring(lastIndex - charsCounter + 1, lastIndex + 1);
    }
}