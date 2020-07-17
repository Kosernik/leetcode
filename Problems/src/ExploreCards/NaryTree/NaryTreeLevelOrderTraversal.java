package ExploreCards.NaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) { return result; }

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>();

            for (int i = 0, length = queue.size(); i < length; i++) {
                Node currNode = queue.poll();
                currLevel.add(currNode.val);
                if (currNode.children != null) {
                    for (Node child : currNode.children) {
                        if (child != null) queue.offer(child);
                    }
                }
            }

            result.add(currLevel);
        }

        return result;
    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
