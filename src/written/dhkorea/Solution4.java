package written.dhkorea;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution4 {
  private int count;
  private Map<Integer, List<Integer>> adjMap;
  private boolean[] visited;
  private boolean[] recur;
  private int len;

  private boolean recursive(int currV, boolean[] visited, boolean[] recur) {

    if(recur[currV]){
      return true;
    }

    // 방문 완료된 경우에는 되돌아감
    if(visited[currV]){
      return false;
    }

    if(!adjMap.containsKey(currV)) {
      return false;
    }

    visited[currV] = true;
    recur[currV] = true;
    len++;

    for(int linkedDot : adjMap.get(currV)) {
      if (recursive(linkedDot, visited, recur)) {
        return true;
      }
      else if(recur[linkedDot]){
        return true;
      }
    }

    recur[currV] = false;
    return false;
  }

  public boolean solution(int[] A, int[] B) {
    // write your code in Java SE 8
    count = 0;
    adjMap = new HashMap<>();

    for(int i = 0; i < A.length; i++) {
      if(adjMap.containsKey(A[i])) {
        adjMap.get(A[i]).add(B[i]);
      }
      else {
        List<Integer> adjList = new ArrayList<>();
        adjList.add(B[i]);
        adjMap.put(A[i], adjList);
      }
    }


    for(int i = 1; i <= A.length; i++) {
      visited = new boolean[A.length + 1];
      recur = new boolean[A.length+1];
      len = 0;
      if(recursive(i, visited, recur)) {
        if(len == A.length) return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Solution4 solution4 = new Solution4();

    int[] A = new int[]{3,1,2};
    int[] B = new int[]{2,3,1};

    int[] A2 = new int[]{1, 2, 3, 4};
    int[] B2 = new int[]{2, 1, 4, 4};

    boolean solution = solution4.solution(A, B);

    System.out.println("truth is " + solution);
  }

}
