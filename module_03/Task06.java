package by.yevstratyev.java_intro.module_03;

/*
 * Module 3. Strings and basics of text processing
 * Работа со строкой как с объектом типа String или StringBuilder
 * Задача 1
 * Условие:
 *  Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.
 */

public class Task06 {
    public static void main(String[] args) {
        System.out.println("Initial string:");
        String string = "   How many     spaces  do          we  have here   ?      ";
        System.out.println(string);

        Task06 solution = new Task06();
        int maxSpacesSequenceLength = solution.countSequences(string, ' ');
        System.out.println("Maximum sequence of spaces has length " + maxSpacesSequenceLength + ".");
    }

    public int countSequences(String string, char target) {
        int repeatsCounter = 0;
        int ctrl = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == target) { // также можно: if (i == string.indexOf(target, i)) {...}
                ctrl++;
            } else {
                ctrl = 0;
            }

            if (ctrl > repeatsCounter) {
                repeatsCounter = ctrl;
            }
        }

        return repeatsCounter;
    }
}