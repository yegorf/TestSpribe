package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private String author;
    private String dateTime;
    private String topic;
    private String content;

    @Override
    public String toString() {
        return "Author: " + author + "\n"
                + "Date and time: " + dateTime + "\n"
                + "Topic: " + topic + "\n"
                + "Content: " + content + "\n";
    }
}
