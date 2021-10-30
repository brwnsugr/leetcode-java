package written.leetcode.coupang;

import java.util.HashSet;
import java.util.Set;

public class PerfectNumbers {

  private Set<Integer> set = new HashSet<>();

  private void recursive(int a, int b, int m, int n) {
    return;
  }

  public int solution(int n) {
    if(n == 1) return 0;
    if(n == 2) return 1;

    recursive(1,1,2,2);
    return 1;
  }



}
