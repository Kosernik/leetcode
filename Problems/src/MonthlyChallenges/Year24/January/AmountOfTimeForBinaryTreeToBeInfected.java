package MonthlyChallenges.Year24.January;

import Utils.TreeNode;

import java.util.*;

public class AmountOfTimeForBinaryTreeToBeInfected {

    /**
     * LeetCode №2385. Amount of Time for Binary Tree to Be Infected.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root  - a root of a binary tree. All nodes have unique values.
     * @param start - the value of the starting node.
     * @return - the number of minutes needed for the entire tree to be infected.
     */
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> graph = convertTree(root);

        return bfs(start, graph);
    }

    private int bfs(int start, Map<Integer, List<Integer>> graph) {
        int result = -1;

        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                Integer node = queue.removeFirst();

                List<Integer> neighbours = graph.get(node);
                for (Integer neighbour : neighbours) {
                    if (!visited.contains(neighbour)) {
                        visited.add(neighbour);
                        queue.offerLast(neighbour);
                    }
                }
            }

            result++;
        }

        return result;
    }

    private Map<Integer, List<Integer>> convertTree(TreeNode root) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        Deque<TreeNode[]> deq = new ArrayDeque<>();
        deq.offer(new TreeNode[]{null, root});

        while (!deq.isEmpty()) {
            TreeNode[] curPair = deq.pop();
            TreeNode curNode = curPair[1];

            graph.put(curNode.val, new ArrayList<>());
            List<Integer> neighbours = graph.get(curNode.val);

            if (curPair[0] != null) {
                neighbours.add(curPair[0].val);
            }

            if (curNode.left != null) {
                neighbours.add(curNode.left.val);
                deq.offer(new TreeNode[]{curNode, curNode.left});
            }
            if (curNode.right != null) {
                neighbours.add(curNode.right.val);
                deq.offer(new TreeNode[]{curNode, curNode.right});
            }
        }

        return graph;
    }
}
