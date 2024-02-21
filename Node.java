import java.util.ArrayList;

/**
 * A node, has a link and several children that are also Nodes. This gives you a hierarcy of nodes.
 */
public class Node {
    /**The Wikipedia link*/
    String link;
    /**All the nodes that the Node links to*/
    ArrayList<Node> children;
    /**
     * Constructor
     * @param link The Wikipedia link that the node is part of
     */
    public Node(String link) {
        this.link = link;
        children = new ArrayList<Node>();
    }
    /**
     * Adds a single node to the children of this node
     * @param child The child node to add
     */
    public void addChild(Node child) {
        children.add(child);
    }
    /**
     * Adds nodes to the children of this node
     * @param links An ArrayList of the links the children nodes should have
     */
    public void addChild(ArrayList<String> links) {
        for (String link : links) {
            addChild(new Node(link));
        }
    }
    @Override
    /**
     * toString method
     */
    public String toString() {
        String result = "|---" + link.substring(29) + "\n";
        for (Node child : children) {
            result += child.toString().indent(4);
        }
        return result;
    }
}
