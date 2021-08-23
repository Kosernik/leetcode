package MonthlyChallenges.August21;

import Utils.TreeNode;

import java.util.ArrayDeque;

public class TwoSumIV {
    // LeetCode #653. Two Sum IV - Input is a BST
    public boolean findTarget(TreeNode root, int k) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            int curTarget = k - curr.val;
            if (curTarget < curr.val) return false;

            if (curTarget != curr.val) {
                if (find(root, curTarget)) return true;
            } else {
                if (findDuplicates(root, curTarget, 0)) return true;
            }

            curr = curr.right;
        }

        return false;
    }

    private boolean find(TreeNode root, int target) {
        if (root == null) return false;
        else if (root.val == target) return true;
        else if (root.val > target) return find(root.left, target);
        else return find(root.right, target);
    }

    private boolean findDuplicates(TreeNode root, int target, int count) {
        if (root == null) return false;
        else if (root.val == target) {
            if (count > 0) return true;
            else {
                return findDuplicates(root.left, target, count+1)
                        || findDuplicates(root.right, target, count+1);
            }
        }
        else if (root.val > target) return findDuplicates(root.left, target, count);
        else return findDuplicates(root.right, target, count);
    }
}
