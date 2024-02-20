import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Takes in a string that represents a URL 
 */
public class URLScanner {
    /**The scanner for the URL*/
    Scanner scanner;

    /**
     * Constructor, sets scanner
     * @param urlString The String with the URL this scanner should work for
     * @throws Exception If the URL did not work for some reason, a generic Exception is thrown.
     */
    public URLScanner(String urlString) throws Exception {
        try {
            URL url = new URI(urlString).toURL();
            scanner = new Scanner(url.openStream());

        } catch (URISyntaxException | IOException e) {
            throw new Exception("Bad link: " + urlString);
        }
    }
    /**
     * Gets all the target pages for all the links on the page
     * @return A list of Strings, all being URLs to other pages
     */
    public ArrayList<String> getAllLinks() {
        ArrayList<String> result = new ArrayList<String>();
        Pattern hrefPattern = Pattern.compile("href=\"([^\"]*)\"", Pattern.CASE_INSENSITIVE);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Matcher matcher = hrefPattern.matcher(line);
            while (matcher.find()) {
                String href = matcher.group(1);
                result.add(href);
                System.out.println("Link: " + href);
            }
        }
        return result;
    }
}
