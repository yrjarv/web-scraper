/**Contains the main method for generating a tree of links*/
public class Tree {
    /**
     * The main program. Scrapes Wikipedia with a depth of 2, in order to preserve system resources.
     * Prints a simple tree of what pages are linked to from the different pages.
     * @param args Should only contain one String, the link to the starting Wikipedia page
     */
    public static void main(String[] args) {
        String link = args[0];
        Node main = new Node(link);
        main.addChild(LinkFinder.getInternalLinks(link));
        System.out.println(main);
        System.out.println(main.children.size());
        int i = 0;
        for (Node child : main.children) {
            child.addChild(LinkFinder.getInternalLinks(child.link));
            System.out.println(i);
            i++;
        }
        System.out.println(main);
    }
}
