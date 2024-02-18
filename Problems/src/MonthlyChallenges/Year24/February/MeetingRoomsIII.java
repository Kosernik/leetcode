package MonthlyChallenges.Year24.February;

import java.util.Arrays;

public class MeetingRoomsIII {
    public static void main(String[] args) {
        MeetingRoomsIII solution = new MeetingRoomsIII();

        int[] testN = {2, 3, 4};

        int[][][] testMeetings = {
                {{0, 10}, {1, 5}, {2, 7}, {3, 4}},
                {{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}},
                {{18, 19}, {3, 12}, {17, 19}, {2, 13}, {7, 10}}
        };

        int[] results = {0, 1, 0};

        for (int i = 0; i < testN.length; i++) {
            int res = solution.mostBooked(testN[i], testMeetings[i]);
            if (res != results[i]) {
                System.out.println("Wrong result for test " + i);
            }
        }
        System.out.println("DONE");
    }

    /**
     * LeetCode №2402. Meeting Rooms III.
     * <p>
     * Complexity - O(MlogM + M*N), N = n, M = meetings.length.
     * Memory - O(N + M), M - sorting memory.
     *
     * @param n        - the total number of rooms.
     * @param meetings - a list of half-intervals of meetings, meetings[i][0] - starting time, meetings[i][1] - end time,
     *                 all starting times are unique.
     * @return - the number of the room that held the most meetings. If there are multiple rooms, return the room with
     * the lowest number.
     */
    public int mostBooked(int n, int[][] meetings) {
        int[] uses = new int[n];
        long[] endTimes = new long[n];

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] curMeeting : meetings) {
            int duration = curMeeting[1] - curMeeting[0];
            int startTime = curMeeting[0];

            int nextRoom = 0;
            long nextEndTime = Long.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                long curEndTime = endTimes[i];
                if (curEndTime <= startTime) {
                    nextRoom = i;
                    break;
                }

                if (endTimes[i] < nextEndTime) {
                    nextEndTime = endTimes[i];
                    nextRoom = i;
                }
            }

            uses[nextRoom]++;
            endTimes[nextRoom] = Math.max(endTimes[nextRoom], startTime) + duration;
        }

        int resultRoom = 0;
        int resultUse = uses[0];
        for (int i = 0; i < uses.length; i++) {
            if (uses[i] > resultUse) {
                resultUse = uses[i];
                resultRoom = i;
            }
        }

        return resultRoom;
    }
}
