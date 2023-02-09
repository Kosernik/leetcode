package MonthlyChallenges.Year23.February;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NamingCompany {
    public static void main(String[] args) {
        NamingCompany solution = new NamingCompany();

        String[] test4 = {"coffee", "donuts", "time", "toffee", "roffee", "cime"};
        System.out.println(solution.distinctNames(test4));
    }


    /**
     * LeetCode #2306. Naming a Company.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param ideas - a list of strings of english lower case letters.
     * @return - the number of unique company names.
     */
    public long distinctNames(String[] ideas) {
        HashSet<String>[] firstToEndings = new HashSet[26];
        for (int i = 0; i < 26; i++) {
            firstToEndings[i] = new HashSet<String>();
        }

        for (String idea : ideas) {
            char first = idea.charAt(0);
            firstToEndings[first - 'a'].add(idea.substring(1));
        }

        long distinctNames = 0L;

        for (int i = 0; i < firstToEndings.length - 1; i++) {
            for (int j = i + 1; j < firstToEndings.length; j++) {
                int numberOfDuplicates = getNumberOfDuplicate(firstToEndings[i], firstToEndings[j]);

                distinctNames += 2L * (firstToEndings[i].size() - numberOfDuplicates) * (firstToEndings[j].size() - numberOfDuplicates);
            }
        }

        return distinctNames;
    }

    private int getNumberOfDuplicate(HashSet<String> first, HashSet<String> second) {
        if (first.isEmpty() || second.isEmpty()) return 0;
        int duplicates = 0;

        for (String sec : second) {
            if (first.contains(sec)) {
                duplicates++;
            }
        }

        return duplicates;
    }

    public long distinctNamesTLE(String[] ideas) {
        Set<String> uniqueIdeas = new HashSet<>();
        Map<String, String[]> splittedIdeas = new HashMap<>();
        for (String idea : ideas) {
            uniqueIdeas.add(idea);
            splittedIdeas.put(idea, new String[]{idea.substring(0, 1), idea.substring(1)});
        }

        Set<String> companyNames = new HashSet<>();

        for (int i = 0; i < ideas.length - 1; i++) {
            String curIdea = ideas[i];
            String[] parts = splittedIdeas.get(curIdea);

            for (int j = i + 1; j < ideas.length; j++) {
                String candidateEnd = ideas[j];
                String[] endParts = splittedIdeas.get(candidateEnd);

                String first = parts[0] + endParts[1];
                if (!uniqueIdeas.contains(first)) {
                    String second = endParts[0] + parts[1];

                    if (!uniqueIdeas.contains(second)) {
                        companyNames.add(first + " " + second);
                        companyNames.add(second + " " + first);
                    }
                }
            }
        }

        return companyNames.size();
    }
}
