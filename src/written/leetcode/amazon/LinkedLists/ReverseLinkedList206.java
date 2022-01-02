package written.leetcode.amazon.LinkedLists;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList206 {
  public ListNode reverseList(ListNode head) {
    List<Integer> valueList = new ArrayList<>();

    while(head != null) {
      valueList.add(head.val);
      head = head.next;
    }

    ListNode dummy = new ListNode();
    ListNode currNode = dummy;

    for(int i = valueList.size() - 1; i >= 0; i--) {
      ListNode nodeToAdd = new ListNode(valueList.get(i));
      currNode.next = nodeToAdd;
      currNode = currNode.next;
    }
    return dummy.next;
  }

  public static void main(String[] args) {

  }

}
