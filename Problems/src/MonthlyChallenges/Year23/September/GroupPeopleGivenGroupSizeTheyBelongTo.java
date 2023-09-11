package MonthlyChallenges.Year23.September;

import java.util.*;

public class GroupPeopleGivenGroupSizeTheyBelongTo {

    /**
     * LeetCode №1282. Group the People Given the Group Size They Belong To
     *
     * @param groupSizes - an array of sizes of groups for each person.
     * @return - a list of groups such that each person 'i' is in a group of size groupSizes[i].
     */
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Deque<List<Integer>>> groups = new HashMap<>();

        for (int person = 0; person < groupSizes.length; person++) {
            int size = groupSizes[person];

            if (!groups.containsKey(size)) {
                Deque<List<Integer>> sizedGroup = new ArrayDeque<>();
                sizedGroup.offerFirst(new ArrayList<>());
                groups.put(size, sizedGroup);
            }

            Deque<List<Integer>> sizedGroup = groups.get(size);
            if (sizedGroup.peekFirst().size() >= size) {
                sizedGroup.offerFirst(new ArrayList<>());
            }
            sizedGroup.peekFirst().add(person);
        }

        for (Deque<List<Integer>> sizedGroup : groups.values()) {
            result.addAll(sizedGroup);
        }
        return result;
    }
}
