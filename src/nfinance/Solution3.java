package nfinance;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution3 {



  public int solution(int[] A) {
    // write your code in Java SE 8
    int filterCount = 0;
    double targetPollution = 0;
    double totalPollution = 0;

    PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    for(int a : A) {
      double unitPollution = a;
      maxHeap.add(unitPollution);
      totalPollution += unitPollution;
    }
    if(totalPollution == 0) return 0;
    targetPollution = totalPollution / 2;

    while(totalPollution > targetPollution) {
      Double maxPollutionFactory = maxHeap.poll();

      maxPollutionFactory = maxPollutionFactory / 2;
      totalPollution -= maxPollutionFactory;

      maxHeap.add(maxPollutionFactory);
      filterCount++;
    }
    return filterCount;
  }


  public static void main(String[] args) {
    Solution3 solution3 = new Solution3();

    int[] a = new int[]{5, 19, 8, 1};
    int[] a2 = new int[]{10,10};
    int[] a3 = new int[]{3,0,5};
    int[] a4 = new int[]{0,0,0};
    int solution = solution3.solution(a);

    System.out.println(solution);
  }

}
