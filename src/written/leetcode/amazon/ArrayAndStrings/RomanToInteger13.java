package written.leetcode.amazon.ArrayAndStrings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger13 {




  public int romanToInt(String s) {
    int answer = 0;
    Map<String, Integer> romanMap;
    romanMap = new HashMap<>();
    romanMap.put("I", 1);
    romanMap.put("V", 5);
    romanMap.put("X", 10);
    romanMap.put("L", 50);
    romanMap.put("C", 100);
    romanMap.put("D", 500);
    romanMap.put("M", 1000);
    romanMap.put("IV", 4);
    romanMap.put("IX", 9);
    romanMap.put("XL", 40);
    romanMap.put("XC", 90);
    romanMap.put("CD", 400);
    romanMap.put("CM", 900);

    for(int i = 0; i < s.length(); i++) {
      if(i+1 < s.length() && romanMap.containsKey(s.substring(i, i+2))) {
        answer += romanMap.get(s.substring(i, i+2));
        i++;
      }else {
        answer += romanMap.get(s.substring(i,i+1));
      }
    }
    return answer;
  }

}
