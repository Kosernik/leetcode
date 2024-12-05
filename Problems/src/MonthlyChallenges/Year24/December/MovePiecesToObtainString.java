package MonthlyChallenges.Year24.December;

public class MovePiecesToObtainString {
    public static void main(String[] args) {
        MovePiecesToObtainString solution = new MovePiecesToObtainString();

        String testStart0 = "_L__R__R_", testTarget0 = "L______RR";
        System.out.println(solution.canChange(testStart0, testTarget0));
        System.out.println();

        String testStart3 = "_L", testTarget3 = "L_";
        System.out.println(solution.canChange(testStart3, testTarget3));
    }


    private final char LEFT = 'L';
    private final char RIGHT = 'R';
    private final char SPACE = '_';

    /**
     * LeetCode №2337. Move Pieces to Obtain a String.
     * <p>
     * Complexity - O(N), N = start.length = target.length.
     * Memory - O(N)
     *
     * @param start  - a string consisting of 'L', 'R' and '_'.
     * @param target - a string consisting of 'L', 'R' and '_'. start.length = target.length.
     * @return - true if it is possible to obtain the string target by moving the pieces of the string start any number
     * of times. Otherwise, returns false.
     */
    public boolean canChange(String start, String target) {
        char[] startLetters = start.toCharArray();
        int startIdx = 0, targetIdx = 0;

        for (char letter : target.toCharArray()) {
            if (letter == LEFT) {
                while (startIdx < startLetters.length && startLetters[startIdx] == SPACE) {
                    startIdx++;
                }

                if (startIdx < targetIdx) {
                    return false;
                }

                while (startIdx < startLetters.length && startLetters[startIdx] == SPACE) {
                    startIdx++;
                }

                if (startIdx == startLetters.length || startLetters[startIdx] == RIGHT) {
                    return false;
                } else {
                    startIdx++;
                }
            } else if (letter == RIGHT) {
                if (startIdx > targetIdx) {
                    return false;
                }

                while (startIdx != targetIdx && startLetters[startIdx] == SPACE) {
                    startIdx++;
                }

                if (startLetters[startIdx] == RIGHT) {
                    startIdx++;
                } else {
                    return false;
                }
            }

            targetIdx++;
        }

        while (startIdx < startLetters.length && startLetters[startIdx] == SPACE) {
            startIdx++;
        }

        return startIdx == startLetters.length;
    }
}
