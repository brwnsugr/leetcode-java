package written.leetcode.amazon2.ArraysAndString;

import java.util.Arrays;

public class ThreeSumClosest2 {

  public int threeSumClosest(int[] nums, int target) {

    /**
     * Setting Two pointers
     * first going through the nums array,
     * we pick the first element on this array .
     *
     * and from the first element, for the right side, we set two pointers
     * ,left pointer is starting at idx of first element + 1, and
     * right is starting at the end of the array
     *
     *
     * and left pointer moving the right, or right pointer moving to the left
     * to minimize the difference.
     *
     * in order to minimize the diff,
     *
     * semiTarget ,which equqls to target - firstElement Value.
     *
     * in the two pointer, the summation closest to semiTarget would be the answer
     *
     *
     */


    int minDiff = Integer.MAX_VALUE;
    int ans = 0;
    Arrays.sort(nums);
    for(int i = 0; i < nums.length -2; i++) {
      int firstOne = nums[i];
      int semiTarget = target - firstOne;

      int left = i+1;
      int right = nums.length - 1;
      while(left < right) {
        int diff = Math.abs(semiTarget - (nums[left] + nums[right]));
        if(diff < minDiff) {
          minDiff = diff;
          ans = firstOne + nums[left] + nums[right];
        }
        if(semiTarget > nums[left] + nums[right]) {
          left++;
        }
        else {
          right--;
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    ThreeSumClosest2 threeSumClosest2 = new ThreeSumClosest2();
    int i = threeSumClosest2.threeSumClosest(new int[]{1, 1, 1, 0}, -100);
    System.out.println(" ans is " + i);
  }
}
