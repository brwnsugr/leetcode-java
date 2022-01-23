package written.leetcode.WeeklyContest.Weekly277;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Problem3 {
  public List<Integer> findLonely(int[] nums) {
    Map<Integer, Integer> m = new HashMap<>();
    for(int num : nums) {
      if(m.containsKey(num)) m.put(num, m.get(num) + 1);
      else m.put(num, 1);
    }
    Set<Entry<Integer, Integer>> entries = m.entrySet();
    List<Integer> ans = new ArrayList<>();
    for(Entry<Integer, Integer> entry : entries) {
      int leftAdj = entry.getKey() - 1;
      int rightAdj = entry.getKey() + 1;
      if(entry.getValue().intValue() == 1
        && !m.containsKey(leftAdj) && !m.containsKey(rightAdj)) ans.add(entry.getKey().intValue());
    }
    return ans;
  }

  public static void main(String[] args) {
    Problem3 problem3 = new Problem3();
    List<Integer> lonely = problem3.findLonely(new int[]{0});

    System.out.println("dddd");
  }
}
