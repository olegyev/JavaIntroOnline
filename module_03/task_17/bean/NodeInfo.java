package by.yevstratyev.java_intro.module_03.task_17.bean;

public class NodeInfo {
    private String content;
    private String type;

    public NodeInfo(String content, String type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeInfo that = (NodeInfo) o;
        return (content == that.content || (content != null && content.equals(that.content))) &&
                (type == that.type || (type != null && type.equals(that.type)));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = content != null ? content.hashCode() : 0;
        result = prime * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "NodeInfo {" + "content = '" + content + "'; " +
                "type = '" + type + "'}";
    }
}