package written.leetcode.amazon2.ArraysAndString;

public class ProductOfArrayExceptItselfSpaceOptimized {
  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] answer = new int[n];
    answer[0] = 1;
    for(int i = 1; i < n; i++) answer[i] = nums[i-1] * answer[i-1];

    int R = 1;
    for(int i = n-1; i>=0; i--) {
      answer[i] *= R;
      R *= nums[i];
    }
    return answer;
  }

  public static void main(String[] args) {
    ProductOfArrayExceptItselfSpaceOptimized productOfArrayExceptItselfSpaceOptimized = new ProductOfArrayExceptItselfSpaceOptimized();
    int[] ints = productOfArrayExceptItselfSpaceOptimized.productExceptSelf(new int[]{-1,1,0,-3,3});

    System.out.println(" ddd is ");
  }
}
