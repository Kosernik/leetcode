package MonthlyChallenges.Year26.May;

public class JumpGameVII {
    public static void main(String[] args) {
        JumpGameVII solution = new JumpGameVII();

        String s2 = "01101110";
        int minJump2 = 2, maxJump2 = 3;
        boolean result2 = false;
        System.out.println(solution.canReach(s2, minJump2, maxJump2) == result2);

        String s5 = "0110100110";
        int minJump5 = 2, maxJump5 = 3;
        boolean result5 = true;
        System.out.println(solution.canReach(s5, minJump5, maxJump5) == result5);

        String s6 = "0110101100";
        int minJump6 = 2, maxJump6 = 3;
        boolean result6 = false;
        System.out.println(solution.canReach(s6, minJump6, maxJump6) == result6);

        String s7 = "011111000111000001011111010";
        int minJump7 = 6, maxJump7 = 8;
        boolean result7 = true;
        System.out.println(solution.canReach(s7, minJump7, maxJump7) == result7);

        String s8 = "011100110101011011011110";
        int minJump8 = 4, maxJump8 = 5;
        boolean result8 = false;
        System.out.println(solution.canReach(s8, minJump8, maxJump8) == result8);
    }

    /**
     * LeetCode №1871. Jump Game VII.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     * <p>
     * A jump from index i to index j is possible if:
     * * i + minJump <= j <= min(i + maxJump, s.length - 1)
     * * s.charAt(j) == '0'
     *
     * @param s       - a binary string of '0' and '1'. s.charAt(0) is always '0'.
     * @param minJump - the minimum distance of a jump.
     * @param maxJump - the maximum distance of a jump.
     * @return - true if you can reach index s.length - 1 in s, or false otherwise.
     */
    public boolean canReach(String s, int minJump, int maxJump) {
        int length = s.length();
        int targetIdx = length - 1;

        if (s.charAt(targetIdx) == '1') return false;

        int startIdx = minJump;
        int endIdx = Math.min(maxJump, length);

        if (startIdx <= targetIdx && targetIdx <= endIdx) return true;

        int nextStart = -1;
        int nextEnd = -1;

        while (startIdx <= endIdx) {
            if (s.charAt(startIdx) == '0') {
                int nextLow = startIdx + minJump;
                int nextHigh = Math.min(startIdx + maxJump, targetIdx);

                if (nextLow <= targetIdx && targetIdx <= nextHigh) return true;

                if (nextLow <= (endIdx + 1)) {
                    endIdx = nextHigh;
                } else {
                    nextStart = nextStart == -1 ? nextLow : nextStart;
                    nextEnd = nextHigh;
                }
            } else {
                if (startIdx == endIdx) {
                    if (nextStart == -1) {
                        return false;
                    }
                    startIdx = nextStart - 1;
                    endIdx = nextEnd;

                    nextStart = -1;
                    nextEnd = -1;
                }
            }

            startIdx++;
            if (startIdx > endIdx) {
                if (nextStart == -1 || nextStart <= endIdx) {
                    return false;
                }
                startIdx = nextStart;
                endIdx = nextEnd;

                nextStart = -1;
                nextEnd = -1;
            }
        }

        return false;
    }
}
