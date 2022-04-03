package Problems;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class DesignAuthenticationManager {

    /**
     * LeetCode #1797. Design Authentication Manager.
     */
    class AuthenticationManager {
        private final Map<String, Pair> tokens = new HashMap<>();
        private final ArrayDeque<Pair> queue = new ArrayDeque<>();

        private final int timeToLive;

        public AuthenticationManager(int timeToLive) {
            this.timeToLive = timeToLive;
        }

        public void generate(String tokenId, int currentTime) {
            updateQueue(currentTime);

            Pair pair = new Pair(tokenId, timeToLive + currentTime);

            tokens.put(tokenId, pair);
            queue.offerLast(pair);
        }

        public void renew(String tokenId, int currentTime) {
            updateQueue(currentTime);

            if (tokens.containsKey(tokenId)) {
                Pair original = tokens.get(tokenId);
                Pair pair = new Pair(tokenId, timeToLive + currentTime);

                tokens.put(tokenId, pair);
                queue.remove(original);
                queue.offerLast(pair);
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            updateQueue(currentTime);

            return tokens.size();
        }

        private void updateQueue(int currentTime) {
            while (!queue.isEmpty() && queue.peekFirst().expirationTime <= currentTime) {
                Pair pair = queue.removeFirst();
                tokens.remove(pair.tokenId);
            }
        }

        class Pair {
            String tokenId;
            int expirationTime;

            public Pair(String tokenId, int expirationTime){
                this.tokenId = tokenId;
                this.expirationTime = expirationTime;
            }
        }
    }
}
