package by.yevstratyev.java_intro.module_03.task_17.view;

import by.yevstratyev.java_intro.module_03.task_17.bean.NodeInfo;

public class NodeView {
    public void print(NodeInfo[] nodes) {
        if (nodes == null) {
            System.err.println("Please specify an object to print.");
        } else {
            for (NodeInfo node : nodes) {
                System.out.println(node.toString());
            }
        }
    }
}