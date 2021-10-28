package written.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NewYearChaos {

  private static int totalBribesCount;
  private static boolean chaosFlag = false;

  private static void bribeSwap(int leftIdx, int rightIdx, List<Integer> q) {
    if(chaosFlag || leftIdx < 0 || rightIdx >= q.size()) {
      return;
    }
    else if(q.get(leftIdx) < q.get(rightIdx)) {
      return;
    }
    else if(q.get(leftIdx) > q.get(rightIdx)) {
      totalBribesCount++;
      Collections.swap(q, leftIdx, rightIdx);
      bribeSwap(leftIdx-1, leftIdx, q);
      bribeSwap(rightIdx, rightIdx+1, q); // depth : O(N)
    }
    return;
  }

  public static void minimumBribes(List<Integer> q) {
    // Write your code here
    totalBribesCount = 0;
    for(int i = 0; i < q.size(); i++) {
      if(q.get(i) - (i+1) > 2) {
        System.out.println("Too chaotic");
        return;
      }
    }

    if(q.size() > 1) {
      for(int i = 0; i < q.size()-1; i++) {
        bribeSwap(i, i+1, q); //O(N * )
      }
    }

    System.out.println(totalBribesCount);
    return;
  }

  public static void main(String[] args) {

  }

}
