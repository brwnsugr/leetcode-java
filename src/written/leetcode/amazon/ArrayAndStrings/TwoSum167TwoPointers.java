package written.leetcode.amazon.ArrayAndStrings;

import java.util.HashMap;
import java.util.Map;

public class TwoSum167TwoPointers {

  public int[] twoSum(int[] numbers, int target) {
    int l = 0;
    int r = numbers.length - 1;
    while(l < r) {
      if(numbers[l] + numbers[r] < target) {
        l++;
      }
      else if(numbers[l] + numbers[r] > target) {
        r--;
      }
      else {
        return new int[]{l+1, r+1};
      }
    }
    return new int[]{};
  }

  public static void main(String[] args) {
    TwoSum167TwoPointers twoSumII167 = new TwoSum167TwoPointers();
    int[] nums = new int[]{2,7,11,15};
    int[] nums2 = new int[]{2,3,4};
    int[] nums3 = new int[]{-1,0};
  }

}
