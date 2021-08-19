package MonthlyChallenges.August21;

import Utils.TreeNode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class MaximumProductOfSplittedBinaryTree {
    public static void main(String[] args) {
        BigInteger a = BigInteger.valueOf(12);
        System.out.println(a);
        BigInteger b = a.subtract(BigInteger.valueOf(10));
        System.out.println(a);
        System.out.println(b);
        BigInteger c = a.subtract(BigInteger.valueOf(2).multiply(BigInteger.valueOf(2)));
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    private List<int[]> tree;
    // LeetCode #1339.
    public int maxProduct(TreeNode root) {
        int MODULO = 1_000_000_007;
        this.tree = new ArrayList<>();
        int totalSum = postorderTraversal(root);

        BigInteger result = BigInteger.valueOf(0);
        BigInteger totalSumBI = BigInteger.valueOf(totalSum);

        for (int[] sums : this.tree) {
            BigInteger leftSum = BigInteger.valueOf(sums[0]);
            BigInteger rightSum = BigInteger.valueOf(sums[1]);
            result = result.max(totalSumBI.subtract(leftSum).multiply(leftSum));
            result = result.max(totalSumBI.subtract(rightSum).multiply(rightSum));
        }

        result = result.mod(BigInteger.valueOf(MODULO));
        return result.intValue();
    }

    private int postorderTraversal(TreeNode node) {
        if (node == null) return 0;

        int leftSum = postorderTraversal(node.left);
        int rightSum = postorderTraversal(node.right);

        this.tree.add(new int[] {leftSum, rightSum});

        return node.val + leftSum + rightSum;
    }
}
