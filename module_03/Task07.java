package by.yevstratyev.java_intro.module_03;

/*
 * Module 3. Strings and basics of text processing
 * Работа со строкой как с объектом типа String или StringBuilder
 * Задача 2
 * Условие:
 *  В строке вставить после каждого символа 'a' символ 'b'.
 */

public class Task07 {
    public static void main(String[] args) {
        Task07 solution = new Task07();
        System.out.println("Initial string:");
        String string = "aaaaa";
        System.out.println(string);

        System.out.println("A string modified with 'charAt':");
        StringBuilder withCharAt = solution.insertWithCharAt(string, 'a', 'b');
        System.out.println(withCharAt);

        try {
            System.out.println("A string modified with 'indexOf':");
            StringBuilder withIndexOf = solution.insertWithIndexOf(string, "a", 'b');
            System.out.println(withIndexOf);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    public StringBuilder insertWithCharAt(String string, char target, char replacement) {
        StringBuilder sb = new StringBuilder(string);

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == target) {
                sb.insert(i + 1, replacement);
            }
        }

        return sb;
    }

    public StringBuilder insertWithIndexOf(String string, String target, char replacement) throws Exception {
        if (target.isEmpty()) {
            throw new Exception("Please indicate the character/-s to be replaced.");
        }

        StringBuilder sb = new StringBuilder(string);
        int i = -1;

        while ((i = sb.indexOf(target, i + 1)) != -1) {
            sb.insert(i + 1, replacement);
        }

        return sb;
    }
}