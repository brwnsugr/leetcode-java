package written.leetcode.amazon.LinkedLists;

import java.util.ArrayList;
import java.util.List;

public class ReverseNodesInKGroup25 {
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode currNode = head;

    while(currNode != null) {
      List<Integer> kGroup = new ArrayList<>();
      int count = 0;
      ListNode kgroupHead = currNode;
      while(count < k && currNode != null) {
        kGroup.add(currNode.val);
        currNode = currNode.next;
        count++;
      }
      if(kGroup.size() < k) {
        break;
      }
      for(int i = k - 1; i >= 0; i--) {
        kgroupHead.val = kGroup.get(i);
        kgroupHead = kgroupHead.next;
      }
    }
    return head;
  }

  public static void main(String[] args) {
    ReverseNodesInKGroup25 reverseNodesInKGroup25 = new ReverseNodesInKGroup25();

  }

}
