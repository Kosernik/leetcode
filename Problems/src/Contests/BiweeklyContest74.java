package Contests;

import java.util.*;

public class BiweeklyContest74 {
    public static void main(String[] args) {
        BiweeklyContest74 solution = new BiweeklyContest74();

        String test20 = "abdcdbc";
        String test21 = "ac";

        System.out.println(solution.maximumSubsequenceCount(test20, test21));
    }

    // 1
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        for (int count : counts.values()) {
            if (count % 2 == 1) return false;
        }
        return true;
    }

    // 2
    public long maximumSubsequenceCount(String text, String pattern) {
        if (pattern.charAt(0) == pattern.charAt(1)) {
            long count = countLetters(text, pattern) + 1;
            return count * (count - 1) / 2;
        }
        long result = 0;

        List<Character> compressed = compress(text, pattern);
        compressed.add(pattern.charAt(1));
        result = countSubsq(compressed, pattern);

        compressed.remove(compressed.size()-1);
        compressed.add(0, pattern.charAt(0));

        result = Math.max(result, countSubsq(compressed, pattern));
        return result;
    }
    private List<Character> compress(String text, String pattern) {
        List<Character> res = new ArrayList<>();
        char firstCh = pattern.charAt(0);
        char secondCh = pattern.charAt(1);
        char[] letters = text.toCharArray();
        for (char ch : letters) {
            if (ch == firstCh || ch == secondCh) res.add(ch);
        }
        return res;
    }
    private int countLetters(String text, String pattern) {
        int count = 0;
        char firstCh = pattern.charAt(0);
        char[] letters = text.toCharArray();
        for (char ch : letters) {
            if (ch == firstCh) {
                count++;
            }
        }
        return count;
    }
    private long countSubsq(List<Character> compressed, String pattern) {
        char firstCh = pattern.charAt(0);
        char secondCh = pattern.charAt(1);
        long[] charsBefore = new long[compressed.size()+1];

        for (int i = 0; i < compressed.size(); i++) {
            charsBefore[i+1] = charsBefore[i];
            if (compressed.get(i) == firstCh) {
                charsBefore[i+1] += 1;
            }
        }

        long res = 0L;
        for (int i = compressed.size()-1; i >=0; i--) {
            if (compressed.get(i) == secondCh) {
                res += charsBefore[i];
            }
        }
        return res;
    }

    // 3
    public int halveArray(int[] nums) {
        if (nums.length == 1) return 1;
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        double sum = 0.0;

        for (int num : nums) {
            sum += num;
            pq.offer((double) num);
        }

        double target = sum / 2.0;
        int steps = 0;
        while (sum > target) {
            steps++;
            double cur = pq.poll();
            double half = cur / 2.0;
            sum -= half;

            while (half >= pq.peek() && sum > target) {
                steps++;
                half /= 2.0;
                sum -= half;
            }

            pq.offer(half);
        }

        return steps;
    }

    // 4
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {

        return -1;
    }
}
