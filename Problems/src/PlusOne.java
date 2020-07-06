import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        PlusOne solution = new PlusOne();
        solution.testPlusOne();
        System.out.println("Done testing");
    }

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return new int[]{1};
        int length = digits.length;
        int[] sum = new int[length];
        int carry = 1;
        for (int i = length-1; i >= 0; i--) {
            int curr = digits[i] + carry;
            sum[i] = curr % 10;
            carry = curr / 10;
        }
        if (carry == 1) {
            int[] enlargedArr = new int[length+1];
            enlargedArr[0] = 1;
            System.arraycopy(sum, 0, enlargedArr, 1, length);
            return enlargedArr;
        }
        return sum;
    }
    private void testPlusOne() {
        int[][] tests = {{1,2,3},{},{0},{1},{9},{1,0,0},{9,9,9}};
        int[][] results = {{1,2,4},{1},{1},{2},{1,0},{1,0,1},{1,0,0,0}};
        int failed = 0;

        for (int i = 0; i < tests.length; i++) {
            int[] res = plusOne(tests[i]);
            if (!Arrays.equals(res, results[i])) {
                failed++;
                System.out.println("Failed test #" + (i+1) + ", got: " + Arrays.toString(res) + ", should be" + Arrays.toString(results[i]));
            }
        }
        System.out.println("Success rate: " + ((tests.length - failed)*100/tests.length));
    }
}
