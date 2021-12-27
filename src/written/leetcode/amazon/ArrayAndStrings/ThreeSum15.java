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

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> answers = new ArrayList<>();
    Arrays.sort(nums);
    for(int i = 0; i < nums.length - 2; i++){
      if(nums[i] > 0) break;
      if(i == 0 || nums[i] != nums[i-1]) {
        appendTwoSums(i, nums, answers);
      }
    }
    return answers;
  }

  private void appendTwoSums(int startIdx, int [] nums, List<List<Integer>> res) {
    Set<Integer> elementSeen = new HashSet<>();
    for(int j = startIdx + 1; j < nums.length; j++) {
      int complement = -nums[startIdx] -nums[j];
      if(elementSeen.contains(complement)) {
        res.add(Arrays.asList(nums[startIdx], nums[j], complement));
        while(j < nums.length - 1 && nums[j+1] == nums[j]) j++;
      }
      elementSeen.add(nums[j]);
    }
  }


  public static void main(String[] args) {
    ThreeSum15 threeSum15 = new ThreeSum15();
    int[] arr1 = new int[]{-1, 0, 1, 2, -1, -4};
    int[] arr2 = new int[]{-4,-1,-1,3,5};
    List<List<Integer>> lists = threeSum15.threeSum(arr2);

    System.out.println("dd");
  }
}
