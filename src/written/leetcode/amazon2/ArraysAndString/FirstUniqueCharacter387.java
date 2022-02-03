package written.leetcode.amazon2.ArraysAndString;

import java.util.HashSet;
import java.util.Set;

public class FirstUniqueCharacter387 {

  public int firstUniqChar(String s) {

    Set<Character> alreadyRemovedSet = new HashSet<>();
    Set<Character> charSet = new HashSet<>();

    for(int i = 0; i < s.length(); i++) {
      if(!alreadyRemovedSet.contains(s.charAt(i))
          && !charSet.contains(s.charAt(i))) {
        charSet.add(s.charAt(i));
      }
      else if(charSet.contains(s.charAt(i))) {
        alreadyRemovedSet.add(s.charAt(i));
        charSet.remove(s.charAt(i));
      }
    }

    for(int i = 0; i < s.length(); i++) {
      if(charSet.contains(s.charAt(i))) return i;
    }
    return -1;
  }

}
