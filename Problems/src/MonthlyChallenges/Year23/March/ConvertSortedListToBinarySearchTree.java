package MonthlyChallenges.Year23.March;

import Utils.ListNode;
import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree {

    /**
     * LeetCode #109. Convert Sorted List to Binary Search Tree.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param head - a head of a singly linked list.
     * @return - the root of the height-balanced binary search tree with all values from given linked list.
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        List<Integer> array = convertToArray(head);

        return buildBST(array, 0, array.size() - 1);
    }

    private TreeNode buildBST(List<Integer> array, int left, int right) {
        if (left > right) return null;
        else if (left == right) return new TreeNode(array.get(left));

        int middle = (right - left) / 2 + left;
        TreeNode node = new TreeNode(array.get(middle));

        node.left = buildBST(array, left, middle - 1);
        node.right = buildBST(array, middle + 1, right);

        return node;
    }

    private List<Integer> convertToArray(ListNode head) {
        List<Integer> array = new ArrayList<>();

        while (head != null) {
            array.add(head.val);
            head = head.next;
        }

        return array;
    }
}
