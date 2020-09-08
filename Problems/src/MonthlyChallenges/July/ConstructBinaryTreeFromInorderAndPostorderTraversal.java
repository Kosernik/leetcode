package MonthlyChallenges.July;

import Utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) return null;

        if (inorder.length == 1) return new TreeNode(inorder[0]);

        TreeNode root = new TreeNode(postorder[postorder.length-1]);

        int idx = indexOfNumber(inorder, postorder[postorder.length-1]);
        if (idx == -1) return null;

        root.left = buildTree(subArray(inorder, 0, idx-1), subArray(postorder, 0, idx-1));
        root.right = buildTree(subArray(inorder, idx+1, inorder.length-1), subArray(postorder, idx, postorder.length-2));

        return root;
    }
    private int[] subArray(int[] array, int left, int right) {
        if (right < left || left < 0 || right < 0 || left >= array.length || right >= array.length) return null;
        int[] subArr = new int[right-left+1];
        subArr = Arrays.copyOfRange(array, left, right+1);
        return subArr;
    }
    private int indexOfNumber(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) return i;
        }
        return -1;
    }
}
