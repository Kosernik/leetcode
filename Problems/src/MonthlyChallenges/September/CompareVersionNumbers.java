package MonthlyChallenges.September;

import java.util.Arrays;

public class CompareVersionNumbers {
    public static void main(String[] args) {
        CompareVersionNumbers solution = new CompareVersionNumbers();
        solution.testCompareVersion();
    }

    /**
     * Comparing two versions.
     * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
     * Version can`t start or end with ".". Can contain leading zeroes.
     *
     * @param version1 - String representation of a version 1.
     * @param version2 - String representation of a version 2.
     * @return - -1 if v1<v2, 1 if v1>v2, 0 if v1=v2.
     */
    public int compareVersion(String version1, String version2) {
        if (version1 == null && version2 == null) return 0;
        else if (version1 == null) return -1;
        else if (version2 == null) return 1;
        else if (version1.length() == 0 && version2.length() == 0) return 0;
        else if (version1.length() == 0) return -1;
        else if (version2.length() == 0) return 1;

        String[] v1splitted = version1.split("\\.");
        String[] v2splitted = version2.split("\\.");

        int length = Math.min(v1splitted.length, v2splitted.length);

        int i = 0;
        for (; i < length; i++) {
            int currV1 = Integer.parseInt(v1splitted[i]);
            int currV2 = Integer.parseInt(v2splitted[i]);

            if (currV1 == currV2) continue;
            return currV1 > currV2 ? 1 : -1;
        }

        if (v1splitted.length == v2splitted.length) return 0;

        int result = v1splitted.length > v2splitted.length ? 1 : -1;
        String[] remainders = v1splitted.length > v2splitted.length ? v1splitted : v2splitted;

        for (; i < remainders.length; i++) {
            if (Integer.parseInt(remainders[i]) != 0) return result;
        }

        return 0;
    }

    private void testCompareVersion() {
        String[][] versions = {
                {"0.1", "1.1"},
                {"1.0.1", "1"},
                {"7.5.2.4", "7.5.3"},
                {"1.01", "1.001"},
                {"1.0", "1.0.0"},
                {"1.0", "1.0.1"},
                {"1.0.0", "1.0"},
                {"1.0.1", "1.0"},
                {"1.0.0.0.0.01", "1.0"},
                {"1.0.0.0.0.0.00", "1.0"},
                {"1.0", "1.0.0.0.0.1"},
                {"1.0", "1.0.0.0.0.0"}
        };
        int[] results = {-1,1,-1,0,0,-1,0,1,1,0,-1,0};

        if (versions.length != results.length) {
            System.out.println("Need tests for tests!");
            return;
        }

        int failed = 0;

        for (int i = 0; i < results.length; i++) {
            if (results[i] != compareVersion(versions[i][0], versions[i][1])) {
                failed++;
                System.out.println("Wrong result for test #: " + i);
                System.out.println(versions[i][0] + ", " + versions[i][1]);
                System.out.println("Got: " + compareVersion(versions[i][0], versions[i][1]) + ", instead of " + results[i]);
            }
        }

        System.out.println("Success rate: " + (results.length - failed) * 100.0 / results.length);
    }
}
