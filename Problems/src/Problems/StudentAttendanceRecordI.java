package Problems;

public class StudentAttendanceRecordI {

    /**
     * LeetCode #551. Student Attendance Record I.
     *
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param s - a string of chars 'A', 'L' and 'P'.
     * @return - True - if there are less than 2 'A' and less than 3 consecutive 'L' in 's'. False - otherwise.
     */
    public boolean checkRecord(String s) {
        int numberOfA = 0;

        char[] letters = s.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == 'A') {
                numberOfA++;
                if (numberOfA >= 2) return false;
            } else if (letters[i] == 'L' && i >= 2) {
                if (letters[i] == letters[i-1] && letters[i] == letters[i-2]) return false;
            }
        }

        return true;
    }
}
