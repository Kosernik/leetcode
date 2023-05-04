package MonthlyChallenges.Year23.May;

public class Dota2Senate {
    public static void main(String[] args) {
        Dota2Senate solution = new Dota2Senate();

        String test = "DDRRR";
        System.out.println(solution.predictPartyVictory(test));
    }


    /**
     * LeetCode #649. Dota2 Senate.
     *
     * @param senate - a string of senators .
     * @return - the winner of the vote.
     */
    public String predictPartyVictory(String senate) {
        StringBuilder senateBuilder = new StringBuilder();

        int radiantCount = 0;
        int direCount = 0;

        for (char party : senate.toCharArray()) {
            senateBuilder.append(party);
            if (party == 'R') {
                radiantCount++;
            } else {
                direCount++;
            }
        }

        int idx = 0;
        while (radiantCount > 0 && direCount > 0) {
            int nextIdx = (idx + 1) % senateBuilder.length();

            if (senateBuilder.charAt(idx) == 'R') {
                boolean deletedFromBeginning = deleteSenator(senateBuilder, 'D', nextIdx);
                if (deletedFromBeginning) {
                    idx--;
                }

                direCount--;
            } else {
                boolean deletedFromBeginning = deleteSenator(senateBuilder, 'R', nextIdx);
                if (deletedFromBeginning) {
                    idx--;
                }

                radiantCount--;
            }

            idx = (idx + 1) % senateBuilder.length();
        }

        if (radiantCount > 0) {
            return "Radiant";
        } else {
            return "Dire";
        }
    }

    private boolean deleteSenator(StringBuilder senate, char partyToBan, int startIdx) {
        boolean deletedFromBeginning = false;
        int idx = startIdx;

        while (true) {
            if (idx == 0) {
                deletedFromBeginning = true;
            }
            if (senate.charAt(idx) == partyToBan) {
                senate.deleteCharAt(idx);
                break;
            }
            idx = (idx + 1) % senate.length();
        }

        return deletedFromBeginning;
    }
}
