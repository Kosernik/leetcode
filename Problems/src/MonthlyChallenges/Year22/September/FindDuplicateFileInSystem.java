package MonthlyChallenges.Year22.September;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileInSystem {

    /**
     * LeetCode #609. Find Duplicate File in System.
     * <p>
     * Complexity - O(N*M), N = paths.length, M = average length of a path in paths.
     * Memory - O(N)
     *
     * @param paths - an array of paths."root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"
     * @return - a list of groups of duplicate file paths.
     */
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> contentToFiles = new HashMap<>();

        for (String path : paths) {
            parse(path, contentToFiles);
        }

        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : contentToFiles.entrySet()) {
            if (entry.getValue().size() > 1) {
                result.add(entry.getValue());
            }
        }

        return result;
    }

    private void parse(String path, Map<String, List<String>> contentToFiles) {
        String[] splitedPath = path.split("\\s+");

        for (int i = 1; i < splitedPath.length; i++) {
            int idx = splitedPath[i].indexOf('(');

            String content = splitedPath[i].substring(idx + 1, splitedPath[i].length() - 1);

            if (!contentToFiles.containsKey(content)) {
                contentToFiles.put(content, new ArrayList<>());
            }

            contentToFiles.get(content).add(splitedPath[0] + "/" + splitedPath[i].substring(0, idx));
        }
    }
}
