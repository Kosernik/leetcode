package Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryWatch {
    /**
     * LeetCode #401. Binary Watch.
     *
     * @param turnedOn - the number of LEDs that are currently on.
     * @return - a list of all possible times the watch could represent.
     */
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        if (turnedOn < 0 || turnedOn >= 9) return result;
        else if (turnedOn == 0) {
            result.add("0:00");
            return result;
        }

        Map<Integer, List<Integer>> hours = fillHours(Math.min(3, turnedOn));
        Map<Integer, List<Integer>> minutes = fillMinutes(turnedOn);

        for (int i = 0; i <= Math.min(3, turnedOn); i++) {
            int minutesTurned = turnedOn - i;
            if (minutesTurned > 5) continue;

            for (Integer hour : hours.get(i)) {
                for (Integer minute : minutes.get(minutesTurned)) {
                    result.add(hour + ":" + getMinute(minute));
                }
            }
        }

        return result;
    }

    private static Map<Integer, List<Integer>> fillMinutes(int maxLeds) {
        Map<Integer, List<Integer>> minutes = new HashMap<>();

        for (int i = 0; i < 60; i++) {
            int curCount = Integer.bitCount(i);
            if (curCount > maxLeds) continue;
            List<Integer> curList = minutes.getOrDefault(curCount, new ArrayList<>());
            curList.add(i);
            minutes.put(curCount, curList);
        }

        return minutes;
    }

    private static Map<Integer, List<Integer>> fillHours(int maxLEDs) {
        Map<Integer, List<Integer>> hours = new HashMap<>();

        List<Integer> zero = new ArrayList<>();
        zero.add(0);
        hours.put(0, zero);

        if (maxLEDs >= 1) {
            List<Integer> one = new ArrayList<>();
            one.add(1);one.add(2);one.add(4);one.add(8);
            hours.put(1, one);
        }

        if (maxLEDs >= 2) {
            List<Integer> two = new ArrayList<>();
            two.add(3);two.add(5);two.add(6);two.add(9);two.add(10);
            hours.put(2, two);
        }

        if (maxLEDs == 3) {
            List<Integer> three = new ArrayList<>();
            three.add(7);three.add(11);
            hours.put(3, three);
        }

        return hours;
    }

    private static String getMinute(int minute) {
        if (minute <= 9) return "0" + minute;
        return String.valueOf(minute);
    }
}
