package ExploreCards.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();

        Node deepCopyHead = new Node(0);
        Node currNode = deepCopyHead;
        Node origNode = head;

        while (origNode != null) {
            currNode.next = new Node(origNode.val);
            currNode = currNode.next;

            map.put(origNode, currNode);

            origNode = origNode.next;
        }

        origNode = head;
        while (origNode != null) {
            Node origRandom = origNode.random;
            if (origRandom == null) {
                origNode = origNode.next;
                continue;
            }
            Node copied = map.get(origNode);

            copied.random = map.get(origRandom);
            origNode = origNode.next;
        }

        return deepCopyHead.next;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
