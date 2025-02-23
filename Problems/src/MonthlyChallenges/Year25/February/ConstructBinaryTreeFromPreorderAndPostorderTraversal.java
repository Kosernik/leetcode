package MonthlyChallenges.Year25.February;

import Utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndPostorderTraversal solution = new ConstructBinaryTreeFromPreorderAndPostorderTraversal();

        int[] pre = {1, 2, 3, 4};
        int[] post = {3, 4, 2, 1};
        System.out.println(solution.constructFromPrePost(pre, post).val);
    }

    /**
     * LeetCode №889. Construct Binary Tree from Preorder and Postorder Traversal.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param preorder  - a result of a preorder traversal of a binary tree. All the values in a tree are unique.
     * @param postorder - a result of a postorder traversal of a binary tree.
     * @return - any binary tree that satisfies given preorder and postorder traversals.
     */
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> indicesPre = getIndices(preorder);
        Map<Integer, Integer> indicesPost = getIndices(postorder);

        return helper(0, preorder.length - 1, preorder, 0, postorder.length - 1, postorder, indicesPre, indicesPost);
    }

    private TreeNode helper(
            int startPre, int endPre, int[] preorder, int startPost, int endPost, int[] postorder,
            Map<Integer, Integer> indicesPre, Map<Integer, Integer> indicesPost) {
        if (startPre >= preorder.length || endPost < 0 || preorder[startPre] != postorder[endPost]) return null;

        TreeNode node = new TreeNode(preorder[startPre]);

        if (startPre + 1 > endPre) {
            return node;
        }

        int leftVal = preorder[startPre + 1];
        int leftValPostIdx = indicesPost.get(leftVal);

        int rightVal = postorder[endPost - 1];
        int rightValPreIdx = indicesPre.get(rightVal);

        int nextPreEnd = (rightValPreIdx - 1) < (startPre + 1) ? endPre : (rightValPreIdx - 1);

        node.left = helper(startPre + 1, nextPreEnd, preorder, startPost, leftValPostIdx, postorder, indicesPre, indicesPost);

        if (leftVal != rightVal) {
            node.right = helper(rightValPreIdx, endPre, preorder, leftValPostIdx + 1, endPost - 1, postorder, indicesPre, indicesPost);
        }

        return node;
    }

    private Map<Integer, Integer> getIndices(int[] postorder) {
        Map<Integer, Integer> indices = new HashMap<>();

        for (int i = 0; i < postorder.length; i++) {
            indices.put(postorder[i], i);
        }

        return indices;
    }
}
