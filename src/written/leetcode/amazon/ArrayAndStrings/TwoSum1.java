package written.leetcode.amazon.ArrayAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class TwoSum1 {

  public int[] twoSum(int[] nums, int target) {
    int[] originalNums = Arrays.copyOf(nums, nums.length);
    Arrays.sort(nums);
    int firstNum = 0;
    int secondNum = 0;

    for(int i = 0; i <nums.length; i++) {
      secondNum = target - nums[i];
      int remainIdx = Arrays.binarySearch(nums, secondNum);
      if(remainIdx >= 0) {
        firstNum = nums[i];
        break;
      }
    }
    Set<Integer> s = new HashSet<>();
    s.add(firstNum);
    s.add(secondNum);
    List<Integer> answer = new ArrayList<>();
    for(int j = 0; j < originalNums.length; j++) {
      if(s.contains(originalNums[j])) {
        answer.add(j);
      }
      if(answer.size() >= 2) break;
    }
    return new int[]{answer.get(0), answer.get(1)};
  }

  public static void main(String[] args) {
    int[] nums = new int[]{3,3};
    int[] nums2 = new int[]{3,2,3};
    int[] nums3 = new int[]{-1,-2,-3,-4,-5};
    TwoSum1 twoSum1 = new TwoSum1();
    int[] ints = twoSum1.twoSum(nums3, -8);
    System.out.println("ddd" + ints[0] + ints[1]);
  }

}
