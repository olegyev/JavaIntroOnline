package by.yevstratyev.java_intro.module_03.task_17.logic;

import by.yevstratyev.java_intro.module_03.task_17.bean.NodeInfo;
import by.yevstratyev.java_intro.module_03.task_17.bean.XmlDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlParser {
    public NodeInfo[] parse(XmlDocument doc) {
        if (doc == null || doc.getContent().isEmpty()) {
            return null;
        }

        List<String> nodes = new ArrayList<String>();

        Pattern node = Pattern.compile("<.*?>|[^<]+"); // или: <[^>]+>|[^<]+
        Matcher matcher = node.matcher(doc.getContent());
        while (matcher.find()) {
            nodes.add(doc.getContent().substring(matcher.start(), matcher.end()));
        }

        return identifyNodes(nodes).toArray(new NodeInfo[0]);
    }

    // Алгоритм не рассматривает атрибуты тега как отдельный узел,
    // т.к. это не предусмотрено условием задачи.
    private List<NodeInfo> identifyNodes(List<String> nodes) {
        List<NodeInfo> result = new ArrayList<NodeInfo>();

        for (String nodeToCheck : nodes) {
            if (nodeToCheck.matches("<((?i)(?!xml))([a-zA-Z]+[[^\\s]&&[^/]]*)>")) {
                String name = nodeToCheck.substring(1, nodeToCheck.length() - 1);
                result.add(new NodeInfo("tag name : " + name, "opening tag"));
            } else if (nodeToCheck.matches("<((?i)(?!xml))([a-zA-Z]+[[^\\s]&&[^/]]*)(\\s+.*)=(\\s+)?(\".*\")>")) {
                String name = nodeToCheck.substring(1, nodeToCheck.indexOf(" "));
                String attribute = nodeToCheck.substring(nodeToCheck.indexOf(" ") + 1, nodeToCheck.length() - 1);
                result.add(new NodeInfo("tag name : " + name + ", tag attribute : " + attribute.trim(), "opening tag"));
            } else if (nodeToCheck.matches("</((?i)(?!xml))[a-zA-Z]+[[^\\s]&&[^/]]*>")) {
                String name = nodeToCheck.substring(2, nodeToCheck.length() - 1);
                result.add(new NodeInfo("tag name : " + name, "closing tag"));
            } else if (nodeToCheck.matches("<((?i)(?!xml))([a-zA-Z]+[^\\s]*)\\s*/>")) {
                String name = nodeToCheck.substring(1, nodeToCheck.length() - 2);
                result.add(new NodeInfo("tag name : " + name.trim(), "empty tag"));
            } else if (nodeToCheck.matches("[^<]+")) {
                String nodeContent = result.get(result.size() - 1).getContent();
                int firstIndex = nodeContent.indexOf(":") + 2;
                int lastIndex = nodeContent.contains("attribute") ? nodeContent.indexOf(",") : nodeContent.length();
                String tagName = nodeContent.substring(firstIndex, lastIndex);
                result.add(new NodeInfo(nodeToCheck, "tag's \"" + tagName + "\" content"));
            }
        }

        return result;
    }
}