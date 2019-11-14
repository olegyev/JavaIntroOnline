package by.yevstratyev.java_intro.module_03.task_16.bean;

public class Text {
    private String content;

    public Text() {
        content = "";
    }

    public Text(String content) {
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
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Text that = (Text) o;
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
        return "Text {" + "content = '" + content + "'}";
    }
}