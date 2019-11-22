package by.yevstratyev.java_intro.module_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Module 3. Strings and basics of text processing
 * Работа со строкой как с объектом типа String или StringBuilder
 * Задача 9
 * Условие:
 *  Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке.
 *  Учитывать только английские буквы.
 */

public class Task14 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            do {
                System.out.println("Please enter a string (only latin letters are allowed):");
                input = reader.readLine();
            } while (input.isEmpty());

            Task14 solution = new Task14();

            System.out.println("The number of lowercase letters is " + solution.countLowCaseLetters(input) + ".");
            System.out.println("The number of uppercase letters is " + solution.countUpperCaseLetters(input) + ".");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int countLowCaseLetters(String string) {
        int lowLettersCounter = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= '\u0061' && string.charAt(i) <= '\u007A') {
                // или: if (Character.isLowerCase(string.charAt(i))) {...}
                lowLettersCounter++;
            }
        }

        return lowLettersCounter;
    }

    public int countUpperCaseLetters(String string) {
        int upperLettersCounter = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= '\u0041' && string.charAt(i) <= '\u005A') {
                // или: if (Character.isUpperCase(string.charAt(i))) {...}
                upperLettersCounter++;
            }
        }

        return upperLettersCounter;
    }
}