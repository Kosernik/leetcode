package Problems;

import Utils.ListNode;
import Utils.TreeNode;

import java.util.ArrayDeque;

public class LinkedListInBinaryTree {

    /**
     * LeetCode #1367. Linked List in Binary Tree.
     *
     * Complexity - O(N*M), N = tree size, M = linked list length.
     * Memory - O(N)
     *
     * @param head - the head of a linked list.
     * @param root - the head of a binary tree.
     * @return - True - if all the elements in the linked list starting from the head correspond to some downward path
     *           connected in the binary tree. False - otherwise.
     */
    public boolean isSubPath(ListNode head, TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            if (node.val == head.val && helper(head, node)) {
                return true;
            }
            if (node.left != null) queue.offerLast(node.left);
            if (node.right != null) queue.offerLast(node.right);
        }
        return false;
    }

    private boolean helper(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;

        if (root.val == head.val) {
            return helper(head.next, root.left) || helper(head.next, root.right);
        }
        return false;
    }
}
