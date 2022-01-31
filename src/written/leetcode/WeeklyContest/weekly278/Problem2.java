package written.leetcode.WeeklyContest.weekly278;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem2 {

  public List<Integer> maxScoreIndices(int[] nums) {
    Map<Integer, List<Integer>> m = new HashMap<>();

    int[] cumulatedSum = new int[nums.length];
    int maxScore = 0;
    int sum = 0;
    for(int i = 0; i < nums.length; i++) {
      sum += nums[i];
      cumulatedSum[i]=sum;
    }

    for(int i = 0; i <= nums.length; i++) {
      int left;
      int right;
      if(i==0) {
        left = 0;
        right = cumulatedSum[nums.length-1];
      }
      else if(i == nums.length) {
        left = nums.length - cumulatedSum[nums.length-1];
        right = 0;
      }
      else {
        left = i - cumulatedSum[i-1];
        right = cumulatedSum[nums.length-1] - cumulatedSum[i-1];
      }
      int score = left+right;
      if(!m.containsKey(score)) {
        m.put(score, new ArrayList<>());
      }
      m.get(score).add(i);
      maxScore = Math.max(maxScore, score);
    }

    return m.get(maxScore);
  }


  public static void main(String[] args) {

    Problem2 problem2 = new Problem2();
    List<Integer> integers = problem2.maxScoreIndices(new int[]{1});

    System.out.println("dddd is ");
  }
}
