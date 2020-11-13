package MonthlyChallenges.November;

import java.util.ArrayDeque;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * Populates each next pointer to point to its next right node. If there is no next right node, the next pointer
     * should be set to NULL.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root - a root to a given perfect binary tree.
     * @return - a root of a tree where each node`s 'next' points to the right node.
     */
    public Node connect(Node root) {
        if (root == null || (root.left == null && root.right == null)) return root;

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            Queue<Node> nextLevel = new ArrayDeque<>();
            while (true) {
                Node node = queue.poll();
                if (node.left != null) nextLevel.offer(node.left);
                if (node.right != null) nextLevel.offer(node.right);
                if (queue.isEmpty()) break;
                node.next = queue.peek();
            }
            queue = nextLevel;
        }

        return root;
    }
}
