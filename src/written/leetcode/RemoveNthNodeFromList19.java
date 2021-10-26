package written.leetcode;



public class RemoveNthNodeFromList19 {

  static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
      this.val = val; this.next = next;
    }
  }

  public int getNthElementFromEnd(ListNode head, int n) {

    int size = getSize(head);

    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    // Base
    if(size == n) {
      return head.val;
    }

    ListNode curr = head;

    while(curr != null) {
      if(size == n) {
        return curr.val;
      }
      curr = curr.next;
      size--;
    }

    return head.val;
  }

  private int getSize(ListNode head) {
    ListNode curr = head;
    int size = 0;
    while(curr != null) {
      size++;
      curr = curr.next;
    }
    return size;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    ListNode head2 = new ListNode(1);

    RemoveNthNodeFromList19 removed = new RemoveNthNodeFromList19();

    int nthElementFromEnd = removed.getNthElementFromEnd(head, 4);


  }

}
