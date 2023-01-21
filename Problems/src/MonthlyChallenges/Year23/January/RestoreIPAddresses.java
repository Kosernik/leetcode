package MonthlyChallenges.Year23.January;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

    /**
     * LeetCode #93. Restore IP Addresses.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s - a string of numeric chars.
     * @return - a list of all valid IPs formed by inserting dots into "s".
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int[] digits = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }
        bactrack(digits, 0, new int[4], 0, result);
        return result;
    }

    private void bactrack(int[] digits, int idxDigit, int[] IP, int idxIP, List<String> validIPs) {
        // Final segment of the IP
        if (idxDigit >= digits.length) {
            if (idxIP != 4) return;
            for (int segment : IP) {
                if (segment < 0 || segment > 255) return;
            }
            String valid = IP[0] + "." + IP[1] + "." + IP[2] + "." + IP[3];
            validIPs.add(valid);
            return;
        } else if (idxIP >= IP.length) {
            return;
        }

        //  Corner case digits[idxDigit] == 0
        if (digits[idxDigit] == 0) {
            IP[idxIP] = digits[idxDigit];
            bactrack(digits, idxDigit + 1, IP, idxIP + 1, validIPs);
        } else {
            int curNumber = 0;
            for (int i = 0; i < 3; i++) {
                if (idxDigit + i >= digits.length) {
                    break;
                }
                curNumber = curNumber * 10 + digits[idxDigit + i];
                if (curNumber > 255) {
                    break;
                }
                IP[idxIP] = curNumber;
                bactrack(digits, idxDigit + i + 1, IP, idxIP + 1, validIPs);
                IP[idxIP] = 0;
            }
        }
    }
}
