package MonthlyChallenges.October;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() < 10) {
            return new ArrayList<>();
        }

        Set<String> sequences = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        StringBuilder builder = new StringBuilder(s);

        for (int i = 0; i+9 < s.length(); i++) {
            String currS = builder.substring(i, i+10);

            if (sequences.contains(currS)) {
                repeated.add(currS);
            }
            sequences.add(currS);
        }

        return new ArrayList<>(repeated);
    }
}
