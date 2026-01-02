package MonthlyChallenges.Year21.March21;

public class ReconstructOriginalDigitsFromEnglish {
    //LeetCode #423.
    public String originalDigits(String s) {
        if (s == null || s.length() == 0) return "";

        int[] letters = new int[26];
        for (char ch : s.toCharArray()) letters[ch - 'a']++;

        int[] resultCount = new int[10];
        int[] order = {0, 2, 4, 6, 8, 1, 3, 5, 7, 9};
        for (int digit : order) {
            resultCount[digit] = countAndRemove(digit, letters);
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i <= 9; i++) {
            result.append(String.valueOf(i).repeat(Math.max(0, resultCount[i])));
        }

        return result.toString();
    }

    private int countAndRemove(int digit, int[] letters) {
        int count = 0;

        if (digit == 0) {
            count = letters['z' - 'a'];
            removeZero(count, letters);
        } else if (digit == 1) {
            count = letters['o' - 'a'];
            removeOne(count, letters);
        } else if (digit == 2) {
            count = letters['w' - 'a'];
            removeTwo(count, letters);
        } else if (digit == 3) {
            count = letters['t' - 'a'];
            removeThree(count, letters);
        } else if (digit == 4) {
            count = letters['u' - 'a'];
            removeFour(count, letters);
        } else if (digit == 5) {
            count = letters['f' - 'a'];
            removeFive(count, letters);
        } else if (digit == 6) {
            count = letters['x' - 'a'];
            removeSix(count, letters);
        } else if (digit == 7) {
            count = letters['s' - 'a'];
            removeSeven(count, letters);
        } else if (digit == 8) {
            count = letters['g' - 'a'];
            removeEight(count, letters);
        } else if (digit == 9) {
            count = letters['i' - 'a'];
            removeNine(count, letters);
        }

        return count;
    }

    private void removeZero(int count, int[] letters) {
        letters['z' - 'a'] -= count;
        letters['e' - 'a'] -= count;
        letters['r' - 'a'] -= count;
        letters['o' - 'a'] -= count;
    }

    private void removeOne(int count, int[] letters) {
        letters['o' - 'a'] -= count;
        letters['n' - 'a'] -= count;
        letters['e' - 'a'] -= count;
    }

    private void removeTwo(int count, int[] letters) {
        letters['t' - 'a'] -= count;
        letters['w' - 'a'] -= count;
        letters['o' - 'a'] -= count;
    }

    private void removeThree(int count, int[] letters) {
        letters['t' - 'a'] -= count;
        letters['h' - 'a'] -= count;
        letters['r' - 'a'] -= count;
        letters['e' - 'a'] -= count;
        letters['e' - 'a'] -= count;
    }

    private void removeFour(int count, int[] letters) {
        letters['f' - 'a'] -= count;
        letters['o' - 'a'] -= count;
        letters['u' - 'a'] -= count;
        letters['r' - 'a'] -= count;
    }

    private void removeFive(int count, int[] letters) {
        letters['f' - 'a'] -= count;
        letters['i' - 'a'] -= count;
        letters['v' - 'a'] -= count;
        letters['e' - 'a'] -= count;
    }

    private void removeSix(int count, int[] letters) {
        letters['s' - 'a'] -= count;
        letters['i' - 'a'] -= count;
        letters['x' - 'a'] -= count;
    }

    private void removeSeven(int count, int[] letters) {
        letters['s' - 'a'] -= count;
        letters['e' - 'a'] -= count;
        letters['v' - 'a'] -= count;
        letters['e' - 'a'] -= count;
        letters['n' - 'a'] -= count;
    }

    private void removeEight(int count, int[] letters) {
        letters['e' - 'a'] -= count;
        letters['i' - 'a'] -= count;
        letters['g' - 'a'] -= count;
        letters['h' - 'a'] -= count;
        letters['t' - 'a'] -= count;
    }

    private void removeNine(int count, int[] letters) {
        letters['n' - 'a'] -= count;
        letters['i' - 'a'] -= count;
        letters['n' - 'a'] -= count;
        letters['e' - 'a'] -= count;
    }
}
