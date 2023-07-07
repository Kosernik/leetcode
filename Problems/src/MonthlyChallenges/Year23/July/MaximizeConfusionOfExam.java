package MonthlyChallenges.Year23.July;

public class MaximizeConfusionOfExam {

    /**
     * LeetCode #2024. Maximize the Confusion of an Exam.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param answerKey - a string of 'T' and 'F'
     * @param k         - the maximum number of change operations.
     * @return - the maximum number of consecutive 'T's or 'F's in the answer key after performing the operation at
     * most k times.
     */
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] answer = answerKey.toCharArray();
        int maxFrequency = 0;
        int i = 0;
        int trueCount = 0;
        int falseCount = 0;

        for (int j = 0; j < answer.length; j++) {
            maxFrequency = Math.max(maxFrequency, (answer[j] == 'T' ? ++trueCount : ++falseCount));

            if (j - i + 1 > maxFrequency + k) {
                if (answer[i] == 'T') {
                    trueCount--;
                } else {
                    falseCount--;
                }
                i++;
            }
        }

        return answer.length - i;
    }
}
