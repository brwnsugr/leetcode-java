package written.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberOfConnected323 {

  public int countComponents(int n, int[][] edges) {

    Set<Integer> visited = new HashSet<>();

    List<List<Integer>> adjacencyList = IntStream.range(0, n).<List<Integer>>mapToObj(
        i -> new ArrayList<>()).collect(Collectors.toCollection(() -> new ArrayList<>(n)));

    for(var edge : edges) {
      adjacencyList.get(edge[0]).add(edge[1]);
      adjacencyList.get(edge[1]).add(edge[0]);
    }

    Map<Integer, Integer> parentsMap = new HashMap<>();
    Stack<Integer> s = new Stack<>();
    parentsMap.put(0,-1);
    int count = 0;

    for(int i = 0; i < n; i++ ) {
      if(!visited.contains(i)) {
        count++;
        s.add(i);
        while(!s.isEmpty()) {
          int currentNode = s.pop();
          if(visited.contains(currentNode)) continue;
          visited.add(currentNode);

          for(int neighbor : adjacencyList.get(currentNode)) {
            if(parentsMap.containsKey(currentNode) && parentsMap.get(currentNode) == neighbor) continue;
            parentsMap.put(neighbor, currentNode);
            s.add(neighbor);
          }
        }
      }
    }

    return count;
  }


  public static void main(String[] args) {
    int[][] edges = new int[][]{{0,1}, {1,2}, {0,2}, {3,4}};
    int n = 5;
    NumberOfConnected323 sol = new NumberOfConnected323();
    int i = sol.countComponents(n, edges);

    System.out.println(i);
  }

}
