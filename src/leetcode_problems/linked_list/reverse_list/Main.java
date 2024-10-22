package leetcode_problems.linked_list.reverse_list;

public class Main {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        head.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(fifth);
        fifth.setNext(null);

        Solution reverseLinkedListSolution = new Solution();
/*
        ListNode newHead = reverseLinkedListSolution.reverseListIterativeSolution(head);
        System.out.println("New head is: " + newHead.getVal() + ", next value is: " + newHead.getNext().getVal());
*/
        ListNode newHead = reverseLinkedListSolution.reverseListRecursiveSolution(head);
        System.out.println("New head is: " + newHead.getVal());

    }

}

class Solution {

    public ListNode reverseListIterativeSolution(ListNode head) {
        ListNode newHead = null;
        while (head.getNext() != null) {
            ListNode next = head.getNext();
            head.setNext(newHead);
            newHead = head;
            head = next;
        }
        head.setNext(new ListNode(-111111));
        return head;
    }

    public ListNode reverseListRecursiveSolution(ListNode head) {
        return reverseListRecursiveHelperMethod(head, null);
    }

    private ListNode reverseListRecursiveHelperMethod(ListNode head, ListNode newHead) {
        if (head.getNext() == null) {
            return head;
        } else {
            ListNode next = head.getNext();
            head.setNext(newHead);
            newHead = head;
            head = next;
        }
        return reverseListRecursiveHelperMethod(head, newHead);
    }

}
