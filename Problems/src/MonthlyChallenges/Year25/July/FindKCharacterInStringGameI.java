package MonthlyChallenges.Year25.July;

public class FindKCharacterInStringGameI {
    public static void main(String[] args) {
        FindKCharacterInStringGameI solution = new FindKCharacterInStringGameI();

        int k0 = 5;
        char result0 = 'b';
        System.out.println(solution.kthCharacter(k0) == result0);

        int k1 = 10;
        char result1 = 'c';
        System.out.println(solution.kthCharacter(k1) == result1);
    }

    /**
     * LeetCode №3304. Find the K-th Character in String Game I.
     * <p>
     * Complexity - O(KlogK)
     * Memory - O(K)
     *
     * @param k - a positive integer. 1 <= k <= 500
     * @return - the value of the k-th character in word, after enough operations have been done for word to have at
     * least k characters.
     */
    public char kthCharacter(int k) {
        int[] charVals = new int[k + 1];

        int lastIdx = 0;
        while (true) {
            int curStartIdx = lastIdx + 1;
            int length = lastIdx + 1;

            for (int i = 0; i < length && curStartIdx <= k; i++, curStartIdx++, lastIdx++) {
                charVals[curStartIdx] = charVals[i] + 1;
            }

            if (curStartIdx == (k + 1)) break;
        }

        return (char) (charVals[k - 1] + 'a');
    }
}
