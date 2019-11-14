package by.yevstratyev.java_intro.module_03.task_16.view;

import by.yevstratyev.java_intro.module_03.task_16.bean.Text;

public class TextView {
    public void print(Text text) {
        if (text == null) {
            System.err.println("Please specify an object to print.");
        } else {
            System.out.println(text.getContent().trim());
        }
    }
}