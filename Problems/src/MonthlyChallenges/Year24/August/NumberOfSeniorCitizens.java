package MonthlyChallenges.Year24.August;

public class NumberOfSeniorCitizens {

    /**
     * LeetCode №2678. Number of Senior Citizens.
     * <p>
     * Complexity - O(N)
     * Memory - O(1)
     *
     * @param details - an array of strings representing the info about passengers. 12-th and 13-th characters
     *                represents the age of a passenger.(1 indexed).
     * @return - the number of passengers who are strictly more than 60 years old.
     */
    public int countSeniors(String[] details) {
        int seniors = 0;

        for (String person : details) {
            char ageFirst = person.charAt(11);

            if (('6' == ageFirst && '0' != person.charAt(12)) || ('7' <= ageFirst && ageFirst <= '9')) seniors++;
        }

        return seniors;
    }
}
