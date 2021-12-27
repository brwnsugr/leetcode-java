package written.leetcode.amazon.ArrayAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15TwoPointers {

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> answers = new ArrayList<>();
    for(int i = 0; i < nums.length - 2; i++) {
      if(nums[i] > 0) break;
      if(i == 0 || nums[i-1] != nums[i]) {
        buildTwoSum(nums, i, answers);
      }
    }
    return answers;
  }

  private void buildTwoSum(int[] nums, int startIdx, List<List<Integer>> res) {
    //implement two sum by two pointers
    int l = startIdx+1;
    int r = nums.length - 1;
    int twoSumTarget = -nums[startIdx];

    while(l < r) {
      int twoSum = nums[l] + nums[r];
      if(twoSumTarget == twoSum) {
        res.add(Arrays.asList(nums[startIdx], nums[l++], nums[r--]));
        while(l<r && nums[l] == nums[l-1]) l++;
      }
      else if(twoSumTarget < twoSum) {
        r--;
      }
      else {
        l++;
      }
    }
  }

  public static void main(String[] args) {
    int[] arr1 = new int[]{-1, 0, 1, 2, -1, -4};
    int[] arr2 = new int[]{-4,-1,-1,3,5};
    ThreeSum15TwoPointers threeSum15TwoPointers = new ThreeSum15TwoPointers();
    threeSum15TwoPointers.threeSum(arr2);
  }

}
