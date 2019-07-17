package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private String author;
    private String dateTime;
    private String topic;
    private StringBuffer content = new StringBuffer();
    private String views;

    public synchronized void addContent(String text) {
        content.append(text).append("\n");
    }

    @Override
    public synchronized String toString() {
        return "Author: " + author + "\n"
                + "Date and time: " + dateTime + "\n"
                + "Views: " + views + "\n"
                + "Topic: " + topic + "\n"
                + "Content: " + content.toString() + "\n";
    }
}
