package MonthlyChallenges.August21;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    // LeetCode #113.
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        traversePath(root, targetSum, 0, result, new ArrayList<>());
        return result;
    }

    private void traversePath(TreeNode root, int targetSum, int sum, List<List<Integer>> result, List<Integer> path) {
        if (root.left == null && root.right == null) {
            if (sum + root.val == targetSum) {
                List<Integer> validPath = new ArrayList<>(path);
                validPath.add(root.val);
                result.add(validPath);
            }
        } else {
            if (root.left != null) {
                path.add(root.val);
                traversePath(root.left, targetSum, sum + root.val, result, path);
                path.remove(path.size()-1);
            }
            if (root.right != null) {
                path.add(root.val);
                traversePath(root.right, targetSum, sum + root.val, result, path);
                path.remove(path.size()-1);
            }
        }
    }
}
