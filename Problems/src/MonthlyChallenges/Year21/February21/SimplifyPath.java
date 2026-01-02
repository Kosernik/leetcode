package MonthlyChallenges.Year21.February21;

import java.util.ArrayDeque;

public class SimplifyPath {
    //"/home/"
    //"/../"
    //"/home//foo/"
    //"/a/./b/../../c/"
    //"/a/b/.../c"

    /**
     * LeetCode #71.
     * <p>
     * Complexity - O(N)
     * Memory - O(N)
     *
     * @param path - a string representing absolute path.
     * @return - simplified canonical path.
     */
    public String simplifyPath(String path) {
        ArrayDeque<String> stack = new ArrayDeque<>();

        int idx = 0;


        while (idx < path.length()) {
            while (idx < path.length() && path.charAt(idx) == '/') {
                idx++;
            }
            StringBuilder folder = new StringBuilder();
            while (idx < path.length() && path.charAt(idx) != '/') {
                folder.append(path.charAt(idx));
                idx++;
            }

            if (folder.toString().equals(".")) {
                continue;
            } else if (folder.toString().equals("..")) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else {
                if (folder.length() > 0) stack.addLast(folder.toString());
            }
        }

        StringBuilder result = new StringBuilder();
        result.append('/');

        if (stack.isEmpty()) return result.toString();
        while (!stack.isEmpty()) {
            String curr = stack.removeFirst();
            result.append(curr);
            result.append('/');
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}
