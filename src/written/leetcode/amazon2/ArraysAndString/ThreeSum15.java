package written.leetcode.amazon2.ArraysAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum15 {

  List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> threeSum(int[] nums) {
    int target = 3;
    Arrays.sort(nums);
    for(int i = 0; i< nums.length-2; i++) {
      int semiTarget = target - nums[i];
      /**
       * we get Two Sum from the two indices which are bigger than ith idx
       */

      /**
       * To avoid duplicate answer set, skip the same element
       */
      if(i == 0 || nums[i-1] != nums[i]) {
        getTwoSum(nums, i+1, nums.length, semiTarget);
      }
    }
    return res;
  }

  private void getTwoSum(int[] nums, int start, int end, int target) {
    Set<Integer> s = new HashSet<>();
    for(int i = start; i < end; i++) {
      int complement = target - nums[i];
      if(s.contains(complement)) {
        res.add( Arrays.asList(-target, complement, nums[i]));
        /**
         * to Avoid duplicate answer set, skip the same element
         */
        while(i + 1 < end && nums[i] == nums[i+1]) {
          i++;
        }
      }
      s.add(nums[i]);
    }
  }




  public static void main(String[] args) {
    ThreeSum15 threeSum15 = new ThreeSum15();
    int[] arr1 = new int[]{0,0,0,0};

    int[] arr2 = new int[]{1,1,1,1,2};

    List<List<Integer>> lists = threeSum15.threeSum(arr2);

    System.out.println("ddd is");

  }

}
