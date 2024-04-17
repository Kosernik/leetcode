package MonthlyChallenges.Year24.April;

import Utils.TreeNode;

public class SmallestStringStartingFromLeaf {
    public static void main(String[] args) {
        SmallestStringStartingFromLeaf solution = new SmallestStringStartingFromLeaf();

    }

    private String smallestString = null;
    private final char[] letters = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };

    /**
     * LeetCode №988. Smallest String Starting From Leaf.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param root - a root of a binary tree.
     * @return - the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
     */
    public String smallestFromLeaf(TreeNode root) {
        helper(root, "");
        return smallestString;
    }

    private void helper(TreeNode root, String ending) {
        if (root == null) {
            return;
        }

        String curString = letters[root.val] + ending;
        if (root.left == null && root.right == null) {
            if (this.smallestString == null || this.smallestString.compareTo(curString) > 0) {
                this.smallestString = curString;
            }
            return;
        }

        helper(root.left, curString);
        helper(root.right, curString);
    }
}
