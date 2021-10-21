package written.practice;

import java.util.Arrays;
import java.util.List;

public class Solution {

  private StringBuilder strBuilder;

  private static final List<String> ADJACENCY_LIST = Arrays.asList(
      "AB",
      "BA",
      "CD",
      "DC"
  );

  private void recursive(StringBuilder strBuilder, int length) {
    if(strBuilder.length() <= 1) {
      return;
    }
    for(int i = 0; i < strBuilder.length() -1; i++) {
      String sliceString = strBuilder.substring(i, i + 2);
      if (ADJACENCY_LIST.contains(sliceString)) {
        strBuilder.delete(i, i+2);
        recursive(strBuilder, length - 2);
      }
    }
    return;
  }



  public String solution(String S) {
    strBuilder = new StringBuilder(S);
    int len = strBuilder.length();
    recursive(strBuilder, len);

    return new String(strBuilder);


  }


  public static void main(String[] args) {
    Solution solution = new Solution();

    String answer = solution.solution("AAABBCD");//  -> A

    System.out.println(answer);
  }

}
