package written.leetcode.coupang;

public class MaxConsecutiveOnes1004 {

  public int longestOnes(int[] nums, int k) {
    int left = 0;
    int right;
    int longest = Integer.MIN_VALUE;

    for(right = 0; right < nums.length; right++) {
      if(nums[right] == 0) {
        k--;
      }
      if(k < 0) {
        k += 1 - nums[left];
        left++;
      }
      if(right - left + 1 > longest) longest = right-left+1;
    }
    return longest;
  }


  public static void main(String[] args) {
    MaxConsecutiveOnes1004 maxConsecutiveOnes1004 = new MaxConsecutiveOnes1004();

    int i = maxConsecutiveOnes1004.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2);

    System.out.println("ddd is" + i);


  }

}
