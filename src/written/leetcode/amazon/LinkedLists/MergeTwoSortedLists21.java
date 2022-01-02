package written.leetcode.amazon.LinkedLists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MergeTwoSortedLists21 {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 == null && l2 == null) return null;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    while(l1!=null) {
      pq.add(l1.val);
      l1 = l1.next;
    }

    while(l2!=null) {
      pq.add(l2.val);
      l2 = l2.next;
    }

    if(pq.size() == 0) return new ListNode();

    ListNode newNode = new ListNode();
    ListNode dummyNode = newNode;

    while(!pq.isEmpty()) {
      newNode.next = new ListNode(pq.poll());
      newNode = newNode.next;
    }

    return dummyNode.next;
  }

  public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
    if(l1 == null && l2 == null) return null;
    List<Integer> mergedList = new ArrayList<>();

    while(l1 != null) {
      mergedList.add(l1.val);
      l1 = l1.next;
    }

    while(l2 != null) {
      mergedList.add(l2.val);
      l2 = l2.next;
    }

    if(mergedList.size() == 0) return new ListNode();
    Collections.sort(mergedList);
    ListNode newNode = new ListNode();
    ListNode dummyNode = newNode;

    for(int i = 0; i < mergedList.size(); i++) {
      newNode.next = new ListNode(mergedList.get(0));
      newNode = newNode.next;
    }

    return dummyNode.next;
  }

  public static void main(String[] args) {
    MergeTwoSortedLists21 mergeTwoSortedLists21 = new MergeTwoSortedLists21();
    ListNode l1 = ListNode.makeList(new int[]{});
    ListNode l2 = ListNode.makeList(new int[]{});
    mergeTwoSortedLists21.mergeTwoLists(l1,l2);

    System.out.println("dddd");
  }

}
