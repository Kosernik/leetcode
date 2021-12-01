package Problems;

import Utils.Node;

import java.util.ArrayDeque;
import java.util.Deque;

public class PopulatingNextRightPointersInEachNodeII {

    /**
     * LeetCode #117. Populating Next Right Pointers in Each Node II.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root - a root of a binary tree.
     *              struct Node {
     *                  int val;
     *                  Node *left;
     *                  Node *right;
     *                  Node *next;
     *              }
     * @return - the tree "root" after populating each next pointer to point to its next right node.
     */
    public Node connect(Node root) {
        if (root == null) return root;

        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Deque<Node> nextLayer = new ArrayDeque<>();
            Node prev = queue.poll();
            addToQueue(nextLayer, prev);

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                addToQueue(nextLayer, node);
                prev.next = node;
                prev = node;
            }

            queue = nextLayer;
        }

        return root;
    }

    private void addToQueue(Deque<Node> queue, Node node) {
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
    }
}
