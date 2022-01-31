package written.leetcode.amazon2.ArraysAndString;

import java.util.HashMap;
import java.util.Map;

public class ThreeSumClosest {

  private int diff;
  public int threeSumClosest(int[] nums, int target) {

    /**
     * My Idea is that when going through nums array, we pick one element and set the complement the element that we're at subtracted from the target
     * I mean the complement = target - nums[i] ;
     *
     * So, in the right remain elements of the nums array , we
     *
     *
     * go through nums[i],
     * p
     *
     * comp = target - nums[i]
     */
    int ans = 0;
    diff = Integer.MAX_VALUE;

    for(int i = 0; i < nums.length-2; i++) {
      int firstOne = nums[i];
      int complement = target - firstOne;

      //firstOne 의 오른쪽에 있는 두개의 인덱스의 끝값을 인자로 넣어서 하나씩 탐색합니다.
      /**
       * firstOne (the leftmost value), and in order to get the two sum of remains,
       * We calculate the closestTwoSum passing the arguments the start idx, and the end idx)
       * and start idx is right after the current idx, and end idx as length of nums array.)
       *
       */
      int remainTwoSum = getClosestSum(nums, i+1, nums.length, complement);
      if(remainTwoSum != 2001) ans = firstOne + remainTwoSum;
    }
    return ans;
  }

  private int getClosestSum(int[] nums, int start, int end, int semiTarget) {
    int ret = 2001;
    for(int i = start; i < end-1; i++) {
      for(int j = i+1; j < end; j++) {
        if (Math.abs(semiTarget - (nums[i] + nums[j])) < diff) {
          diff = Math.abs(semiTarget - (nums[i] + nums[j]));
          ret = nums[i] + nums[j];
        }
      }
    }
    return ret;
  }

  public static void main(String[] args) {
    ThreeSumClosest threeSumClosest = new ThreeSumClosest();

    int i = threeSumClosest.threeSumClosest(new int[]{-3,-2,-5,3,-4}, -1);

    System.out.println("ans is " + i);
  }
}
