package MonthlyChallenges.Year24.November;

public class DefuseBomb {

    /**
     * LeetCode №1652. Defuse the Bomb.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param code - an array of integers.
     * @param k    - the number of next numbers if k is positive, the number of previous numbers if k is negative.
     * @return - the decrypted code. If k is 0 returns an array of 0`s.
     */
    public int[] decrypt(int[] code, int k) {
        int length = code.length;
        int[] result = new int[length];

        int sum = 0;
        if (k > 0) {
            for (int i = 0; i < k; i++) {
                sum += code[i];
            }

            for (int i = length - 1; i >= 0; i--) {
                result[i] = sum;
                sum = sum - code[(i + k) % length] + code[i];
            }
        } else if (k < 0) {
            for (int i = length + k; i < length; i++) {
                sum += code[i];
            }

            for (int i = 0; i < length; i++) {
                result[i] = sum;
                sum = sum - code[(length + i + k) % length] + code[i];
            }
        }

        return result;
    }
}
