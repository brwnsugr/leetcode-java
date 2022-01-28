package written.leetcode.amazon.DynamicProgramming;

public class MaximumSubArray53 {
  public int maxSubArray(int[] nums) {
    int ans = Integer.MIN_VALUE;
    int subSum = 0;
    for(int i = 0; i < nums.length; i++) {
      subSum += nums[i];
      ans = Math.max(ans, subSum);
      if(subSum < 0) subSum = 0;
    }
    return ans;
  }

  public static void main(String[] args) {
    MaximumSubArray53 maximumSubArray53 = new MaximumSubArray53();

    int i = maximumSubArray53.maxSubArray(new int[]{0});

    System.out.println(" answer is " + i);
  }
}
