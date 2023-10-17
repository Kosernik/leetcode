package MonthlyChallenges.Year23.October;

import java.util.HashMap;
import java.util.Map;

public class ValidateBinaryTreeNodes {
    private int[] ufParens;

    /**
     * LeetCode #1361. Validate Binary Tree Nodes.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(N)
     *
     * @param n          - the number of nodes.
     * @param leftChild  - an array of left children for each node.
     * @param rightChild - an array of right children for each node.
     * @return - true - if it is a valid binary tree, false - otherwise.
     */
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        this.ufParens = new int[n];
        for (int i = 0; i < n; i++) {
            this.ufParens[i] = i;
        }

        Map<Integer, Integer> parents = new HashMap<>();
        boolean[] hasParent = new boolean[n];

        for (int i = 0; i < n; i++) {
            int left = leftChild[i];
            if (left != -1) {
                if (parents.containsKey(left) || left == i) {
                    return false;
                } else {
                    parents.put(left, i);
                }

                hasParent[left] = true;
                union(i, left);
            }

            int right = rightChild[i];
            if (right != -1) {
                if (parents.containsKey(right) || right == i) {
                    return false;
                } else {
                    parents.put(right, i);
                }

                hasParent[right] = true;
                union(i, right);
            }
        }

        int nodesWithoutParent = 0;
        for (boolean hasP : hasParent) {
            if (!hasP) nodesWithoutParent++;
        }
        int groups = 0;
        for (int i = 0; i < this.ufParens.length; i++) {
            if (i == this.ufParens[i]) {
                groups++;
            }
        }

        return nodesWithoutParent == 1 && groups == 1;
    }

    private int find(int node) {
        if (this.ufParens[node] != node) {
            this.ufParens[node] = find(this.ufParens[node]);
        }
        return this.ufParens[node];
    }

    private void union(int first, int second) {
        int parentFirst = find(first);
        int parentSecond = find(second);

        this.ufParens[parentFirst] = parentSecond;
    }
}
