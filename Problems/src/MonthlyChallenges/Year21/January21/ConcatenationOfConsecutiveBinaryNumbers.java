package MonthlyChallenges.Year21.January21;

public class ConcatenationOfConsecutiveBinaryNumbers {
    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(1 << 31));
//        System.out.println(Integer.toBinaryString(1 << 32));
//        System.out.println(getLengthOfBinary(16));
//        System.out.println(Integer.toBinaryString(16));
//        System.out.println(getLengthOfBinary(163));
//        System.out.println(Integer.toBinaryString(163));
//        System.out.println(getLengthOfBinary(0));
//        System.out.println(Integer.toBinaryString(0));
//        System.out.println(getLengthOfBinary(1));
//        System.out.println(Integer.toBinaryString(1));

//        System.out.println(Integer.toBinaryString(16 | 5));

        ConcatenationOfConsecutiveBinaryNumbers solution = new ConcatenationOfConsecutiveBinaryNumbers();
//        System.out.println(solution.concatenatedBinary(1));
        System.out.println(solution.concatenatedBinary(3));
        System.out.println(solution.concatenatedBinary(12));
        System.out.println(solution.concatenatedBinary(100000));
    }

    private final int MODULO = 1_000_000_007;

    // LeetCode #1680.
    public int concatenatedBinary(int n) {
        if (n <= 1) return 1;

        long result = 0;

        for (int i = 1; i <= n; i++) {
            result = result * (long) Math.pow(2, Integer.toBinaryString(i).length()) + i;
            result %= MODULO;
        }

        return (int) result;
    }
}
