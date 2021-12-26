package written.leetcode.amazon.ArrayAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ThreeSum15 {

  Set<List<Integer>> combSet = new HashSet<>();

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> answers = new ArrayList<>();

    for(int i = 0; i < nums.length; i++) {
      int target = 0 - nums[i];
      Set<int[]> twoCombs = getTwoSums(target, i, nums);
      if(twoCombs.size() != 0) {
        for(int[] twoComb : twoCombs) {
          combSet.add(Arrays.asList(twoComb[0],twoComb[1],twoComb[2]));
        }
      }
    }
    for(List<Integer> comb : combSet) {
      answers.add(comb);
    }
    return answers;
  }

  private Set<int[]> getTwoSums(int target, int currIdx, int [] nums) {
    Map<Integer, Integer> m = new HashMap<>();
    Set<int[]> twoSums = new HashSet<>();
    for(int i = 0; i < nums.length; i++) {
      if(i==currIdx) continue;
      int complement = target - nums[i];
      if(m.containsKey(complement) && m.get(complement) != i) {
        int[] arr = new int[]{nums[currIdx], complement, nums[i]};
        Arrays.sort(arr);
        if(!combSet.contains(Arrays.stream(arr).boxed().collect(Collectors.toList()))) {
          twoSums.add(arr);
        }
      }
      m.put(nums[i], i);
    }
    return twoSums;
  }


  public static void main(String[] args) {
    ThreeSum15 threeSum15 = new ThreeSum15();
    threeSum15.threeSum(new int[]{-1,0,1,2,-1,-4});
  }
}
