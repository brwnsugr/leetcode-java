package written.leetcode.amazon.LinkedLists;

public class MergeTwoSortedLists {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    /**
     * First, make new Linked list to save the merged list of list1, list2
     * In short, it's a linked list to save the concatenated the two lists.
     *
     * iterate list1 list2 at the same time, and pick both element from that two lists
     * and comapare these element and just put the smaller one to the new linked list,
     * and remove the smaller element from those linked lists.
     * It's kind of recursive approach
     *
     * just compare and compare when is the end of that recursive computing?
     * if we encounter both two linkedLists are all null value. (both two lists don't have any valid nodes)
     */

    ListNode dummy = new ListNode(-1);

    ListNode curr = dummy;
    recursive(curr, list1, list2);
    return dummy.next;
  }

  private void recursive(ListNode curr, ListNode list1, ListNode list2) {
    if(list1 == null && list2 == null) return;
    else{
      int val1 = list1 == null ? 101 : list1.val;
      int val2 = list2 == null ? 101 : list2.val;
      if(val1 < val2) {
        curr.next = list1;
        list1 = list1.next;
      }
      else {
        curr.next = list2;
        list2 = list2.next;
      }
      recursive(curr.next, list1, list2);
    }
  }

  public static void main(String[] args) {
    ListNode list1 = new ListNode(1);
    list1.next = new ListNode(2, new ListNode(4));

    ListNodeData listNodeData = new ListNodeData(3);

    listNodeData.next = new ListNodeData(3);
    ListNode list2 = new ListNode(1);
    list2.next = new ListNode(3, new ListNode(4));

    MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
    mergeTwoSortedLists.mergeTwoLists(list1, list2);
  }

}
