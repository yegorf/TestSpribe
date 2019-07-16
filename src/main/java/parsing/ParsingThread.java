package parsing;

import java.io.IOException;

public class ParsingThread implements Runnable {
    private String url;

    public ParsingThread(String url) {
        this.url = url;
    }

    public void run() {
        System.out.println("Started " + Thread.currentThread().getName());
        Parser parser = null;

        try {
            parser = new Parser(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
