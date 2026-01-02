package MonthlyChallenges.Year21.September21;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    /**
     * LeetCode #929. Unique Email Addresses.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param emails - an array of strings, representing email addresses.
     * @return - the number of unique email addresses.
     */
    public int numUniqueEmails(String[] emails) {
        int uniques = 0;
        Set<String> uniquesEmails = new HashSet<>();

        for (String email : emails) {
            String[] splitted = email.split("@");
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < splitted[0].length(); i++) {
                if (splitted[0].charAt(i) == '+') {
                    break;
                } else if (splitted[0].charAt(i) != '.') {
                    builder.append(splitted[0].charAt(i));
                }
            }
            builder.append("@");
            builder.append(splitted[1]);
            if (uniquesEmails.add(builder.toString())) uniques++;
        }

        return uniques;
    }
}
