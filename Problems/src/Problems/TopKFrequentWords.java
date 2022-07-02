package Problems;

import java.util.*;

public class TopKFrequentWords {

    /**
     * LeetCode #692. Top K Frequent Words.
     *
     * Complexity - O(NlogK)
     * Memory - O(N)
     *
     * @param words - an array of strings.
     * @param k - the number of most frequent words.
     * @return - a list of k-most frequent words in 'words'.
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
            if (pq.size() > k) {
                pq.remove();
            }
        }

        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            Pair curPair = pq.remove();
            result.add(curPair.word);
        }
        Collections.reverse(result);
        return result;
    }

    class Pair implements Comparable<Pair>{
        String word;
        int count;

        Pair(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(Pair other) {
            if (other != null) {
                if (this.count != ((Pair) other).count) {
                    return Integer.compare(this.count, ((Pair) other).count);
                } else {
                    return String.CASE_INSENSITIVE_ORDER.compare(((Pair) other).word, this.word);
                }
            }
            return -1;
        }
    }
}
