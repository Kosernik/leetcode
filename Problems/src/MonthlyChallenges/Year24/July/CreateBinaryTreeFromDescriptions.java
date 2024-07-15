package MonthlyChallenges.Year24.July;

import Utils.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CreateBinaryTreeFromDescriptions {
    public static void main(String[] args) {
        CreateBinaryTreeFromDescriptions solution = new CreateBinaryTreeFromDescriptions();

        int[][] test1 = {{1, 2, 1}, {2, 3, 0}, {3, 4, 1}};
        System.out.println(solution.createBinaryTree(test1).val);
    }


    /**
     * LeetCode №2196. Create Binary Tree From Descriptions.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param descriptions - an array of [parent-i, child-i, isLeft-i], where parent-i is the value of the parent node,
     *                     child-i is the value of a child node, isLeft-i=0 means child-i is the left child of parent-i,
     *                     isLeft-i = 1 means child-i is the right child of parent-i.
     * @return - the root of constructed by "descriptions" binary tree.
     */
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> children = new HashSet<>();
        Map<Integer, TreeNode> nodes = new HashMap<>();

        for (int[] descr : descriptions) {
            int parentVal = descr[0];
            int childVal = descr[1];

            nodes.putIfAbsent(parentVal, new TreeNode(parentVal));
            nodes.putIfAbsent(childVal, new TreeNode(childVal));

            TreeNode parent = nodes.get(parentVal);
            TreeNode child = nodes.get(childVal);

            if (descr[2] == 0) {
                parent.right = child;
            } else {
                parent.left = child;
            }

            children.add(childVal);
        }

        TreeNode root = null;
        for (Map.Entry<Integer, TreeNode> entry : nodes.entrySet()) {
            if (!children.contains(entry.getKey())) {
                root = entry.getValue();
            }
        }

        return root;
    }
}
