package written.leetcode.amazon.LinkedLists;

import java.util.PriorityQueue;

public class MergeKSortedLists23 {
  public ListNode mergeKLists(ListNode[] lists) {

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for(ListNode listNode : lists) {
      while(listNode != null) {
        pq.add(listNode.val);
        listNode = listNode.next;
      }
    }

    ListNode dummy = new ListNode();
    ListNode currNode = dummy;


    while(!pq.isEmpty()) {
      ListNode nodeToAdd = new ListNode(pq.poll());
      currNode.next = nodeToAdd;
      currNode = currNode.next;
    }
    return dummy.next;
  }

}
