package MonthlyChallenges.Year25.September;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfPeopleAwareOfSecret {
    public static void main(String[] args) {
        NumberOfPeopleAwareOfSecret solution = new NumberOfPeopleAwareOfSecret();

        int n0 = 6, delay0 = 2, forget0 = 4, result0 = 5;
        System.out.println(solution.peopleAwareOfSecret(n0, delay0, forget0) == result0);

        System.out.println();
        int n1 = 4, delay1 = 1, forget1 = 3, result1 = 6;
        System.out.println(solution.peopleAwareOfSecret(n1, delay1, forget1) == result1);

        System.out.println();
        int n2 = 289, delay2 = 7, forget2 = 23, result2 = 790409951;
        System.out.println(solution.peopleAwareOfSecret(n2, delay2, forget2) == result2);
    }

    /**
     * LeetCode №2327. Number of People Aware of a Secret.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param n      - the total number of days.
     * @param delay  - the number of days after which a person starts to share a secret.
     * @param forget - the number of days after which a person forgets a secret.
     * @return - the number of people who know the secret at the end of day n. Resul is modulo 1_000_000_007.
     */
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MODULO = 1_000_000_007;

        int day = delay + 1;
        long currentPeople = 0;

        //  {day, peopleCount}
        Deque<long[]> delayed = new ArrayDeque<>();
        delayed.addLast(new long[]{delay + 1L, 1L});

        Deque<long[]> forgetting = new ArrayDeque<>();
        forgetting.addFirst(new long[]{forget + 1L, 1L});

        while (day <= n) {
            // remove people who forgot from current people
            if (!forgetting.isEmpty() && forgetting.peekFirst()[0] == day) {
                currentPeople = customAddModulo(currentPeople, MODULO - forgetting.removeFirst()[1], MODULO);
            }

            // delayed people can share secret today
            if (!delayed.isEmpty() && delayed.peekFirst()[0] == day) {
                currentPeople = customAddModulo(currentPeople, delayed.removeFirst()[1], MODULO);
            }

            // current people share secret with new people
            long newPeople = currentPeople;

            // new people will share after "delay" days
            delayed.addLast(new long[]{day + delay, newPeople});

            // new people will forget after "forget" days
            forgetting.addLast(new long[]{day + forget, newPeople});

            // start new day
            day++;
        }

        while (!delayed.isEmpty()) {
            currentPeople = customAddModulo(currentPeople, delayed.removeFirst()[1], MODULO);
        }

        return (int) currentPeople;
    }

    private static long customAddModuloAlt(long number, long add, int modulo) {
        return (number + add) % modulo;
    }

    private static long customAddModulo(long number, long add, int modulo) {
        number += add;
        while (number >= modulo) {
            number -= modulo;
        }

        return number;
    }
}
