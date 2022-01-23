package written.leetcode.amazon.TreesAndGraphs;

public class DiameterOfBinaryTree543 {

  int leftSubTreeDepthMax = 0;
  int rightSubTreeDepthMax = 0;
  int answer;

  public int diameterOfBinaryTree(TreeNode root) {
    answer = 0;
//    answer = getDepth(root);
    if(root == null) return 0;


    return answer;

  }


  public static void main(String[] args) {

    DiameterOfBinaryTree543 diameterOfBinaryTree543 = new DiameterOfBinaryTree543();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);

    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(2);
    root2.right = new TreeNode(3);
    root2.left.left = new TreeNode(4);
    root2.left.right = new TreeNode(5);
    int i = diameterOfBinaryTree543.diameterOfBinaryTree(root);


    System.out.println("ddd is " + i);
  }
}
