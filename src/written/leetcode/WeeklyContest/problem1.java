package written.leetcode.WeeklyContest;

public class problem1 {

  public String[] divideString(String s, int k, char fill) {
    int len = s.length();
    int remains = len % k;
    int q = len / k;

    if(remains == 0) {
      String[] res = new String[q];
      for(int i = 0; i < q; i++) {
        res[i] = s.substring(i * k, i * k + k);
      }
      return res;
    }
    else {
      String[] res = new String[q+1];
      for(int i = 0; i < q; i++) {
        res[i] = s.substring(i * k, i * k + k);
      }
      res[q] = s.substring(q * k);
      for(int j = 0; j < k - remains; j++) {
        res[q] += fill;
      }
      return res;
    }
  }

  public static void main(String[] args) {
    String s = "";
    problem1 problem1 = new problem1();
    problem1.divideString("abcd", 5, 'z');
  }

}
