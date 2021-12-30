package written.leetcode.amazon.ArrayAndStrings;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring76 {
  public String minWindow(String s, String t) {
    int tLen = t.length();
    Map<Character, Integer> tMap = new HashMap<>();
    Map<Character, Integer> windowsMap = new HashMap<>();
    for(int i = 0; i < tLen; i++) {
      char c = t.charAt(i);
      tMap.put(c, tMap.getOrDefault(c, 0) + 1);
    }
    int requiredFormSize = tMap.size();
    int formSize = 0;
    int l = 0;
    int r = 0;
    int[] minimumWindowArr = new int[]{-1,0,0};

    while(r < s.length()) {
      char curr = s.charAt(r);
      windowsMap.put(curr, windowsMap.getOrDefault(curr, 0) + 1);
      if(tMap.containsKey((curr)) && tMap.get(curr).intValue() == windowsMap.get(curr).intValue()) {
        formSize++;
      }
      while(formSize == requiredFormSize && l <= r) {
        char c = s.charAt(l);
        if(minimumWindowArr[0] == -1 || r-l+1 < minimumWindowArr[0]) {
          minimumWindowArr[0] = r-l+1;
          minimumWindowArr[1] = l;
          minimumWindowArr[2] = r;
        }
        windowsMap.put(c, windowsMap.get(c) - 1);
        if(tMap.containsKey(c) && windowsMap.get(c).intValue() < tMap.get(c).intValue()) {
          formSize--;
        }
        l++;
      }
      r++;
    }
    return minimumWindowArr[0] == -1 ? "" : s.substring(minimumWindowArr[1],minimumWindowArr[2]+1);
  }

  public static void main(String[] args) {
    MinimumWindowSubstring76 minimumWindowSubstring76 = new MinimumWindowSubstring76();
    String s = "ADOBECODEBANC";
    String t = "ABC";

    String s1 = minimumWindowSubstring76.minWindow(s, t);

    System.out.println("ddd is " + s1);
  }

}
