package MonthlyChallenges.Year21.February21;

import Utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    /**
     * LeetCode #199.
     * <p>
     * Returns a list of values of nodes from the right side of a binary tree.
     * Values ordered from top to bottom of a tree.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root - a root of a binary tree.
     * @return - a list of values of the right side of a tree.
     */
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();

        List<Integer> view = new ArrayList<>();

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);

        while (!queue.isEmpty()) {
            view.add(queue.peekLast().val);

            for (int i = queue.size(); i > 0; i--) {
                TreeNode currNode = queue.removeFirst();
                if (currNode.left != null) queue.offerLast(currNode.left);
                if (currNode.right != null) queue.offerLast(currNode.right);
            }
        }

        return view;
    }
}
