package MonthlyChallenges.Year24.May;

public class NumberOfStepsToReduceNumberInBinaryRepresentationToOne {

    /**
     * LeetCode №1404. Number of Steps to Reduce a Number in Binary Representation to One.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param s - a string  of '0' and '1'
     * @return - the number of steps to reduce s to 1.
     */
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;
        int idx = s.length() - 1;

        while (true) {
            if (idx < 0) {
                break;
            }
            if (idx == 0 && carry == 0) {
                break;
            }
            char ch = s.charAt(idx);
            if (ch == '0') {
                if (carry == 1) {
                    steps++;
                }
            } else {    //  ch == '1'
                if (carry == 0) {
                    steps++;
                    carry = 1;
                }
            }
            steps++;

            idx--;
        }

        return steps;
    }
}
