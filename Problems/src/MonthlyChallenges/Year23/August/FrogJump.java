package MonthlyChallenges.Year23.August;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJump {

    /**
     * LeetCode #403. Frog Jump.
     *
     * @param stones - a list of non-negative integers sorted in a strictly increasing order.
     * @return - True if the last stone is reachable, false - otherwise.
     */
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) return false;
        Set<Integer> stonesSet = new HashSet<>();
        for (int stone : stones) stonesSet.add(stone);

        //  stoneNumber -> jump lengths
        Map<Integer, Set<Integer>> reachable = new HashMap<>();

        Set<Integer> firstStone = new HashSet<>();
        firstStone.add(1);
        reachable.put(1, firstStone);

        for (int i = 1; i < stones.length; i++) {
            int curStone = stones[i];
            if (!reachable.containsKey(curStone)) continue;

            Set<Integer> jumps = reachable.get(curStone);
            for (int jump : jumps) {
                for (int diff = -1; diff <= 1; diff++) {
                    int nextStone = curStone + jump + diff;
                    if (nextStone != curStone && stonesSet.contains(nextStone)) {
                        if (!reachable.containsKey(nextStone)) {
                            reachable.put(nextStone, new HashSet<>());
                        }

                        reachable.get(nextStone).add(jump + diff);
                    }
                }
            }
        }

        return reachable.containsKey(stones[stones.length - 1]);
    }
}
