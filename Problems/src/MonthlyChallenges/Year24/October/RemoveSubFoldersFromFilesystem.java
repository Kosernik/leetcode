package MonthlyChallenges.Year24.October;

import java.util.*;

public class RemoveSubFoldersFromFilesystem {

    /**
     * LeetCode №1233. Remove Sub-Folders from the Filesystem.
     * <p>
     * Complexity - O(NlogN + N*M), N = folder.length, M = folder[i].length.
     * Memory - O(N*M)
     *
     * @param folder - an array of strings representing folder paths. All paths always starts with the character '/'.
     *               All paths are unique.
     * @return - the list of folders after removing all sub-folders in 'folder'.
     */
    public List<String> removeSubfolders(String[] folder) {
        Trie root = new Trie();
        Arrays.sort(folder, Comparator.comparingInt(String::length));

        List<String> result = new ArrayList<>();

        for (String path : folder) {
            String[] folderPath = path.split("/");
            Trie node = root;
            boolean validPath = true;

            for (int i = 1; i < folderPath.length; i++) {
                if (node.isPath) {
                    validPath = false;
                    break;
                }

                if (!node.children.containsKey(folderPath[i])) {
                    node.children.put(folderPath[i], new Trie());
                }
                node = node.children.get(folderPath[i]);
            }

            node.isPath = true;

            if (validPath) result.add(path);
        }

        return result;
    }

    class Trie {
        Map<String, Trie> children;
        boolean isPath = false;

        Trie() {
            children = new HashMap<>();
        }
    }
}
