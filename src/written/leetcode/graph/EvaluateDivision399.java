package written.leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision399 {

  private Set<String> equationSet;
  private Map<String, String> parentMap;

  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    Map<String, Map<String, Double>> graph = new HashMap<>();
    int size = equations.size();

    for(int i = 0; i < size; i++) {
      String dividend = equations.get(i).get(0);
      String divisor = equations.get(i).get(1);
      double quotient = values[i];

      if(!graph.containsKey(dividend)) {
        graph.put(dividend, new HashMap<>());
      }
      if(!graph.containsKey(divisor)) {
        graph.put(divisor, new HashMap<>());
      }

      graph.get(dividend).put(divisor, quotient);
      graph.get(divisor).put(dividend, 1/quotient);
    }

    double results[] = new double[queries.size()];
    for(int i = 0; i < queries.size(); i++) {
      List<String> query = queries.get(i);
      String dividend = query.get(0);
      String divisor = query.get(1);

      if(!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
        results[i] = -1.0;
      }
      else if(dividend == divisor) {
        results[i] = 1.0;
      }
      else {
        HashSet<String> visited = new HashSet<>();
        results[i] = backTrack(graph, dividend, divisor, 1, visited);
      }
    }

    return results;
  }

  private double backTrack(
      Map<String, Map<String, Double>> graph,
      String curr, String target,
      double accProduct, Set<String> visited) {
    visited.add(curr);
    double ret = -1.0;

    Map<String, Double> neighbors = graph.get(curr);

    if(neighbors.containsKey(target)) {
      ret = accProduct * neighbors.get(target);
    }
    else {
      for(Map.Entry<String, Double> pair : neighbors.entrySet()) {
        String nextNode = pair.getKey();
        if(visited.contains(nextNode)) continue;
        ret = backTrack(graph, nextNode, target, accProduct * pair.getValue(), visited);
        if(ret != -1.0) {
          break;
        }
      }
    }
    visited.remove(curr);
    return ret;
  }




  public static void main(String[] args) {
    EvaluateDivision399 evaluateDivision399 = new EvaluateDivision399();

  }

}
