package written.leetcode.amazon.TreesAndGraphs;

public class BinaryTreeMaximumPathSum124 {

  private int answer;

  public int maxPathSum(TreeNode root) {
    if(root.left == null && root.right == null) return root.val;
    answer = Integer.MIN_VALUE;
    getMaxSum(root);
    return answer;
  }

  private int getMaxSum(TreeNode currNode) {
    if(currNode == null) return 0;
    int leftMax = Math.max(getMaxSum(currNode.left), 0);
    int rightMax = Math.max(getMaxSum(currNode.right), 0);
    int newPathSum = currNode.val + leftMax + rightMax;
    answer = Math.max(newPathSum, answer);
    return currNode.val + Math.max(leftMax, rightMax);
  }

  public static void main(String[] args) {

  }

}
