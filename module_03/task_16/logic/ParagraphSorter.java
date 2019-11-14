package by.yevstratyev.java_intro.module_03.task_16.logic;

import by.yevstratyev.java_intro.module_03.task_16.bean.Text;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphSorter {
    public Text sort(Text text) {
        if (text == null) {
            return null;
        }

        Pattern newline = Pattern.compile("\\n");
        String[] paragraphs = newline.split(text.getContent());

        shell(paragraphs, countSentences(paragraphs));

        StringBuilder result = new StringBuilder();
        for (String paragraph : paragraphs) {
            result.append(paragraph.trim()).append("\n");
        }

        paragraphs = null;

        return new Text(result.toString());
    }

    private static int[] countSentences(String[] paragraphs) {
        int[] sentencesCount = new int[paragraphs.length];
        int counter = 0;

        Pattern sentenceEnd = Pattern.compile("[.?!]+(\\s+|$)");

        for (int i = 0; i < paragraphs.length; i++) {
            Matcher matcher = sentenceEnd.matcher(paragraphs[i]);
            while (matcher.find()) {
                counter++;
            }
            sentencesCount[i] = counter;
            counter = 0;
        }

        return sentencesCount;
    }

    private static void shell(String[] paragraphs, int[] sentencesCounter) {
        for (int step = sentencesCounter.length / 2; step >= 1; step /= 2) {
            for (int inc = 0; inc < step; inc++) {
                for (int i = inc; i < sentencesCounter.length - step; i += step) {
                    for (int j = i + step; j - step >= 0; j -= step) {
                        if (sentencesCounter[j] < sentencesCounter[j - step]) {
                            int indices = sentencesCounter[j];
                            sentencesCounter[j] = sentencesCounter[j - step];
                            sentencesCounter[j - step] = indices;

                            String sentences = paragraphs[j];
                            paragraphs[j] = paragraphs[j - step];
                            paragraphs[j - step] = sentences;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }
}