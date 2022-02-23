package MonthlyChallenges.Year22.February;

import java.util.*;

public class CloneGraph {

    /**
     * LeetCode #133. Clone Graph.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param node - a root of a graph.
     * @return - a root of a deep copy graph.
     */
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        ArrayDeque<Node> queue = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();
        Map<Node, Node> originalToCopy = new HashMap<>();

        // Copy of a root of the original graph
        Node copyRoot = new Node(node.val);

        originalToCopy.put(node, copyRoot);
        queue.offer(node);

        while (!queue.isEmpty()) {
            // Current node of the original graph
            Node curNode = queue.poll();

            if (visited.contains(curNode)) continue;    // already added all neighbours
            visited.add(curNode);

            // Creating a copy of current original node if it wasn`t already created
            Node copyNode = originalToCopy.getOrDefault(curNode, new Node(curNode.val));

            // Adding copies of neighbours of a node from original graph to the list of neighbours of a copy-node
            for (Node neighbour : curNode.neighbors) {
                // Creating a copy of a neighbour of original node if it wasn`t already created.
                Node copyNeighbour = originalToCopy.getOrDefault(neighbour, new Node(neighbour.val));

                copyNode.neighbors.add(copyNeighbour);

                // Storing a copy of a neighbour if it wasn`t creating before.
                originalToCopy.putIfAbsent(neighbour, copyNeighbour);

                if (!visited.contains(neighbour)) queue.offer(neighbour);
            }
        }

        return copyRoot;
    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
