package MonthlyChallenges.Year23.January;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPathWithDifferentAdjacentCharacters {
    public static void main(String[] args) {
        LongestPathWithDifferentAdjacentCharacters solution = new LongestPathWithDifferentAdjacentCharacters();

        int[] parent0 = {-1, 0, 0, 1, 1, 2};
        String s0 = "abacbe";

        System.out.println(solution.longestPath(parent0, s0));

        int[] parent2 = {-1, 0, 0, 0};
        String s2 = "azbc";

        System.out.println("Result " + solution.longestPath(parent2, s2));
    }

    private int max_distance = 0;

    /**
     * LeetCode #2246. Longest Path With Different Adjacent Characters.
     *
     * @param parent - an array of parent of i-th node.
     * @param s      - a String of values of each node.
     * @return - the length of the longest path in the tree such that no pair of adjacent nodes on the path have the
     * same character assigned to them.
     */
    public int longestPath(int[] parent, String s) {
        if (parent.length == 1) return 1;

        Map<Integer, TreeNode> tree = buildTree(parent, s);

        for (Map.Entry<Integer, TreeNode> node : tree.entrySet()) {
            max_distance = Math.max(max_distance, getDistance(node.getValue()));
        }

        return max_distance;
    }

    private int getDistance(TreeNode node) {
        return dfs(node, null);
    }

    private int dfs(TreeNode node, TreeNode parent) {
        int distance = 0;

        for (TreeNode neighbour : node.getNeighbours()) {
            if (neighbour == parent) continue;

            int curNumberOfNodes;
            if (node.distances.containsKey(neighbour)) {
                curNumberOfNodes = node.distances.get(neighbour);
            } else {
                curNumberOfNodes = dfs(neighbour, node);
                node.distances.put(neighbour, curNumberOfNodes);
            }

            distance = Math.max(distance, curNumberOfNodes);
        }

        return distance + 1;
    }

    private Map<Integer, TreeNode> buildTree(int[] parents, String s) {
        char[] values = s.toCharArray();

        Map<Integer, TreeNode> nodes = new HashMap<>();

        for (int i = 0; i < parents.length; i++) {
            TreeNode node = new TreeNode(values[i], i);
            nodes.put(i, node);
        }

        for (int i = 1; i < parents.length; i++) {
            TreeNode node = nodes.get(i);
            TreeNode parent = nodes.get(parents[i]);

            if (values[i] == values[parents[i]]) {
                continue;
            }

            node.addNeighbours(parent);
            parent.addNeighbours(node);
        }

        return nodes;
    }

    class TreeNode {
        public final char value;
        public final int idx;
        List<TreeNode> neighbours = new ArrayList<>();
        Map<TreeNode, Integer> distances = new HashMap<>();

        TreeNode(char value, int idx) {
            this.value = value;
            this.idx = idx;
        }

        void addNeighbours(TreeNode neighbour) {
            this.neighbours.add(neighbour);
        }

        List<TreeNode> getNeighbours() {
            return this.neighbours;
        }
    }
}
