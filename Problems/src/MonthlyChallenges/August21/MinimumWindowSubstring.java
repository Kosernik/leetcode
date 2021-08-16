package MonthlyChallenges.August21;

import java.util.Arrays;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();

        String[][] tests = {
                {"ADOBECODEBANC", "ABC"},
                {"baaaaabb", "abb"},
                {"baabbaaabb", "abb"},
                {"abbbbbc", "c"}
        };

        System.out.println(solution.minWindow(tests[0][0], tests[0][1]));
    }

    public String minWindow(String s, String t) {
        int[] counts = new int[52];
        for (char ch : t.toCharArray()) {
            counts[getIndex(ch)]++;
        }

        for (int i = 0; i < 52; i++) {
            if (counts[i] == 0) counts[i] = Integer.MIN_VALUE;
        }

        int minLength = Integer.MAX_VALUE;
        int beginningIdx = 0;
        int endIdx = 0;

        int slow = 0;
        int fast = 0;

        while (slow < s.length()) {
            System.out.println(counts[0] + ", " + counts[1] + ", " + counts[2] + ", slow " + slow);

            int curIdx = getIndex(s.charAt(slow));

            if (counts[curIdx] == Integer.MIN_VALUE) {
                slow++;
                continue;
            }
            else if (counts[curIdx] < 0) {
                counts[curIdx]++;
                slow++;
                continue;
            }

            if (fast < slow) {
                System.out.println("Moved stop idx");
                fast = slow;
            }
            while (fast < s.length()) {
                int idx = getIndex(s.charAt(fast));
                if (counts[idx] != Integer.MIN_VALUE) {
                    System.out.println("fast " + fast);
                    counts[idx]--;
                    if (isValid(counts)) {
//                        System.out.println(Arrays.toString(counts));
                        System.out.println("Found solution");
                        System.out.println(counts[0] + ", " + counts[1] + ", " + counts[2]);
                        System.out.println("Slow idx: " + slow + ", fast idx: " + fast);
                        System.out.println(s.substring(slow, fast+1));

                        int curLength = fast - slow + 1;
                        if (curLength < minLength) {
                            beginningIdx = slow;
                            endIdx = fast+1;
                            minLength = curLength;
                        }
                        counts[curIdx]++;
                        break;
                    } else {
                        fast++;
                    }
                } else {
                    fast++;
                }
            }
            slow++;
        }

        return s.substring(beginningIdx, endIdx);
    }

    private boolean isValid(int[] counts) {
        for (int count : counts) if (count > 0) return false;
        return true;
    }

    private int getIndex(char ch) {
        if ('A' <= ch && ch <= 'Z') {
            return (ch - 'A');
        } else {
            return (ch - 'a' + 26);
        }
    }
}
