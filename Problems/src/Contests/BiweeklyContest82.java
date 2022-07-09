package Contests;

import Utils.TreeNode;

public class BiweeklyContest82 {

    public static void main(String[] args) {
        BiweeklyContest82 solution = new BiweeklyContest82();

    }

    //  1
    public boolean evaluateTree(TreeNode root) {
        //  Leafs: 0 = false, 1 = true
        //  Non-leafs: 2 = OR(||), 3 = AND(&&)

        if (root.left == null && root.right == null) {
            return root.val != 0;
        }

        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }

    //  2
    //[10,20]
    //[2,17,18,19]
    //2
    //[20,30,10]
    //[19,13,26,4,25,11,21]
    //2
    //[20,30,10,3]
    //[19,13,26,4,25,11,21]
    //2
    //[20,30,10,3]
    //[19,13,26,4,25,11,21]
    //3
    //[20,30,10,31]
    //[19,13,26,4,25,11,21]
    //2
    //[3]
    //[2,4]
    //2
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        return -1;
    }
}
