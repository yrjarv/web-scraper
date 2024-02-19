/**
 * The main program
 */
public class WebScraper {
    public static void main(String[] args) {
        URLScanner first = new URLScanner(args[0]);
        first.getAllLinks();
    }
}