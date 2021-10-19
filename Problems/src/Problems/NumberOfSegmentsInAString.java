package Problems;

public class NumberOfSegmentsInAString {
    /**
     * LeetCode #434. Number of Segments in a String.
     *
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a string.
     * @return - the number of segments in "s".
     */
    public int countSegments(String s) {
        int numberOfSegments = 0;
        if (s == null || s.length() == 0) return numberOfSegments;
        s = s.strip();
        if (s.length() == 0) return numberOfSegments;

        int idx = 0;
        numberOfSegments++;

        while (idx < s.length()) {
            if (s.charAt(idx) == ' ' && s.charAt(idx-1) != ' ') numberOfSegments++;
            idx++;
        }

        return numberOfSegments;
    }
}
