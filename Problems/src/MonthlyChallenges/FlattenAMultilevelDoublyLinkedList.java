package MonthlyChallenges;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class FlattenAMultilevelDoublyLinkedList {

    public Node flatten(Node head) {
        // Проверка на null pointer
        if (head == null) return head;

        // Создаем стак для прохода по листу методом Depth-first search
        Stack<Node> stack = new Stack<>();
        stack.add(head);

        // Dummy-head итогового листа
        Node flatHead = new Node();
        // Указатель на текущий узел листа
        Node currentNode = flatHead;

        // Пока в стеке есть елементы, выполняем ДФС
        while (!stack.isEmpty()) {
            // Удаляем из стека последний добавленный узел
            Node node = stack.pop();
            // Создаем узел для итогового листа и обновляем значение VAl
            Node nextNode = new Node();
            nextNode.val = node.val;
            // Добавляем узел в итоговый лист и обновляем указатель
            currentNode.next = nextNode;
            nextNode.prev = currentNode;
            currentNode = currentNode.next;

            // Если у узла есть следующий сосед, добавляем его в конец стека, но...
            if (node.next != null) { stack.add(node.next); }
            // ... перед этим проверяем, есть ли у узла потомок, если есть то добавляем его в стек и обрабатываем на
            // следующей итерации
            if (node.child != null) { stack.add(node.child); }
        }

        // Удаляем у головного элемента ссылку на dummy-head и возвращаем результат
        Node result = flatHead.next;
        result.prev = null;
        return result;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
//        Node (int val) {this.val = val;}
    }
}
