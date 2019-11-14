package by.yevstratyev.java_intro.module_03;

/*
 * Module 3. Strings and basics of text processing
 * Работа со строкой как с объектом типа String или StringBuilder
 * Задача 5
 * Условие:
 *  Подсчитать, сколько раз среди символов заданной строки встречается буква "a".
 */

public class Task10 {
    public static void main(String[] args) {
        System.out.println("Initial string:");
        String string = "Fb aw sas, aaaa: dddd - aa.";
        System.out.println(string);

        System.out.println("The number of 'a' (with iteration): " + countIterChars(string, 'a'));
        System.out.println("The number of 'a' (in line): " + countLineChars(string, "a"));
    }

    public static int countIterChars(String string, char toCount) {
        int numOfChars = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == toCount) {
                numOfChars++;
            }
        }

        return numOfChars;
    }

    public static int countLineChars(String string, String toCount) {
        return string.length() - string.replace(toCount, "").length();
    }
}