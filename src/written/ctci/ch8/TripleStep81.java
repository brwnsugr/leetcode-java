package written.ctci.ch8;

public class TripleStep81 {

  public int solution(int n) {
    int[] d = new int[n+1];
    d[1] = 1;
    d[2] = 2;
    d[3] = 4;
    if(n <= 3) {
      return d[n];
    }

    for(int i = 4; i <= n; i++) {
      d[i] = d[i-1] + d[i-2] + d[i-3];
    }

    return d[n];
  }



}
