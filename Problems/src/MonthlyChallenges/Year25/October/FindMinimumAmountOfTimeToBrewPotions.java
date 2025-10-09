package MonthlyChallenges.Year25.October;

public class FindMinimumAmountOfTimeToBrewPotions {
    public static void main(String[] args) {
        FindMinimumAmountOfTimeToBrewPotions solution = new FindMinimumAmountOfTimeToBrewPotions();

        int[] skill0 = {1, 5, 2, 4};
        int[] mana0 = {5, 1, 4, 2};
        long result0 = 110;
        System.out.println(solution.minTime(skill0, mana0) == result0);

        System.out.println();
        int[] skill1 = {1, 1, 1};
        int[] mana1 = {1, 1, 1};
        long result1 = 5;
        System.out.println(solution.minTime(skill1, mana1) == result1);

        System.out.println();
        int[] skill2 = {1, 2, 3, 4};
        int[] mana2 = {1, 2};
        long result2 = 21;
        System.out.println(solution.minTime(skill2, mana2) == result2);
    }

    /**
     * LeetCode №3494. Find the Minimum Amount of Time to Brew Potions.
     *
     * @param skill - an array of positive integers.
     * @param mana  - an array of positive integers.
     * @return - the minimum amount of time required for the potions to be brewed properly.
     */
    public long minTime(int[] skill, int[] mana) {
        int wizards = skill.length;

        long[] prevFinished = new long[wizards];

        for (long curMana : mana) {
            long curTime = 0;

            for (int wizard = 0; wizard < wizards; wizard++) {
                curTime = Math.max(curTime, prevFinished[wizard]) + curMana * skill[wizard];
            }

            prevFinished[wizards - 1] = curTime;
            for (int i = wizards - 2; i >= 0; i--) {
                prevFinished[i] = prevFinished[i + 1] - curMana * skill[i + 1];
            }
        }

        return prevFinished[wizards - 1];
    }
}
