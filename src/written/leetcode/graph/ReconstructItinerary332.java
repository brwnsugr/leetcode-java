package written.leetcode.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary332 {

  List<String> answerPath;

  public List<String> findItinerary(List<List<String>> tickets) {
    Map<String, PriorityQueue<String>> m = new HashMap<>();
    answerPath = new ArrayList<>();

    for(List<String> ticket : tickets) {
      if(m.containsKey(ticket.get(0))) {
        m.put(ticket.get(0), new PriorityQueue<>());
      }
      m.get(ticket.get(0)).add(ticket.get(1));
    }
    dfs(m, "JFK");

    Collections.reverse(answerPath);
    return answerPath;
  }

  private void dfs(Map<String, PriorityQueue<String>> m, String curr) {
    while(m.containsKey(curr) && !m.get(curr).isEmpty()) {
      String next = m.get(curr).poll();
      dfs(m, next);
    }
    answerPath.add(curr);
  }

}
