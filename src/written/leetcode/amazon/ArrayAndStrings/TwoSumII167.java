package written.leetcode.amazon.ArrayAndStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSumII167 {
  public int[] twoSum(int[] numbers, int target) {
    Map<Integer, Integer> seen = new HashMap<>();
    for(int i = 0; i < numbers.length; i++) {
      int complement = target - numbers[i];
      if(seen.containsKey(complement) && seen.get(complement) != i)
        return new int[]{seen.get(complement)+1, i+1};
      seen.put(numbers[i], i);
    }
    return new int[]{};
  }

  public static void main(String[] args) {
    TwoSumII167 twoSumII167 = new TwoSumII167();
    int[] nums = new int[]{2,7,11,15};
    int[] nums2 = new int[]{2,3,4};
    int[] nums3 = new int[]{-1,0};
  }

}

