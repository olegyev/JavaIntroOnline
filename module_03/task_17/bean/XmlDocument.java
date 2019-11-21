package by.yevstratyev.java_intro.module_03.task_17.bean;

public class XmlDocument {
    private String content;

    public XmlDocument() {
        content = "";
    }

    public XmlDocument(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XmlDocument that = (XmlDocument) o;
        return content == that.content || (content != null && content.equals(that.content));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = content != null ? content.hashCode() : 0;
        return (prime * result);
    }

    @Override
    public String toString() {
        return "XmlDocument {" + "content = '" + content + "'}";
    }
}