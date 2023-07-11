package MonthlyChallenges.Year23.July;

import Utils.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {

    /**
     * LeetCode #863. All Nodes Distance K in Binary Tree.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param root   - a root of a binary tree.
     * @param target - the target node.
     * @param k      - the distance from the target node.
     * @return - a list of all nodes that are K-distance away from the target.
     */

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();

        if (k == 0) {
            result.add(target.val);
            return result;
        }

        traverseDown(target, result, k, target);
        traverseUp(root, target, result, k);

        return result;
    }

    private void traverseUp(TreeNode root, TreeNode target, List<Integer> resultNodes, int k) {
        Map<TreeNode, TreeNode> backPath = new HashMap<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (true) {
            TreeNode node = queue.removeFirst();
            if (node == target) {
                traverseUpHelper(target, resultNodes, k, backPath);
                return;
            } else {
                if (node.left != null) {
                    backPath.put(node.left, node);
                    queue.offerLast(node.left);
                }
                if (node.right != null) {
                    backPath.put(node.right, node);
                    queue.offerLast(node.right);
                }
            }
        }
    }

    private void traverseUpHelper(TreeNode target, List<Integer> resultNodes, int k, Map<TreeNode, TreeNode> backPath) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(target);

        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            TreeNode parent = backPath.get(node);
            if (parent == null) return;
            queue.offerLast(parent);

            k--;
            if (k == 0) {
                resultNodes.add(parent.val);
                return;
            } else {
                traverseDown(parent, resultNodes, k, node);
            }
        }
    }


    private void traverseDown(TreeNode target, List<Integer> resultNodes, int k, TreeNode ignore) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(target);

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.removeFirst();
                if (node.left != null && node.left != ignore) {
                    queue.offerLast(node.left);
                }
                if (node.right != null && node.right != ignore) {
                    queue.offerLast(node.right);
                }
            }
            k--;
            if (k == 0) {
                for (TreeNode node : queue) {
                    if (node != ignore) resultNodes.add(node.val);
                }
                return;
            }
        }
    }
}
