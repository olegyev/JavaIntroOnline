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

        sortParagraphs(paragraphs, countSentences(paragraphs));

        StringBuilder result = new StringBuilder();
        for (String paragraph : paragraphs) {
            result.append(paragraph.trim()).append("\n");
        }

        paragraphs = null;

        return new Text(result.toString());
    }

    private static int[] countSentences(String[] paragraphs) {
        int[] sentencesNums = new int[paragraphs.length];
        int counter = 0;

        Pattern sentenceEnd = Pattern.compile("[.?!]+(\\s+|$)");

        for (int i = 0; i < paragraphs.length; i++) {
            Matcher matcher = sentenceEnd.matcher(paragraphs[i]);
            while (matcher.find()) {
                counter++;
            }
            sentencesNums[i] = counter;
            counter = 0;
        }

        return sentencesNums;
    }

    private static void sortParagraphs(String[] paragraphs, int[] sentencesNums) {
        for (int step = sentencesNums.length / 2; step >= 1; step /= 2) {
            for (int inc = 0; inc < step; inc++) {
                for (int i = inc; i < sentencesNums.length - step; i += step) {
                    for (int j = i + step; j - step >= 0; j -= step) {
                        if (sentencesNums[j] < sentencesNums[j - step]) {
                            int index = sentencesNums[j];
                            sentencesNums[j] = sentencesNums[j - step];
                            sentencesNums[j - step] = index;

                            String sentence = paragraphs[j];
                            paragraphs[j] = paragraphs[j - step];
                            paragraphs[j - step] = sentence;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }
}