package written.leetcode.WeeklyContest.Biweekly70;

import java.util.Arrays;

public class Problem1 {
  public int minimumCost(int[] cost) {
    int count = 0;
    int totalCost = 0;
    Arrays.sort(cost);
    for(int i = cost.length -1; i >= 0; i--) {
      count++;
      if(count == 3) count = 0;
      else totalCost += cost[i];
    }
    return totalCost;
  }

  public static void main(String[] args) {
    Problem1 problem1 = new Problem1();
    int i = problem1.minimumCost(new int[]{1,2});
    System.out.println("ddd" + i);
  }

}
