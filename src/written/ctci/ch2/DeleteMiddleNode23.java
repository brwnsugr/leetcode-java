package written.ctci.ch2;

public class DeleteMiddleNode23 {

  static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
      this.val = val; this.next = next;
    }
  }

  public boolean deleteNode(ListNode c) {
    if(c == null || c.next == null) {
      return false;
    }
    ListNode next = c.next;
    c.val = next.val;
    c.next = next.next;
    return true;
  }

}
