package written.leetcode;
public class ReverseLinkedList {

  public ListNode reverse(ListNode head) {
    return getReversedList(head);
  }

  private ListNode getReversedList(ListNode curr) {
    if(curr == null || curr.next == null) return curr;

    ListNode p = getReversedList(curr.next);

    curr.next.next = curr;
    curr.next = null;

    return p;
  }


  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);

    ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
    ListNode reversed = reverseLinkedList.reverse(head);

    while(reversed != null) {
      System.out.println(" item is " + reversed.val);
      reversed = reversed.next;
    }
  }
}

class ListNode{
  ListNode next;
  int val;

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode() {
  }
}


