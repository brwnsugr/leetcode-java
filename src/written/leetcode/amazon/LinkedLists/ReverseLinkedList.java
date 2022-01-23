package written.leetcode.amazon.LinkedLists;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ReverseLinkedList {

  public ListNode reverseList(ListNode head) {
    /**
     * ListNode 그대로 순회 -> 새로운 list 에다가 저장함 (ArrayList) -> listNode 의 길이를 모르기 때문에 동적으로 element를 넣을 수 있는 구조로 가는게 좋음
     * (while traversing the list , we add it to the new arraylist and then,
     * we traverse the new array list in reverse order and save it to the new linked list in that order
     * therefore, new arraylist in reverse order is just the right order of the reversed linked list.
     * list node :  1->3-5,  new arraylist : 1,3,5  -> iterate the new arrayslist in reverse (5->3->1)
     *
     */
    if(head == null) return null;
    if(head.next == null) return head;
    List<Integer> arr = new ArrayList<>();

//    ListNode curr = head;

    while(head != null) {
      arr.add(head.val);
      head = head.next;
    }

    //traverse the arr in reverse and save to the new ListNode simultaneously.

    ListNode dummy = new ListNode();
    ListNode curr = dummy;

    for(int i = arr.size()-1; i >= 0; i--) {
      curr.next = new ListNode(arr.get(i));
      curr = curr.next;
    }

    return dummy.next;
  }

}


