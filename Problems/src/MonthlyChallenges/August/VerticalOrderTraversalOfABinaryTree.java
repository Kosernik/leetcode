package MonthlyChallenges.August;

import Utils.TreeNode;

import java.util.*;

public class VerticalOrderTraversalOfABinaryTree {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();
        if (root == null) return traversal;

        Map<TreeNode, Integer> verticalIndexes = new HashMap<>();
        TreeMap<Integer, List<Integer>> lists = new TreeMap<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        verticalIndexes.put(root, 0);

        while (!queue.isEmpty()) {
            Map<Integer, List<Integer>> currLevel = new HashMap<>();

            for (int i = 0, length = queue.size(); i < length; i++) {
                TreeNode currNode = queue.poll();
                int currVertical = verticalIndexes.get(currNode);
                if (currLevel.containsKey(currVertical)) {
                    List<Integer> list = currLevel.get(currVertical);
                    list.add(currNode.val);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(currNode.val);
                    currLevel.put(currVertical, list);
                }
                if (currNode.left != null) {
                    verticalIndexes.put(currNode.left, currVertical-1);
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    verticalIndexes.put(currNode.right, currVertical+1);
                    queue.offer(currNode.right);
                }
            }
            for (Map.Entry<Integer, List<Integer>> entry : currLevel.entrySet()) {
                if (!lists.containsKey(entry.getKey())) {
                    lists.put(entry.getKey(), new ArrayList<>());
                }
                List<Integer> resList = lists.get(entry.getKey());
                List<Integer> currList = entry.getValue();
                currList.sort(Integer::compareTo);
                resList.addAll(currList);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : lists.entrySet()) {
            traversal.add(entry.getValue());
        }

        return traversal;
    }
}
