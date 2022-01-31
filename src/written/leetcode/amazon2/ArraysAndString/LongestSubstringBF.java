package written.leetcode.amazon2.ArraysAndString;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringBF {

  public int lengthOfLongestSubstring(String s) {
    int ans = 0;
    for(int i = 0; i < s.length(); i++) {
      for(int j = i; j < s.length(); j++) {
        if(isNotRepeating(s, i, j)) {
          ans = Math.max(ans,j-i+1);
        }
      }
    }
    return ans;
  }

  private boolean isNotRepeating(String s, int start, int end) {
    Set<Character> m = new HashSet<>();
    for(int i = start; i <= end; i++) {
      if (m.contains(s.charAt(i))) return false;
      m.add(s.charAt(i));
    }
    return true;
  }

  public static void main(String[] args) {
    LongestSubstringBF longestSubstringBF = new LongestSubstringBF();
    int abcabcbb = longestSubstringBF.lengthOfLongestSubstring("dvdf");

    System.out.println(" answer is " + abcabcbb);
  }
}
