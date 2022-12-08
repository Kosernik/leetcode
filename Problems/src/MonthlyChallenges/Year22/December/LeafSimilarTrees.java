package MonthlyChallenges.Year22.December;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {

    /**
     * LeetCode #872. Leaf-Similar Trees.
     * <p>
     * Complexity - O(N+M), N = root1 size, M = root2 size.
     * Memory - (N+M)
     *
     * @param root1 - a root of a binary tree.
     * @param root2 - a root of a binary tree.
     * @return - True if leaf value sequence is the same for both trees. False - otherwise.
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> firstTreeValues = new ArrayList<>();
        List<Integer> secondTreeValues = new ArrayList<>();

        getLeafValues(root1, firstTreeValues);
        getLeafValues(root2, secondTreeValues);

        return areListsSame(firstTreeValues, secondTreeValues);
    }

    /**
     * Fills the 'values' list with leaf values of the tree.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param node   - a node of a binary tree.
     * @param values - a list with values of the tree.
     */
    private void getLeafValues(TreeNode node, List<Integer> values) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            values.add(node.val);
            return;
        }
        getLeafValues(node.left, values);
        getLeafValues(node.right, values);
    }

    /**
     * Compares the content of two lists.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param first  - a list of integers.
     * @param second - a list of integers.
     * @return - True if content of two lists is the same, False - otherwise.
     */
    private boolean areListsSame(List<Integer> first, List<Integer> second) {
        if (first.size() != second.size()) return false;

        for (int i = 0; i < first.size(); i++) {
            if (first.get(i).intValue() != second.get(i).intValue()) return false;
        }

        return true;
    }
}
