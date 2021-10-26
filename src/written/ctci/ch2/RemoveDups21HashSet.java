package written.ctci.ch2;

import java.util.HashSet;
import java.util.Set;
import written.ctci.ch2.RemoveDups21.ListNode;

public class RemoveDups21HashSet {

  private Set<Integer> hashSet = new HashSet<>();

  static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
      this.val = val; this.next = next;
    }
  }

  public ListNode solution(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;

    while(curr != null) {
      if(hashSet.contains(curr.val)) {
        prev.next = prev.next.next;
      } else {
        hashSet.add(curr.val);
        prev = curr;
      }
      curr = curr.next;
    }
    return head;
  }


  public static void main(String[] args) {
    ListNode head = new ListNode(2);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);

    RemoveDups21HashSet removeDups21HashSet = new RemoveDups21HashSet();

    ListNode solution = removeDups21HashSet.solution(head);

    System.out.println("dddd");


  }





}
