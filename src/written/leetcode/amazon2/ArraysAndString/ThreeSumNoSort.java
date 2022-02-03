package written.leetcode.amazon2.ArraysAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSumNoSort {

  public List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> resSet = new HashSet<>();
    Set<Integer> firstDups = new HashSet<>();
    Map<Integer, Integer> seen = new HashMap<>();

    for(int i = 0; i < nums.length - 2; i++) {
      if(firstDups.add(nums[i])) {
        for(int j = i+1; j < nums.length; j++) {
          int complement = -nums[i] -nums[j];
          if(seen.containsKey(complement) && seen.get(complement) == i) {
            List<Integer> res = Arrays.asList(complement, nums[i], nums[j]);
            Collections.sort(res);
            resSet.add(res);
          }
          seen.put(nums[j], i);
        }
      }
    }
    return new ArrayList<>(resSet);
  }

  public static void main(String[] args) {
    ThreeSumNoSort threeSumNoSort = new ThreeSumNoSort();
    List<List<Integer>> lists = threeSumNoSort.threeSum(new int[]{0, 0, 0, 0});

    System.out.println(" ddd is ");
  }

}
