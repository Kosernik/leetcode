package MonthlyChallenges.November;

import Utils.ListNode;

public class AddTwoNumbersII {
    public static void main(String[] args) {
        AddTwoNumbersII solution = new AddTwoNumbersII();

        int[] arrl1 = {7,2,4,3};
        int[] arrl2 = {5,6,4};
        ListNode l1 = ListNode.getListFromArray(arrl1);
//        System.out.println(ListNode.printString(l1));
        ListNode l2 = ListNode.getListFromArray(arrl2);
//        System.out.println(ListNode.printString(l2));

        ListNode sum = solution.addTwoNumbers(l1, l2);
        System.out.println(ListNode.printString(sum));
    }

    /**
     * Returns the sum of two integer numbers represented as a linked list.
     *
     * Complexity - O(N1 + N2)
     * Memory - O(N1 + N2)
     *
     * @param l1 - first number, represented as a linked list.
     * @param l2 - second number, represented as a linked list.
     * @return - the sum of two numbers as a linked list.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode rl1 = reverseAList(l1);
        ListNode rl2 = reverseAList(l2);

        ListNode sumList = new ListNode();
        ListNode sumNode = sumList;
        int carry = 0;

        while (rl1 != null || rl2 != null) {
            int first = rl1 == null ? 0 : rl1.val;
            int second = rl2 == null ? 0 : rl2.val;

            int currNum = first + second + carry;
            if (currNum > 9) {
                carry = 1;
                currNum = currNum % 10;
            } else {
                carry = 0;
            }

            sumNode.next = new ListNode(currNum);
            sumNode = sumNode.next;

            rl1 = rl1 == null ? null : rl1.next;
            rl2 = rl2 == null ? null : rl2.next;
        }
        if (carry == 1) {
            sumNode.next = new ListNode(1);
        }

        ListNode result = reverseAList(sumList.next);
        return result;
    }

    private ListNode reverseAList(ListNode node) {
        ListNode reversed = new ListNode();
        ListNode currNode = node;

        while (currNode != null) {
            ListNode curr = new ListNode(currNode.val);
            curr.next = reversed.next;
            reversed.next = curr;
            currNode = currNode.next;
        }
        return reversed.next;
    }
}
