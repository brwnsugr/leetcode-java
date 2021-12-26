package written.leetcode.amazon.ArrayAndStrings;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1OnePass {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> m = new HashMap<>();

    for(int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if(m.containsKey(complement) && m.get(complement) != i)
        return new int[]{i, m.get(complement)};
      m.put(nums[i], i);
    }
    return new int[]{};
  }



}
