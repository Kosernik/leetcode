package Contests;

public class BiweeklyContest78 {

    public static void main(String[] args) {
        BiweeklyContest78 solution = new BiweeklyContest78();

//        solution.test("Hello world!");

    }

    private void test(String input) {
        System.out.println(input);
    }


    //  1
    public int divisorSubstrings(int num, int k) {
        int result = 0;
        String number = String.valueOf(num);

        for (int i = 0; i < (number.length()-k+1); i++) {
            int curNumber = Integer.parseInt(number.substring(i, i+k));
            if (curNumber != 0 && num % curNumber == 0) result++;
        }

        return result;
    }


    //  2
    public int waysToSplitArray(int[] nums) {
        int result = 0;
        long[] preSum = new long[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i+1] = preSum[i] + nums[i];
        }
        long curSum = 0;
        for (int i = nums.length-1; i > 0; i--) {
            curSum += nums[i];
            if (preSum[i] >= curSum) result++;
        }

        return result;
    }
}
