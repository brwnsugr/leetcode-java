package written.sbird;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  private StringBuilder strBuilder;
  private Map<String, Void> adjacentMap = new HashMap<>(4);
  private static final List<String> ADJACENTS = Arrays.asList("AB", "BA", "CD", "DC");


  private void recursive(StringBuilder builder, int length) {
    // AB or BA // CD or DC
    if(builder.length() <= 0) return;
    for(int i = 0; i < builder.length() - 1; i++) {
      String slice = builder.substring(i,i+2);
      if (ADJACENTS.contains(slice)) {
        builder.delete(i,i+2);
        recursive(builder, length -2);
      }
    }
    return;
  }


  public String solution(String S) {
    // write your code in Java SE 8
    strBuilder = new StringBuilder(S);
    int len = strBuilder.length();

    adjacentMap.put("AB", null);
    adjacentMap.put("BA", null);
    adjacentMap.put("CD", null);
    adjacentMap.put("DC", null);
    recursive(strBuilder, len);

    return new String(strBuilder);
  }

}
