import java.util.ArrayList;

/**Contains the main method to go through the first link on each linked-to page*/
public class FirstLink {
    private static void print(ArrayList<String> links) {
        for (String link : links) {
            System.out.print(link.substring(link.indexOf("/wiki/")+6) + ", ");
        }
        System.out.print("\n");
    }
    public static void main(String[] args) {
        String current = args[0];
        String target = args[1];
        ArrayList<String> previous = new ArrayList<String>();
        previous.add(current);
        while (!current.equals(target)) {
            ArrayList<String> allLinks = LinkFinder.getInternalLinks(current);
            int i = 0;
            while (allLinks.get(i).equals(current)) {i++;}
            current = LinkFinder.getInternalLinks(current).get(i);
            if (previous.contains(current)) {
                break;
            }
            previous.add(current);
            print(previous);
        }
    }
}
