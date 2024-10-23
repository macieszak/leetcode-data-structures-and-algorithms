package leetcode_problems.linked_list.merge_two_sorted_lists;

import leetcode_problems.linked_list.reverse_list.ListNode;

public class Main {

    public static void main(String[] args) {
        //first list
        ListNode headOfFirstList = new ListNode(1);
        ListNode secondOfFirstList = new ListNode(2);
        ListNode thirdOfFirstList = new ListNode(4);

        headOfFirstList.setNext(secondOfFirstList);
        secondOfFirstList.setNext(thirdOfFirstList);
        thirdOfFirstList.setNext(null);

        //second list
        ListNode headOfSecondList = new ListNode(1);
        ListNode secondOfSecondList = new ListNode(3);
        ListNode thirdOfSecondList = new ListNode(4);

        headOfSecondList.setNext(secondOfSecondList);
        secondOfSecondList.setNext(thirdOfSecondList);
        thirdOfSecondList.setNext(null);

        Solution solution = new Solution();
        ListNode finalNode = solution.mergeTwoLists(headOfFirstList, headOfSecondList);
        System.out.println("final head node: " + finalNode.getVal() + "\n");

        solution.showNewMergedList();

    }

}
