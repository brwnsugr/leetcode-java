package written.hackerrank;

import java.util.List;

public class ArrayManipulation {

  public long solution(int n, List<List<Integer>> queries) {

    long[] prefixSumArr = new long[n+2];

    long answer = Long.MIN_VALUE;

    for(List<Integer> query : queries) {
      int startIdx = query.get(0);
      int endIdx = query.get(1);
      long summand = query.get(2);

      prefixSumArr[startIdx] += summand;
      prefixSumArr[endIdx+1] -= summand;
    }

    long temp = 0;
    for(int i = 1; i <= n+1; i++) {
      temp += prefixSumArr[i];
      if(temp > answer) {
        answer = temp;
      }
    }

    return answer;

  }

}
