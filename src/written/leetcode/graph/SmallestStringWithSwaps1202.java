package written.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmallestStringWithSwaps1202 {

  private int[] parents;

  public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
    int n = s.length();
    parents = new int[n];
    for(int i = 0; i < n; i++) parents[i] = i;

    Double a;

    a = 1D;

    for(List<Integer> pair : pairs) {
      union(pair.get(0), pair.get(1));
    }

    Map<Integer, List<Integer>> adjListMap = new HashMap<>();
    for(int i = 0; i < n; i++) adjListMap.put(i, new ArrayList<>());

    for(int i = 0; i < n; i++) {
      int root = find(i);
      adjListMap.get(root).add(i);
    }

    char[] answer = s.toCharArray();

    for(Map.Entry<Integer, List<Integer>> adjList : adjListMap.entrySet()) {
      int subsetSize = adjList.getValue().size();
      if(subsetSize <= 1) continue;
      char[] partialWord = new char[subsetSize];

      for(int i = 0; i < subsetSize; i++) {
        partialWord[i] = s.charAt(adjList.getValue().get(i));
      }
      Collections.sort(adjList.getValue());
      Arrays.sort(partialWord);

      for(int i = 0; i < subsetSize; i++) {
        answer[adjList.getValue().get(i)] = partialWord[i];
      }
    }
    return String.valueOf(answer);
  }


  private void union(int a, int b) {
    a = find(a);
    b = find(b);
    if(a != b) {
      parents[b] = a; // Merge B into A's root
    }
  }

  private int find(int a) {
    if(a == parents[a]) return a;
    else {
      return parents[a] = find(parents[a]);
    }
  }

  public static void main(String[] args) {
    SmallestStringWithSwaps1202 smallestStringWithSwaps1202 = new SmallestStringWithSwaps1202();
    List<List<Integer>> pairs1 = new ArrayList<>();
    pairs1.add(new ArrayList<>());
    pairs1.add(new ArrayList<>());
    pairs1.get(0).add(0); pairs1.get(0).add(3);
    pairs1.get(1).add(1); pairs1.get(1).add(2);

    List<List<Integer>> pairs2 = new ArrayList<>();
    pairs2.add(new ArrayList<>());
    pairs2.add(new ArrayList<>());
    pairs2.add(new ArrayList<>());
    pairs2.get(0).add(0); pairs2.get(0).add(3);
    pairs2.get(1).add(1); pairs2.get(1).add(2);
    pairs2.get(2).add(0); pairs2.get(2).add(2);
    String dcab = smallestStringWithSwaps1202.smallestStringWithSwaps("dcab", pairs2);

    System.out.println(dcab);

  }


}
