package by.yevstratyev.java_intro.module_03;

/*
 * Module 3. Strings and basics of text processing
 * Работа со строкой как с объектом типа String или StringBuilder
 * Задача 6
 * Условие:
 *  Из заданной строки получить новую, повторив каждый символ дважды.
 */

public class Task11 {
    public static void main(String[] args) {
        Task11 solution = new Task11();
        System.out.println("Initial string:");
        String string = "This is the initial string.";
        System.out.println(string);

        System.out.println("\nDouble chars string with iteration:");
        System.out.println(solution.doubleIterChars(string));

        System.out.println("\nDouble chars string with 'replaceAll' method:");
        System.out.println(solution.doubleReplaceChars(string));

        System.out.println("\nDouble chars string with 'substring' and 'repeat' methods:");
        System.out.println(solution.doubleRepeatChars(string));
    }

    public String doubleIterChars(String string) {
        StringBuilder sb = new StringBuilder(string.length() * 2);

        for (int i = 0, j = 0; i < string.length(); i = (j - j / 2), j++) {
            sb.append(string.charAt(i));
        }

        return sb.toString();
    }

    public String doubleReplaceChars(String string) {
        return string.replaceAll(".", "$0$0");
    }

    public String doubleRepeatChars(String string) {
        StringBuilder sb = new StringBuilder(string.length() * 2);

        for (int i = 0; i < string.length(); i++) {
            sb.append(string.substring(i, i + 1).repeat(2));
        }

        return sb.toString();
    }
}