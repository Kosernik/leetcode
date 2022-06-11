package Contests;

import java.util.*;

public class BiweeklyContest80 {

    public static void main(String[] args) {
        BiweeklyContest80 solution = new BiweeklyContest80();

        solution.test("Hello wrld!");
    }

    private void test(String input) {
        System.out.println(input);
    }


    //  1
    public boolean strongPasswordCheckerII(String password) {
        if (password == null || password.length() < 8) return false;

        //  ! @ # $ % ^ & * ( ) - +
        Set<Character> specialChars = new HashSet<>();
        specialChars.add('!');specialChars.add('@');specialChars.add('#');specialChars.add('$');specialChars.add('%');
        specialChars.add('^');specialChars.add('&');specialChars.add('*');specialChars.add('(');specialChars.add(')');
        specialChars.add('-');specialChars.add('+');

        boolean lowercase = false;
        boolean uppercase = false;
        boolean digit = false;
        boolean special = false;

        char[] letters = password.toCharArray();

        for (int i = 0; i < password.length(); i++) {
            if (i > 0 && letters[i-1] == letters[i]) return false;
            char curLetter = letters[i];
            if (Character.isLowerCase(curLetter)) {
                lowercase = true;
            } else if (Character.isUpperCase(curLetter)) {
                uppercase = true;
            } else if (Character.isDigit(curLetter)) {
                digit = true;
            } else if (specialChars.contains(curLetter)) {
                special = true;
            }
        }

        return lowercase && uppercase && digit && special;
    }

    //  2
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] numberOfPairs = new int[spells.length];

        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {
            int target = (int) Math.ceil((double)success / spells[i]);

            int idx = binSearch(potions, target);
            if (idx == potions.length) continue;

            numberOfPairs[i] = potions.length - idx;
        }

        return numberOfPairs;
    }

    private int binSearch( int[] potions, int target) {
        int left = 0, right = potions.length, middle;

        while (left < right) {
            middle = (right - left) / 2 + left;

            if (potions[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }

    //  3
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        Map<Character, Set<Character>> swaps = new HashMap<>();

        for (char[] pair : mappings) {
            char old = pair[0];
            char newChar = pair[1];
            if (!swaps.containsKey(old)) swaps.put(old, new HashSet<>());

            swaps.get(old).add(newChar);
        }

        LinkedList<Character> curWindow = new LinkedList<>();
        char[] firstWord = s.toCharArray();
        char[] secondWord = sub.toCharArray();

        for (int i = 0; i < secondWord.length; i++) {
            curWindow.add(firstWord[i]);
        }
        if (canReplase(curWindow, secondWord, swaps)) return true;

        for (int i = sub.length(); i < firstWord.length; i++) {
            curWindow.removeFirst();
            curWindow.add(firstWord[i]);

            if (canReplase(curWindow, secondWord, swaps)) return true;
        }

        return false;
    }

    private boolean canReplase (
            LinkedList<Character> curWindow,
            char[] secondWord,
            Map<Character, Set<Character>> swaps
    ) {
        int idx = 0;

        for (Character letter : curWindow) {
            if (letter != secondWord[idx]) {
                if (!swaps.containsKey(secondWord[idx]) || !swaps.get(secondWord[idx]).contains(letter)) return false;
            }
            idx++;
        }

        return true;
    }

    //  4
    public long countSubarrays(int[] nums, long k) {
        long result = 0L;
        long curSum = 0L;

        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            curSum += nums[right];
            int length = right - left + 1;

            while (left <= right && curSum * length >= k) {
                curSum -= nums[left];
                left++;
                length--;
            }

            if (left > right) continue;
            if (curSum * length < k) {
                result += length;
            }
        }

        return result;
    }
}
