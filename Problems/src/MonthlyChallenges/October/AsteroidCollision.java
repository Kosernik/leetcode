package MonthlyChallenges.October;

import java.util.ArrayList;
import java.util.List;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length <= 1) {
            return asteroids;
        }

        boolean foundPositive = false;
        boolean foundNegative = false;
        for (int a : asteroids) {
            if (a > 0) foundPositive = true;
            else if (a < 0) foundNegative = true;
        }
        if (!foundNegative || !foundPositive) return asteroids;

        List<Integer> asts = new ArrayList<>();
        for (int a : asteroids) {
            asts.add(a);
        }

        List<Integer> afterColls = helper(asts);
        int[] result = new int[afterColls.size()];
        for (int i = 0; i <  afterColls.size(); i++) {
            result[i] = afterColls.get(i);
        }
        return result;
    }
    private List<Integer> helper (List<Integer> asteroids) {
        if (asteroids.size() == 0) return asteroids;

        List<Integer> reduced = new ArrayList<>();
        reduced.add(asteroids.get(0));

        int idx = 1;

        while (idx < asteroids.size()) {
            int curr = asteroids.get(idx);
            if (curr > 0) {
                reduced.add(curr);
            } else {
                if (reduced.size() == 0) {
                    reduced.add(curr);
                    idx++;
                    continue;
                }
                int prev = reduced.get(reduced.size()-1);
                if (prev < 0) {
                    reduced.add(curr);
                }
                else if (prev == Math.abs(curr)) {
                    reduced.remove(reduced.size()-1);
                }
                else if (prev < Math.abs(curr)) {
                    reduced.set(reduced.size()-1, curr);
                }
            }
            idx++;
        }
        if (reduced.size() != asteroids.size()) {
            reduced = helper(reduced);
        }
        return reduced;
    }
}
