package MonthlyChallenges.Year25.May;

public class TotalCharactersInStringAfterTransformationsI {
    public static void main(String[] args) {
        TotalCharactersInStringAfterTransformationsI solution = new TotalCharactersInStringAfterTransformationsI();

        String s0 = "aaazz";
        int t0 = 1670;
        int result0 = 841100119;
        System.out.println(solution.lengthAfterTransformations(s0, t0) == result0);
    }

    /**
     * LeetCode №3335. Total Characters in String After Transformations I.
     * <p>
     * Complexity - O(N+T), N = s.length, T = t.
     * Memory - O(1)
     *
     * @param s - a string of lowercase english letters.
     * @param t - a positive integer.
     * @return - the length of the resulting string after exactly t transformations. Result is modulo 1_000_000_007.
     */
    public int lengthAfterTransformations(String s, int t) {
        long[] counts = new long[26];
        for (char letter : s.toCharArray()) {
            counts[letter - 'a']++;
        }

        long length = s.length();
        int MODULO = 1_000_000_000 + 7;

        for (int i = 0; i < t; i++) {
            long currZ = counts[25];

            for (int j = 25; j > 0; j--) {
                counts[j] = counts[j - 1] % MODULO;
            }

            counts[0] = currZ;
            counts[1] += currZ;

            length = (length + (currZ % MODULO)) % MODULO;
        }


        return (int) length;
    }
}
