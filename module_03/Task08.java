package by.yevstratyev.java_intro.module_03;

/*
 * Module 3. Strings and basics of text processing
 * Работа со строкой как с объектом типа String или StringBuilder
 * Задача 3
 * Условие:
 *  Проверить, является ли заданное слово палиндромом.
 */

public class Task08 {
    public static void main(String[] args) {
        String string = "radar";

        if (isPalindrome(string)) {
            System.out.println("The word \"" + string + "\" is a palindrome.");
        } else {
            System.out.println("The word \"" + string + "\" is not a palindrome.");
        }
    }

    public static boolean isPalindrome(String string) {
        boolean isPalindrome = true;
        String toCheck = string.trim().toLowerCase();

        for (int i = 0, j = toCheck.length() - 1; i < toCheck.length() / 2; i++, j--) {
            if (toCheck.charAt(i) != toCheck.charAt(j)) {
                isPalindrome = false;
                break;
            }
        }

        toCheck = null;

        return isPalindrome;
    }
}