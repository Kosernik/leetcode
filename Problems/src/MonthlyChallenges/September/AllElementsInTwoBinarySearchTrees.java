package MonthlyChallenges.September;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllElementsInTwoBinarySearchTrees {
    public static void main(String[] args) {

    }

    /**
     * Returns a list containing all the integers from two binary-search trees sorted in ascending order.
     *
     * Complexity - O(n1+n2) , n1 - size of the first tree, n2 - size of the second tree.
     * Memory - O(n1+n2)
     *
     * @param root1 - first binary search tree.
     * @param root2 - second binary search tree.
     * @return - ArrayList of values of two bs-trees sorted in ascending order.
     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return new ArrayList<>();
        else if (root1 == null || root2 == null) {
            return root1 == null ? inorderTraversal(root2) : inorderTraversal(root1);
        }
        List<Integer> first = inorderTraversal(root1);
        List<Integer> second = inorderTraversal(root2);

        return mergeLists(first, second);
    }

    private List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            traversal.add(node.val);
            node = node.right;
        }

        return traversal;
    }

    private List<Integer> mergeLists(List<Integer> first, List<Integer> second) {
        List<Integer> merged = new ArrayList<>();
        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < first.size() && idx2 < second.size()) {
            if (first.get(idx1) < second.get(idx2)) {
                merged.add(first.get(idx1++));
            } else {
                merged.add(second.get(idx2++));
            }
        }
        while (idx1 < first.size()) {
            merged.add(first.get(idx1++));
        }
        while (idx2 < second.size()) {
            merged.add(second.get(idx2++));
        }
        return merged;
    }
}
