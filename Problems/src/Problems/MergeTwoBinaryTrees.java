package Problems;

import Utils.TreeNode;

import java.util.ArrayDeque;

public class MergeTwoBinaryTrees {

    /**
     * LeetCode #617. Merge Two Binary Trees.
     *
     * Complexity O(N), N = root1.size + root2.size
     * Memory - O(N)
     *
     * @param root1 - the root of the first binary tree.
     * @param root2 - the root of the second binary tree.
     * @return - the root of merged tree.
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        else if (root2 == null) return root1;

        TreeNode merged = new TreeNode(root1.val+ root2.val);

        ArrayDeque<TreeNode[]> queue = new ArrayDeque<>();
        queue.offer(new TreeNode[] {root1, root2, merged});

        while (!queue.isEmpty()) {
            // {firstTreeNode, secondTreeNode, resultTreeNode}
            TreeNode[] curPair = queue.remove();

            // Left
            if ((curPair[0] != null && curPair[0].left != null) || (curPair[1] != null && curPair[1].left != null)) {
                int leftVal = (curPair[0] != null && curPair[0].left != null) ? curPair[0].left.val : 0;
                leftVal += (curPair[1] != null && curPair[1].left != null) ? curPair[1].left.val : 0;
                curPair[2].left = new TreeNode(leftVal);

                queue.offer(new TreeNode[] {
                        curPair[0] != null ? curPair[0].left : null,
                        curPair[1] != null ? curPair[1].left : null,
                        curPair[2].left}
                );
            }

            // Right
            if ((curPair[0] != null && curPair[0].right != null) || (curPair[1] != null && curPair[1].right != null)) {
                int rightVal = (curPair[0] != null && curPair[0].right != null) ? curPair[0].right.val : 0;
                rightVal += (curPair[1] != null && curPair[1].right != null) ? curPair[1].right.val : 0;
                curPair[2].right = new TreeNode(rightVal);

                queue.offer(new TreeNode[] {
                        curPair[0] != null ? curPair[0].right : null,
                        curPair[1] != null ? curPair[1].right : null,
                        curPair[2].right}
                );
            }
        }

        return merged;
    }
}
