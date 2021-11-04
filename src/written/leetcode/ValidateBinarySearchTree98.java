package written.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree98 {

  private List<Integer> arr = new ArrayList<>();

  public boolean isValidBST(TreeNode root) {
    inOrderTraverse(root);
    for(int i = 0; i < arr.size() - 1; i++) {
      if(arr.get(i) >= arr.get(i+1)) return false;
    }
    return true;
  }

  private void inOrderTraverse(TreeNode curr) {
    if(curr == null) return;
    inOrderTraverse(curr.left);
    arr.add(curr.val);
    inOrderTraverse(curr.right);
  }


  static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }




}


