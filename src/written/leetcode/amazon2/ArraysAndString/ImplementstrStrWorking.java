package written.leetcode.amazon2.ArraysAndString;

import java.util.HashMap;
import java.util.Map;

public class ImplementstrStrWorking {

  public int strStr(String haystack, String needle) {

    /**
     * we use map to store the needle and check if any substring of haystack equals to that needle
     * n: "ll", m: character as key, value is the number of occurrence of that character,  m: {'l': 2}
     */

    int l = 0;
    int r = needle.length() - 1;
    Map<Character, Integer> m = new HashMap<>();

    for(char c : needle.toCharArray()) {
      m.put(c, m.getOrDefault(c, 0) + 1);
    }

    int hayStackLen = haystack.length();
    for(int i = 0; i <= r; i++) {
      if(m.containsKey(haystack.charAt(i))) {
        m.put(haystack.charAt(i), m.get(haystack.charAt(i))-1);
      }
    }

    while(r < hayStackLen) {


      l++;
      r++;
    }

    return 1;
  }

}
