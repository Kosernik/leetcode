package Problems;

import java.util.TreeSet;

public class FindLatestGroupOfSizeM {
    public static void main(String[] args) {
        FindLatestGroupOfSizeM solution = new FindLatestGroupOfSizeM();

        int[] test0 = {2,1,3};
        System.out.println(solution.findLatestStep(test0, 2));

        int[] test1 = {4,3,2,1};
        System.out.println(solution.findLatestStep(test1, 1));
    }

    /**
     * LeetCode #1562. Find Latest Group of Size M.
     *
     * @param arr - an array of indexes(1 indexed) of operations.
     * @param m - the length of a window of 1s.
     * @return - the latest step at which there exists a group of ones of length exactly m.
     *           If no such group exists, return -1.
     */
    public int findLatestStep(int[] arr, int m) {
        if (arr.length == m) return m;

        TreeSet<Integer> idxOfWalls = new TreeSet<>();
        idxOfWalls.add(0);
        idxOfWalls.add(arr.length+1);

        for (int i = arr.length-1; i >= 0; i--) {
            int wall = arr[i];
            int leftWall = idxOfWalls.floor(wall);
            int rightWall = idxOfWalls.ceiling(wall);

            int leftSize = wall - leftWall - 1;
            int rightSize = rightWall - wall - 1;
            if (leftSize == m || rightSize == m) return i;

            idxOfWalls.add(arr[i]);
        }

        return -1;
    }

}
