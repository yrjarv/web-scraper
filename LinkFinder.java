import java.util.ArrayList;

/**
 * A class containing a static method to find all internal Wikipedia links on a Wikipedia article
 */
public class LinkFinder {
    /**
     * Finds and gets all the intenal Wikipedia links that are on the startURL page
     * @param startURL The Wikipedia URL that the scraper should start at
     * @return An ArrayList of absolute links to the linked-to Wikipedia pages
     */
    public static ArrayList<String> getInternalLinks(String startURL) {
        String prefix = startURL.substring(0, startURL.indexOf("/wiki/"));
        ArrayList<String> wikipediaLinks = new ArrayList<String>();
        try {
            URLScanner link = new URLScanner(startURL);
            ArrayList<String> resultLinks = link.getAllLinks();
            for (String currentLink : resultLinks) {
                if (
                    currentLink.contains("/wiki/")
                    && !currentLink.contains(":")
                    && !currentLink.contains("wikimedia")
                    && !currentLink.contains(".m.wikipedia.org")
                    && !currentLink.contains("Main_Page")
                    ) {
                    wikipediaLinks.add(prefix + currentLink);
                }
            }
        } catch (Exception e) {
            System.err.println("Not working: " + e);
        }
        return wikipediaLinks;
    }
}