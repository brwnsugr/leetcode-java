package written.leetcode.amazon.ArrayAndStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class FirstUniqueCharacterInAString387 {
  public int firstUniqChar(String s) {
    for(int i = 0; i < s.length(); i++) {
      if(s.lastIndexOf(s.charAt(i)) == s.indexOf(s.charAt(i))) {
        return i;
      }
    }
    return -1;
  }


  public static void main(String[] args) {
    FirstUniqueCharacterInAString387 firstUniqueCharacterInAString387 = new FirstUniqueCharacterInAString387();

    firstUniqueCharacterInAString387.firstUniqChar("aabbc");
  }

}
