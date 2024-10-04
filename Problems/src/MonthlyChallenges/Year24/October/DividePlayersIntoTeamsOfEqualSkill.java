package MonthlyChallenges.Year24.October;

import java.util.Arrays;

public class DividePlayersIntoTeamsOfEqualSkill {

    /**
     * LeetCode №2491. Divide Players Into Teams of Equal Skill.
     * <p>
     * Complexity - O(NlogN)
     * Memory - O(sorting complexity)
     *
     * @param skill - an array of positive integers. skill.length is even.
     * @return - the sum of the chemistry of all the teams, or returns -1 if there is no way to divide the players into
     * teams such that the total skill of each team is equal.
     */
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);

        int left = 0;
        int right = skill.length - 1;
        int sum = skill[left] + skill[right];

        long result = skill[left++] * (long) skill[right--];

        while (left < right) {
            int curSum = skill[left] + skill[right];

            if (curSum != sum) return -1;

            result += skill[left++] * (long) skill[right--];
        }

        return result;
    }
}
