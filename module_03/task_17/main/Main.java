package by.yevstratyev.java_intro.module_03.task_17.main;

import by.yevstratyev.java_intro.module_03.task_17.bean.NodeInfo;
import by.yevstratyev.java_intro.module_03.task_17.bean.XmlDocument;
import by.yevstratyev.java_intro.module_03.task_17.logic.XmlParser;
import by.yevstratyev.java_intro.module_03.task_17.view.NodeView;

/*
 * Module 3. Strings and basics of text processing
 * Работа с регулярными выражениями (Pattern, Matcher)
 * Задача 2
 * Условие:
 *  Дана строка, содержащая следующий текст (xml-документ):
 *      <notes>
 *          <note id = \"1\">
 *              <to>Вася</to>
 *              <from>Света</from>
 *              <heading>Напоминание</heading>
 *              <body>Позвони мне завтра!</body>
 *          </note>
 *          <note id = \"2\">
 *              <to>Петя</to>
 *              <from>Маша</from>
 *              <heading>Важное напоминание</heading>
 *              <body/>
 *          </note>
 *      </notes>
 *  Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его тип
 *  (открывающий тег, закрывающий тег, содержимое тега, тег без тела). Пользоваться готовыми парсерами XML
 *  для решения данной задачи нельзя.
 */

public class Main {
    public static void main(String[] args) {
        XmlDocument doc = new XmlDocument();
        doc.setContent("<notes>" +
                            "<note id = \"1\">" +
                                "<to>Вася</to>" +
                                "<from>Света</from>" +
                                "<heading>Напоминание</heading>" +
                                "<body>Позвони мне завтра!</body>" +
                            "</note>" +
                            "<note id = \"2\">" +
                                "<to>Петя</to>" +
                                "<from>Маша</from>" +
                                "<heading>Важное напоминание</heading>" +
                                "<body/>" +
                            "</note>" +
                        "</notes>");

        XmlParser parser = new XmlParser();
        NodeInfo[] nodes = parser.parse(doc);

        NodeView view = new NodeView();
        view.print(nodes);
    }
}