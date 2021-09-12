package chcorp;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {

  List<String> ret = new ArrayList<>();


  private void recursive(int n, int m, int count, StringBuilder strBuilder) {
    if(n == 0 && m == 0) {
      ret.add(strBuilder.toString());
      return;
    }
    if(n > 0){
      strBuilder.append('(');
      recursive(n-1, m, count+1, strBuilder);
      strBuilder.deleteCharAt(strBuilder.length()-1);
    }
    if(m > 0){
      strBuilder.append(')');
      recursive(n, m-1, count+1, strBuilder);
      strBuilder.deleteCharAt(strBuilder.length()-1);
    }
    return;
  }

  public String solution(int n, int m, int k) {
    StringBuilder stringBuilder = new StringBuilder();
    recursive(n, m, k, stringBuilder);
    return ret.get(k-1);
  }


  public static void main(String[] args) {
    Solution3 solution3 = new Solution3();
    int n1 = 3;
    int m1 = 4;
    int k1 = 20;
    String ans = solution3.solution(n1, m1, k1);
    System.out.println(ans);
  }

}
