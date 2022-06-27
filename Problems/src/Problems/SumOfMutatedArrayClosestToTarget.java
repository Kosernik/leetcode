package Problems;

public class SumOfMutatedArrayClosestToTarget {
    public static void main(String[] args) {
        SumOfMutatedArrayClosestToTarget solution = new SumOfMutatedArrayClosestToTarget();

        int[] test = {1547,83230,57084,93444,70879};
        int target = 71237;

        System.out.println(solution.findBestValue(test, target));
    }

    /**
     * LeetCode #1300. Sum of Mutated Array Closest to Target.
     *
     *  Complexity - O(NlogN)
     *  Memory - O(1)
     *
     * @param arr - an array of positive integers.
     * @param target - a positive integer.
     * @return - the minimum value to make sum of arr elements equal target.
     */
    public int findBestValue(int[] arr, int target) {
        int diff = Integer.MAX_VALUE;
        int result = 0;
        int sum = 0;
        int max = arr[0];

        for (int number : arr) {
            sum += number;
            max = Math.max(max, number);
        }

        if (sum == target) return max;

        int lowVal = 0, highVal = max, middle;

        while (lowVal <= highVal) {
            middle = (highVal - lowVal) / 2 + lowVal;

            sum = getUpdatedSum(middle, arr);

            int curDiff = Math.abs(sum - target);

            if (curDiff < diff) {
                result = middle;
                diff = curDiff;
            } else if (curDiff == diff) {
                result = Math.min(result, middle);
            }

            if (sum == target) {
                return middle;
            } else if (sum > target){
                highVal = middle - 1;
            } else {
                lowVal = middle + 1;
            }
        }

        return result;
    }

    private int getUpdatedSum(int value, int[] arr) {
        int sum = 0;
        for (int number : arr) {
            sum += Math.min(number, value);
        }
        return sum;
    }
}
