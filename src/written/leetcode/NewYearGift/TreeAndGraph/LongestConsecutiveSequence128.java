package written.leetcode.NewYearGift.TreeAndGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence128 {
  public int longestConsecutive(int[] nums) {
    Map<Integer, List<Integer>> adjMap = new HashMap<>();

    Set<Integer> s = new HashSet<>();

    for(int num : nums) {
      s.add(num);
      adjMap.put(num, new ArrayList<>());
    }

    for(int num : nums) {
      /**
       * check if its consecutive num exist
       */
      if(s.contains(num-1)) adjMap.get(num).add(num-1);
      if(s.contains(num+1)) adjMap.get(num).add(num+1);
    }

    int answer = 0;
    Set<Integer> visited = new HashSet<>();
    for(int num : nums) {
      if(!visited.contains(num))
        answer = Math.max(answer, recursive(visited, adjMap, num));
    }

    return answer;
  }

  private int recursive(Set<Integer> visited, Map<Integer, List<Integer>> adjMap, int start) {
    int res = 1;
    visited.add(start);
    List<Integer> adjList = adjMap.get(start);
    for(int next : adjList) {
      if(!visited.contains(next)) res += recursive(visited, adjMap, next);
    }
    return res;
  }

  public static void main(String[] args) {
    int i = new LongestConsecutiveSequence128().longestConsecutive(new int[]{1,2});

    System.out.println("ans is " + i);
  }

}
