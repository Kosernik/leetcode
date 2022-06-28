package Problems;

import java.util.*;

public class OnlineElection {

    /**
     * LeetCode #911. Online Election.
     */
    class TopVotedCandidate {
        //  vote time -> person ID
        private final NavigableMap<Integer, Integer> votes = new TreeMap<>();

        public TopVotedCandidate(int[] persons, int[] times) {
            fillMap(persons, times);
        }

        private void fillMap(int[] persons, int[] times) {
            //  id -> Person
            Map<Integer, Person> ids = new HashMap<>();
            for (int p : persons) {
                if (ids.containsKey(p)) continue;
                Person person = new Person(p);
                ids.put(p, person);
            }

            PriorityQueue<Person> pq = new PriorityQueue<>();
            for (int i = 0; i < persons.length; i++) {
                Person person = ids.get(persons[i]);
                pq.remove(person);

                int time = times[i];

                person.updateVote(time);

                pq.offer(person);

                votes.put(time, pq.peek().getID());
            }
        }

        public int q(int t) {
            return votes.floorEntry(t).getValue();
        }

        class Person implements Comparable<Person> {
            final int id;
            int numberOfVotes = 0;
            int lastVote = -1;

            Person(int id) {
                this.id = id;
            }

            public int getID() {
                return this.id;
            }

            public void setVote(int vote) {
                this.lastVote = vote;
            }

            public int getLastVote() {
                return this.lastVote;
            }

            public void updateVote(int time) {
                setVote(time);
                this.numberOfVotes++;
            }

            @Override
            public boolean equals(Object obj) {
                if (!(obj instanceof Person)) return false;
                return ((Person) obj).getID() == this.getID();
            }

            @Override
            public int compareTo(Person o) {
                // reverse order by default
                return this.numberOfVotes != o.numberOfVotes ?
                        Integer.compare(o.numberOfVotes, this.numberOfVotes) :
                        Integer.compare(o.getLastVote(), this.getLastVote());
            }
        }
    }
}
