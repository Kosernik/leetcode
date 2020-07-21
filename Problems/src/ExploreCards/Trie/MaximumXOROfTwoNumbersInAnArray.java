package ExploreCards.Trie;

import java.util.ArrayList;
import java.util.List;

public class MaximumXOROfTwoNumbersInAnArray {

    public int findMaximumXORBrute(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int maxXOR = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                maxXOR = Math.max(maxXOR, (nums[i]^nums[j]));
            }
        }
        return maxXOR;
    }


    private Node root;
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        else if (nums.length == 2) return nums[0]^nums[1];

        root = new Node();
        for (int number : nums) addToTree(number);

        // TODO
        return -1;
    }

    private void addToTree(int number) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int currBit = getBit(number, i);
            if (node.children[currBit] == null) {
                node.children[currBit] = new Node();
            }
            node = node.children[currBit];
        }
    }

    // Читаем бит, находящийся по данному индексу
    private int getBit(int number, int idx) {return (number >>> idx) & 1;}

    class Node {
        Node[] children;

        Node() {
            this.children = new Node[2];
        }
    }
}
