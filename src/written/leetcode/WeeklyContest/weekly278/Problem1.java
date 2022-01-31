package written.leetcode.WeeklyContest.weekly278;

import java.util.HashSet;
import java.util.Set;

public class Problem1 {

  public int findFinalValue(int[] nums, int original) {
    int ret = original;
    Set<Integer> set = new HashSet<>();
    for(int num : nums) set.add(num);
    while(set.contains(ret)) ret *= 2;
    return ret;
  }

  public int findFinalValue2(int[] nums, int original) {


    return 1;
  }

  public static void main(String[] args) {
    Problem1 problem1 = new Problem1();

    int finalValue = problem1.findFinalValue(new int[]{4}, 4);

    System.out.println("dd is " + finalValue);
  }

}
