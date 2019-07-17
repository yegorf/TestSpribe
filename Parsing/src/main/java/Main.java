import database.Headings;
import threads.ParsingThread;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException, InterruptedException {
        HashSet<String> headings = Headings.getAllHeadings();
        Thread[] threads = new Thread[5];

        int i = 0;
        for (String heading : headings) {
            threads[i] = new Thread(new ParsingThread(heading));
            i++;
        }
        for (Thread thread : threads) {
            thread.start();
            thread.join();
        }
    }
}
