package written.leetcode.amazon2.ArraysAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumTwoPointers {

  private List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    for(int i = 0; i < nums.length -2; i++) {
      if(nums[i] > 0) break;
      if(i == 0 || nums[i-1] != nums[i]) addThreeSum(nums, i);
    }
    return res;
  }


  private void addThreeSum(int[] nums, int i) {
    /**
     * Set the low pointer to (i+1), and Set the high pointer to length of nums minus 1
     */
    int lo = i + 1;
    int hi = nums.length-1;
    while(lo < hi) {
      int sum = nums[lo] + nums[hi] + nums[i];
      /**
       * if Sum is less than zero, increment lo pointer
       */
      if(sum < 0) {
        lo++;
      }
      /**
       * if sum is bigger than zero, decrement hi pointer
       */
      else if(sum > 0) {
        hi--;
      }
      else {
        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
        /**
         * The Most important point
         * after put the result set as a List, we both increment lo, and hi to avoid duplicated combinations
         *
         * Plus, increment the lo until we meet the new lo value.
         */
        lo++; hi--;
        while(lo < hi && nums[lo] == nums[lo-1]) lo++;
      }
    }
  }


  public static void main(String[] args) {
    int[] arr1 = new int[]{-2,0,0,2,2};
    ThreeSumTwoPointers threeSumTwoPointers = new ThreeSumTwoPointers();
    List<List<Integer>> lists = threeSumTwoPointers.threeSum(arr1);

    System.out.println(" ddd is ");
  }
}
