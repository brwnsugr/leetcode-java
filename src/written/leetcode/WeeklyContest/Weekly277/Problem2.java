package written.leetcode.WeeklyContest.Weekly277;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
  public int[] rearrangeArray(int[] nums) {

    List<Integer> positiveArr = new ArrayList<>();
    List<Integer> negativeArr = new ArrayList<>();

    for(int num : nums) {
      if(num > 0) positiveArr.add(num);
      else negativeArr.add(num);
    }

    int len = nums.length / 2;
    int[] ans = new int[nums.length];
    for(int i = 0; i < len; i++) {
       ans[i*2] = positiveArr.get(i);
       ans[i*2 + 1] = negativeArr.get(i);
    }
    return ans;
  }

  public static void main(String[] args) {
    Problem2 problem2 = new Problem2();
    int[] ints = problem2.rearrangeArray(new int[]{3,1,-2,-5,2,-4});

    System.out.println("dddd");
  }
}
