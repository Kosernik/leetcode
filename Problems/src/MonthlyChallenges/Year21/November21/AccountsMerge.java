package MonthlyChallenges.Year21.November21;

import java.util.*;

public class AccountsMerge {

    private int[] unionSet;

    /**
     * LeetCode #721. Accounts Merge.
     *
     * @param accounts - a list of accounts.
     * @return - the list of merged accounts.
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailsToIdx = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        for (List<String> acc : accounts) {
            String name = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                if (!emailsToIdx.containsKey(acc.get(i))) {
                    emailsToIdx.put(acc.get(i), emailsToIdx.size());
                    emailToName.put(acc.get(i), name);
                }
            }
        }

        unionSet = new int[emailsToIdx.size()];
        for (int i = 0; i < unionSet.length; i++) unionSet[i] = i;

        for (List<String> acc : accounts) {
            int parentId = find(emailsToIdx.get(acc.get(1)));
            for (int i = 2; i < acc.size(); i++) {
                parentId = union(parentId, emailsToIdx.get(acc.get(i)));
            }
        }

        Map<Integer, Set<String>> unions = new HashMap<>();
        for (Map.Entry<String, Integer> entry : emailsToIdx.entrySet()) {
            int id = find(entry.getValue());

            Set<String> emails = unions.getOrDefault(id, new HashSet<>());
            emails.add(entry.getKey());
            unions.put(id, emails);
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> entry : unions.entrySet()) {
            List<String> mails = new ArrayList<>(entry.getValue());
            Collections.sort(mails);
            mails.add(0, emailToName.get(mails.get(0)));
            result.add(mails);
        }

        return result;
    }

    private int union(int first, int second) {
        int idF = find(first);
        int idS = find(second);

        if (idF == idS) return idF;

        unionSet[idF] = idS;
        return idS;
    }

    private int find(int id) {
        if (unionSet[id] != id) {
            unionSet[id] = find(unionSet[id]);
        }
        return unionSet[id];
    }
}
