package ExploreCards.NaryTree;

import java.util.*;

public class NaryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {return result;}

        helper(result, root);
        return result;
    }
    private void helper(List<Integer> list, Node root) {
        if (root == null) return;
        if (root.children != null) {
            for (Node child : root.children) {
                helper(list, child);
            }
        }
        list.add(root.val);
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
