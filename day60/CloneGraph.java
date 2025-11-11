package day60;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        neighbors = new ArrayList<>();
    }
    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }
}

public class CloneGraph {
    private Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);

        Node clone = new Node(node.val);
        map.put(node, clone);

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.neighbors.addAll(List.of(n2, n3));
        n2.neighbors.add(n3);
        n3.neighbors.add(n1);

        CloneGraph cg = new CloneGraph();
        Node cloned = cg.cloneGraph(n1);
        System.out.println("Graph cloned successfully for node: " + cloned.val);
    }
}
