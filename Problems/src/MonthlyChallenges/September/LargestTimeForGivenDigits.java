package MonthlyChallenges.September;

public class LargestTimeForGivenDigits {
    public static void main(String[] args) {
        LargestTimeForGivenDigits solution = new LargestTimeForGivenDigits();
        int[] test0 = {1,2,3,4};
        System.out.println(solution.largestTimeFromDigits(test0));
        int[] test1 = {0,0,0,0};
        System.out.println(solution.largestTimeFromDigits(test1));
//        System.out.println(solution.compareTimes(0,0, 12,7));
    }

    public String largestTimeFromDigits(int[] A) {
        int[] combinations = new int[12];
        // A [a, b, c, d]
        combinations[0] = A[0] * 10 + A[1];     //ab
        combinations[1] = A[1] * 10 + A[0];     //ba
        combinations[2] = A[0] * 10 + A[2];     //ac
        combinations[3] = A[2] * 10 + A[0];     //ca
        combinations[4] = A[0] * 10 + A[3];     //ad
        combinations[5] = A[3] * 10 + A[0];     //da
        combinations[6] = A[2] * 10 + A[3];     //cd
        combinations[7] = A[3] * 10 + A[2];     //dc
        combinations[8] = A[1] * 10 + A[3];     //bd
        combinations[9] = A[3] * 10 + A[1];     //db
        combinations[10] = A[1] * 10 + A[2];    //bc
        combinations[11] = A[2] * 10 + A[1];    //cb

        int maxHour = 0;
        int maxMinute = 0;
        boolean foundValidTime = false;


        for (int i = 0; i < 5; i += 2) {
            int leftOne = combinations[i];
            int leftTwo = combinations[i+1];
            int rightOne = combinations[i+6];
            int rightTwo = combinations[i+7];

            if (isValidTime(leftOne, rightOne)) {
                foundValidTime = true;
                if (compareTimes(maxHour, maxMinute, leftOne, rightOne) < 0) {
                    maxHour = leftOne; maxMinute = rightOne;
                }
            }
            if (isValidTime(rightOne, leftOne)) {
                foundValidTime = true;
                if (compareTimes(maxHour, maxMinute, rightOne, leftOne) < 0) {
                    maxHour = rightOne; maxMinute = leftOne;
                }
            }
            if (isValidTime(leftOne, rightTwo)) {
                foundValidTime = true;
                if (compareTimes(maxHour, maxMinute, leftOne, rightTwo) < 0) {
                    maxHour = leftOne; maxMinute = rightTwo;
                }
            }
            if (isValidTime(rightTwo, leftOne)) {
                foundValidTime = true;
                if (compareTimes(maxHour, maxMinute, rightTwo, leftOne) < 0) {
                    maxHour = rightTwo; maxMinute = leftOne;
                }
            }

            if (isValidTime(leftTwo, rightOne)) {
                foundValidTime = true;
                if (compareTimes(maxHour, maxMinute, leftTwo, rightOne) < 0) {
                    maxHour = leftTwo; maxMinute = rightOne;
                }
            }
            if (isValidTime(rightOne, leftTwo)) {
                foundValidTime = true;
                if (compareTimes(maxHour, maxMinute, rightOne, leftTwo) < 0) {
                    maxHour = rightOne; maxMinute = leftTwo;
                }
            }
            if (isValidTime(leftTwo, rightTwo)) {
                foundValidTime = true;
                if (compareTimes(maxHour, maxMinute, leftTwo, rightTwo) < 0) {
                    maxHour = leftTwo; maxMinute = rightTwo;
                }
            }
            if (isValidTime(rightTwo, leftTwo)) {
                foundValidTime = true;
                if (compareTimes(maxHour, maxMinute, rightTwo, leftTwo) < 0) {
                    maxHour = rightTwo; maxMinute = leftTwo;
                }
            }
        }

        return foundValidTime ? String.format("%02d", maxHour) + ":" + String.format("%02d", maxMinute) : "";
    }

    private int compareTimes(int hourFirst, int minuteFirst, int hourSecond, int minuteSecond) {
        if (hourFirst == hourSecond) {
            return minuteFirst - minuteSecond;
        } else {
            return hourFirst - hourSecond;
        }
    }

    private boolean isValidTime(int hour, int minute) {
        if (hour >= 24) return false;
        if (minute >= 60) return false;
        return true;
    }
}
