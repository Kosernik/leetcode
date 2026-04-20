package MonthlyChallenges.Year26.April;

public class TwoFurthestHousesWithDifferentColors {

    /**
     * LeetCode №2078. Two Furthest Houses With Different Colors.
     *
     * @param colors - an array of integers representing colours of houses.
     * @return - the maximum distance between two houses with different colors.
     */
    public int maxDistance(int[] colors) {
        int result = 0;

        for (int i = 0, lastIdx = colors.length - 1; i < colors.length; i++) {
            if (colors[i] != colors[lastIdx]) {
                result = lastIdx - i;
                break;
            }
        }

        for (int i = colors.length - 1; i >= 0; i--) {
            if (colors[0] != colors[i]) {
                result = Math.max(result, i);
                break;
            }
        }

        return result;
    }
}
