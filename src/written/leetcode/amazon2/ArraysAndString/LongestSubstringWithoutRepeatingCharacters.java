package written.leetcode.amazon2.ArraysAndString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {


  public int lengthOfLongestSubstring(String s) {
    /**
     * The first thing I have to Consider is setting an anchor and its value the first idx
     * coming up with the hash map, which store the each ch as key its last idx as value
     * we go through the s string as ch array and put the char and its idx to our hash map
     * and within the anchor and current idx, between anchor and current idx, when we find the character already in this map,
     *
     * updated the length at that time ( current idx subtracted from anchor)
     * and moved to the anchor right after the last index of the current charater
     * and updated the current character and updated new last index on it.
     *
     * So, set the anchor
     * within the anchor idx and current idx that we're at, find if there's already character in this indices
     * and moving on the anchor right after the curent ch's last indedx + 1,
     * and mark the max answer value if the currIdx - anchor is bigger than the previous max Length
     * which is longest not duplucated string
     */
    if(s.length() <= 1) return s.length();

    int anchor = -1;
    int ans = 0;

    Map<Character, Integer> m = new HashMap<>();

    for(int i = 0; i < s.length(); i++) {
      if(m.containsKey(s.charAt(i))
          && m.get(s.charAt(i)) > anchor) {
        anchor = m.get(s.charAt(i));
      }
      m.put(s.charAt(i), i);
      ans = Math.max(ans, i - anchor);
    }
    return ans;
  }

  public static void main(String[] args) {
    LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
    int ii = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcd");

    System.out.println(" ans is" + ii);
  }
}
