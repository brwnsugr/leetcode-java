package written.leetcode.coupang;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring3 {

  public int lengthOfLongestSubstring(String s) {
    int left = 0;
    int ans = 0;
    int[] chars = new int[128];
    for(int right = 0; right < s.length(); right++) {
      chars[s.charAt(right)]++;
      while(chars[s.charAt(right)] > 1) {
        chars[s.charAt(left)]--;
        left++;
      }
      ans = Math.max(ans, right - left + 1);
    }
    return ans;
  }


  public static void main(String[] args) {
    LongestSubstring3 longestSubstring3 = new LongestSubstring3();
    String s1 = "abcabcbb";
    String s2 = "bbbbb";

    String s3 = "pwwkew";
    String s4 = " ";
    String s5 = "aab";
    String s6 = "dmmabcd";
    int i = longestSubstring3.lengthOfLongestSubstring(s1);

    System.out.println("ddd " + i);
  }
}
