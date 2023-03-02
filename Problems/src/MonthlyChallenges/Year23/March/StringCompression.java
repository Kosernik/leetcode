package MonthlyChallenges.Year23.March;

public class StringCompression {
    public static void main(String[] args) {
        StringCompression solution = new StringCompression();

        char[] test0 = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        char[] test1 = {'a'};
        char[] test2 = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};

        System.out.println(solution.compress(test0));
        System.out.println(test0);

        System.out.println(solution.compress(test1));
        System.out.println(test1);

        System.out.println(solution.compress(test2));
        System.out.println(test2);
    }


    /**
     * LeetCode #443. String Compression.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param chars - an array of chars.
     * @return - the length of the compressed array.
     */
    public int compress(char[] chars) {
        int idx = 0;
        int count = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[idx] != chars[i]) {
                idx++;

                if (count > 1) {
                    idx = addCountToCharsAndGetIdx(chars, idx, count);
                }

                count = 1;
                chars[idx] = chars[i];
            } else {
                count++;
            }
        }

        idx++;
        if (count > 1) {
            idx = addCountToCharsAndGetIdx(chars, idx, count);
        }

        return idx;
    }

    private int addCountToCharsAndGetIdx(char[] chars, int idx, int count) {
        char[] digits = String.valueOf(count).toCharArray();

        for (char digit : digits) {
            chars[idx] = digit;
            idx++;
        }

        return idx;
    }
}
