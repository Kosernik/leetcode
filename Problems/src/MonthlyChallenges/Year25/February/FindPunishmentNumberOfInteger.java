package MonthlyChallenges.Year25.February;

public class FindPunishmentNumberOfInteger {
    public static void main(String[] args) {
        FindPunishmentNumberOfInteger solution = new FindPunishmentNumberOfInteger();

        System.out.println(solution.punishmentNumber(1000) == 10804657);
    }

    /**
     * LeetCode №2698. Find the Punishment Number of an Integer.
     *
     * @param n - a positive integer. 1 <= n <= 1000
     * @return - the punishment number of n.
     */
    public int punishmentNumber(int n) {
        int result = 0;

        for (int number = 1; number <= n; number++) {
            int square = number * number;

            if (isPunishmentNumber(Integer.toString(square), number)) {
                result += square;
            }
        }

        return result;
    }

    private boolean isPunishmentNumber(String digits, int number) {
        if (digits.isEmpty() && number == 0) return true;
        if (digits.isEmpty() || number < 0) return false;

        for (int i = 1; i <= digits.length(); i++) {
            String left = digits.substring(0, i);
            String right = digits.substring(i);

            int leftNum = Integer.parseInt(left);

            if (isPunishmentNumber(right, number - leftNum)) {
                return true;
            }
        }

        return false;
    }
}
