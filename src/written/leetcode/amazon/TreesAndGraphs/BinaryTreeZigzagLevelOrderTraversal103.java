package written.leetcode.amazon.TreesAndGraphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal103 {
  public static int BOUNDED_VALUE = 2001;

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if(root == null) return new ArrayList<>();
    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> levelOrders = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();

    TreeNode boundNode = new TreeNode(BOUNDED_VALUE);

    q.add(root);
    q.add(boundNode);
    int reverseFlag = -1;

    while(!q.isEmpty()) {
      TreeNode currNode = q.poll();

      if(currNode.val == BOUNDED_VALUE) {
        if(reverseFlag > 0) Collections.reverse(levelOrders);
        answer.add(List.copyOf(levelOrders));
        reverseFlag *= -1;
        if(q.isEmpty()) break;
        else {
          levelOrders.clear();
          q.add(new TreeNode(BOUNDED_VALUE));
        }
      }
      if(currNode.val != BOUNDED_VALUE) {
        levelOrders.add(currNode.val);
      }

      if(currNode.left != null) q.add(currNode.left);
      if(currNode.right != null) q.add(currNode.right);
    }
    return answer;
  }

}
