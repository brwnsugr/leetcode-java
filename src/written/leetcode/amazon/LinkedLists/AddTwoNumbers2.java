package written.leetcode.amazon.LinkedLists;

public class AddTwoNumbers2 {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyNode = new ListNode();
    ListNode currNode = dummyNode;

    int defer = 0;
    while(l1 != null || l2 != null) {
      int val1 = l1 == null ? 0 : l1.val;
      int val2 = l2 == null ? 0 : l2.val;
      int currDigitValue = val1 + val2 + defer;
      if(currDigitValue >= 10) {
        defer = 1;
      } else {
        defer = 0;
      }
      int r = currDigitValue % 10;
      if(l1 != null) l1 = l1.next;
      if(l2 != null) l2 = l2.next;
      ListNode newNode = new ListNode(r);
      currNode.next = newNode;
      currNode = currNode.next;
    }
    if(defer == 1) {
      currNode.next = new ListNode(1);
    }
    return dummyNode.next;
  }

  public static void main(String[] args) {
    AddTwoNumbers2 addTwoNumbers2 = new AddTwoNumbers2();
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(1);
    l2.next.next = new ListNode(1);
    l2.next.next.next = new ListNode(1);
    l2.next.next.next.next = new ListNode(1);
    l2.next.next.next.next.next = new ListNode(1);
    l2.next.next.next.next.next.next = new ListNode(1);
    l2.next.next.next.next.next.next.next = new ListNode(1);
    l2.next.next.next.next.next.next.next.next = new ListNode(1);
    l2.next.next.next.next.next.next.next.next.next = new ListNode(1);
    l2.next.next.next.next.next.next.next.next.next.next = new ListNode(1);

    l1.next = new ListNode(1);
    l1.next.next = new ListNode(1);
    l1.next.next.next = new ListNode(1);
    l1.next.next.next.next = new ListNode(1);
    l1.next.next.next.next.next = new ListNode(1);
    l1.next.next.next.next.next.next = new ListNode(1);
    l1.next.next.next.next.next.next.next = new ListNode(1);
    l1.next.next.next.next.next.next.next.next = new ListNode(1);
    l1.next.next.next.next.next.next.next.next.next = new ListNode(1);
    l1.next.next.next.next.next.next.next.next.next.next = new ListNode(1);

    addTwoNumbers2.addTwoNumbers(l1, l2);
  }
}

//class ListNode{
//  int val;
//  ListNode next;
//  ListNode() {}
//  ListNode(int val){this.val = val;}
//  ListNode(int val, ListNode next) {this.val = val; this.next = next;}
//}
