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
        Task10 solution = new Task10();
        System.out.println("Initial string:");
        String string = "Fb aw sas, aaaa: dddd - aa.";
        System.out.println(string);

        System.out.println("The number of 'a' (with iteration): " + solution.countIterChars(string, 'a'));
        System.out.println("The number of 'a' (in line): " + solution.countLineChars(string, "a"));
    }

    public int countIterChars(String string, char toCount) {
        int numOfChars = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == toCount) {
                numOfChars++;
            }
        }

        return numOfChars;
    }

    public int countLineChars(String string, String toCount) {
        return string.length() - string.replace(toCount, "").length();
    }
}