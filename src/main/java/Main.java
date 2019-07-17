import database.Headings;
import threads.ParsingThread;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        HashSet<String> headings = Headings.getAllHeadings();
        ParsingThread[] threads = new ParsingThread[5];

        int i = 0;
        for (String h : headings) {
            threads[i] = new ParsingThread(h);
            i++;
        }

        for (ParsingThread parsingThread : threads) {
            new Thread(parsingThread).start();
        }
    }
}
