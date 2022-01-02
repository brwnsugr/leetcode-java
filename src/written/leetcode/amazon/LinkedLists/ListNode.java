package written.leetcode.amazon.LinkedLists;

public class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val){this.val = val;}
  ListNode(int val, ListNode next) {this.val = val; this.next = next;}

  public static ListNode makeList(int[] values) {
    if(values.length == 0) return new ListNode();
    ListNode listNode = new ListNode();
    ListNode dummyNode = listNode;

    for(int value : values) {
      ListNode newNode = new ListNode(value);
      listNode.next = newNode;
      listNode = listNode.next;
    }
    return dummyNode.next;
  }

}
