package MonthlyChallenges.February21;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertBSTtoGreaterTree {

    // LeetCode #538.
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return root;

        List<Integer> values = new ArrayList<>();
        inorderTraversal(root, values);

        int sum = 0;
        Map<Integer, Integer> sumValues = new HashMap<>();
        for (int i = values.size()-1; i >= 0; i--) {
            sum += values.get(i);
            sumValues.put(values.get(i), sum);
        }
        inorderUpdate(root, sumValues);
        return root;
    }

    private void inorderTraversal(TreeNode root, List<Integer> values) {
        if (root != null) {
            inorderTraversal(root.left, values);
            values.add(root.val);
            inorderTraversal(root.right, values);
        }
    }

    private void inorderUpdate(TreeNode root, Map<Integer, Integer> sumValues) {
        if (root != null) {
            inorderUpdate(root.left, sumValues);
            root.val = sumValues.get(root.val);
            inorderUpdate(root.right, sumValues);
        }
    }
}
