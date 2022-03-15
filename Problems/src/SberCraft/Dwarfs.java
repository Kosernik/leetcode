package SberCraft;

import java.util.Collections;
import java.util.List;

public class Dwarfs {

    /**
     * Implement function getNumberOfBoats
     */
    public static int getNumberOfBoats(List<Integer> dwarfs, int limit) {
        // Write your code here...

        int numberOfBoats = 0;
        Collections.sort(dwarfs);

        int left = 0, right = dwarfs.size()-1;

        while (left < right) {
            if (dwarfs.get(left) + dwarfs.get(right) <= limit) {
                left++;
            }

            right--;
            numberOfBoats++;
        }

        if (left == right) numberOfBoats++;

        return numberOfBoats;
    }

    public static void runCode() {
        // Entrypoint to debug your function
    }
}
