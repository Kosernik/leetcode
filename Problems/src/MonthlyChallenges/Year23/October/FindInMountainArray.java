package MonthlyChallenges.Year23.October;

public class FindInMountainArray {
    /**
     * arr.length >= 3
     * There exists some i with 0 < i < arr.length - 1 such that:
     * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
     * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
     */
    interface MountainArray {
        public int get(int index);

        public int length();
    }

    /**
     * LeetCode #1095. Find in Mountain Array.
     * <p>
     * Complexity - O(logN)
     * Memory - O(1)
     *
     * @param target      - an integer.
     * @param mountainArr - an implementation of an interface MountainArray.
     * @return - the minimum index such that mountainArr.get(index) == target or -1 if there is no such element.
     */
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        int peekIdx = getPeekIdx(mountainArr, length);
        if (peekIdx == -1) return -1;

        int leftIdx = binSearchLeftMost(target, 0, peekIdx, mountainArr);
        if (leftIdx != -1) return leftIdx;

        return binSearchLeftMostReverse(target, peekIdx + 1, length - 1, mountainArr);
    }

    private int binSearchLeftMostReverse(int target, int left, int right, MountainArray mountainArr) {
        int middle;

        while (left <= right) {
            middle = (right + left) / 2;
            int candidate = mountainArr.get(middle);
            if (candidate == target) {
                return middle;
            } else if (candidate > target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }

    private int binSearchLeftMost(int target, int left, int right, MountainArray mountainArr) {
        int middle;

        while (left <= right) {
            middle = (right + left) / 2;
            int candidate = mountainArr.get(middle);
            if (candidate == target) {
                return middle;
            } else if (candidate < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    private int getPeekIdx(MountainArray mountainArr, int length) {
        int left = 1, right = length - 2, middle;

        while (left <= right) {
            middle = (right + left) / 2;

            int leftNeighbour = mountainArr.get(middle - 1);
            int candidate = mountainArr.get(middle);
            int rightNeighbour = mountainArr.get(middle + 1);

            if (leftNeighbour < candidate && candidate > rightNeighbour) {
                return middle;
            } else if (leftNeighbour < candidate) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }
}
