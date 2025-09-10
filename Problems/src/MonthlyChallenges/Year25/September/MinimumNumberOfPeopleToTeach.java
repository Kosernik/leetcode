package MonthlyChallenges.Year25.September;

import java.util.*;

public class MinimumNumberOfPeopleToTeach {

    /**
     * LeetCode №1733. Minimum Number of People to Teach.
     * <p>
     * Complexity - O(N*M + M + K*N), N = n, M = languages.length(the number of users), K = friendships.length.
     * Memory - O(M)
     *
     * @param n           - total number of languages.
     * @param languages   - an array of known languages for each user.
     * @param friendships - an array of pairs where friendships[i] = [U-i, V-i] denotes a friendship between the
     *                    users U and V.
     * @return - the minimum number of users you need to teach one language so that all friends can communicate with
     * each other.
     */
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int totalUsers = languages.length;

        List<Set<Integer>> knownLanguages = getKnownLanguages(languages);

        boolean[] needToLearn = checkIfNeedToLearn(totalUsers, friendships, knownLanguages);

        int minimumLanguage = totalUsers;

        for (int candidateLanguage = 1; candidateLanguage <= n; candidateLanguage++) {
            int needToTeach = 0;
            for (int user = 1; user <= totalUsers; user++) {
                if (needToLearn[user - 1] && !knownLanguages.get(user - 1).contains(candidateLanguage)) {
                    needToTeach++;
                }
            }

            minimumLanguage = Math.min(minimumLanguage, needToTeach);
        }

        return minimumLanguage;
    }

    public int minimumTeachingsOld(int n, int[][] languages, int[][] friendships) {
        int totalUsers = languages.length;

        List<Set<Integer>> knownLanguages = getKnownLanguages(languages);

        boolean[] needToLearn = new boolean[totalUsers];
        Map<Integer, List<Integer>> graph = buildFriendshipGraph(totalUsers, friendships, knownLanguages, needToLearn);

        int minimumLanguage = totalUsers;

        for (int candidateLanguage = 1; candidateLanguage <= n; candidateLanguage++) {
            int needToTeach = 0;
            for (int user = 1; user <= totalUsers; user++) {
                if (needToLearn[user - 1] && !knownLanguages.get(user - 1).contains(candidateLanguage)) {
                    needToTeach++;
                }
            }

            minimumLanguage = Math.min(minimumLanguage, needToTeach);
        }

        return minimumLanguage;
    }

    private boolean[] checkIfNeedToLearn(int totalUsers, int[][] friendships, List<Set<Integer>> knownLanguages) {
        boolean[] needToLearn = new boolean[totalUsers];

        for (int[] pair : friendships) {
            int firstUser = pair[0], secondUser = pair[1];

            if (canNotUnderstandEachOther(knownLanguages.get(firstUser - 1), knownLanguages.get(secondUser - 1))) {
                needToLearn[firstUser - 1] = true;
                needToLearn[secondUser - 1] = true;
            }
        }

        return needToLearn;
    }

    private Map<Integer, List<Integer>> buildFriendshipGraph(
            int totalUsers, int[][] friendships, List<Set<Integer>> knownLanguages, boolean[] needToLearn
    ) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= totalUsers; i++) graph.put(i, new ArrayList<>());

        for (int[] pair : friendships) {
            int firstUser = pair[0], secondUser = pair[1];
            graph.get(firstUser).add(secondUser);
            graph.get(secondUser).add(firstUser);

            if (canNotUnderstandEachOther(knownLanguages.get(firstUser - 1), knownLanguages.get(secondUser - 1))) {
                needToLearn[firstUser - 1] = true;
                needToLearn[secondUser - 1] = true;
            }
        }

        return graph;
    }

    private boolean canNotUnderstandEachOther(Set<Integer> firstLanguages, Set<Integer> secondLanguages) {
        for (Integer language : firstLanguages) {
            if (secondLanguages.contains(language)) return false;
        }

        return true;
    }

    private List<Set<Integer>> getKnownLanguages(int[][] languages) {
        List<Set<Integer>> knownLanguages = new ArrayList<>();

        for (int[] user : languages) {
            Set<Integer> currentUser = new HashSet<>();
            for (int language : user) {
                currentUser.add(language);
            }
            knownLanguages.add(currentUser);
        }

        return knownLanguages;
    }
}
