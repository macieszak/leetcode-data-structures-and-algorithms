package leetcode_problems.linked_list.merge_two_sorted_lists;

import leetcode_problems.linked_list.reverse_list.ListNode;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<ListNode> nodesList;

    public ListNode mergeTwoLists(ListNode firstHead, ListNode secondHead) {
        if (firstHead == null && secondHead == null) {
            return new ListNode();
        }
        nodesList = new ArrayList<>();
        while (firstHead != null || secondHead != null) {
            if (firstHead == null) {
                nodesList.add(secondHead);
                secondHead = secondHead.getNext();
            } else if (secondHead == null) {
                nodesList.add(firstHead);
                firstHead = firstHead.getNext();
            } else if (firstHead.getVal() < secondHead.getVal() || firstHead.getVal() == secondHead.getVal()) {
                nodesList.add(firstHead);
                firstHead = firstHead.getNext();
            } else {
                nodesList.add(secondHead);
                secondHead = secondHead.getNext();
            }
        }
        for (int i = 0; i < nodesList.size(); i++) {
            if (i == nodesList.size() - 1) {
                nodesList.get(i).setNext(null);
            } else {
                nodesList.get(i).setNext(nodesList.get(i + 1));
            }
        }
        return nodesList.get(0);
    }

    public void showNewMergedList() {
        for (ListNode node : nodesList) {
            if (node.getNext() == null) {
                node.setNext(new ListNode(-999999999));
            }
            System.out.println("node: " + node.getVal() + ", point on the next value: " + node.getNext().getVal());
        }
    }

}
