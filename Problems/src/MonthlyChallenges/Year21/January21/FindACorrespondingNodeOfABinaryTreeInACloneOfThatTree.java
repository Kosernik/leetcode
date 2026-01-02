package MonthlyChallenges.Year21.January21;

import Utils.TreeNode;

import java.util.ArrayDeque;

public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {
    /**
     * LeetCode #1379.
     * Returns a reference to a clone node of a target in a "cloned" tree.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param original - binary tree.
     * @param cloned   - a clone of an "original" tree.
     * @param target   - a reference to a target in an "original" tree.
     * @return - a reference to a clone node of a target in a "cloned" tree.
     */
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(original, cloned));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (pair.original == target) return pair.clone;

            if (pair.original.left != null) {
                queue.offer(new Pair(pair.original.left, pair.clone.left));
            }
            if (pair.original.right != null) {
                queue.offer(new Pair(pair.original.right, pair.clone.right));
            }
        }

        return null;
    }

    private class Pair {
        TreeNode original;
        TreeNode clone;

        Pair(TreeNode original, TreeNode clone) {
            this.original = original;
            this.clone = clone;
        }
    }
}
