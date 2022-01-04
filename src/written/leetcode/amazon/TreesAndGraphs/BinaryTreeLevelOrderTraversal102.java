package written.leetcode.amazon.TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102 {
  public List<List<Integer>> levelOrder(TreeNode root) {
    if(root == null) return new ArrayList<>();
    TreeNode boundNode = new TreeNode(1001);
    List<List<Integer>> answer = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();

    q.add(root);
    q.add(boundNode);

    List<Integer> levelOrder = new ArrayList<>();
    while(!q.isEmpty()) {
      TreeNode currNode = q.poll();
      if(currNode.val != 1001) levelOrder.add(currNode.val);
      else if(currNode.val == 1001) {
        List<Integer> leverOrderToAdd = List.copyOf(levelOrder);
        answer.add(leverOrderToAdd);
        if(q.isEmpty()) break;
        else {
          levelOrder.clear();
          q.add(new TreeNode(1001));
        }
      }
      if(currNode.left != null) q.add(currNode.left);
      if(currNode.right != null) q.add(currNode.right);
    }
    return answer;
  }

}
