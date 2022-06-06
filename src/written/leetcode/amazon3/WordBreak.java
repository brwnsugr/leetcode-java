package written.leetcode.amazon3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

  public boolean wordBreak(String s, List<String> wordDict) {
    return traverse(s, 0, wordDict);
  }

  private boolean traverse(String s, int startIdx, List<String> wordDict) {
    if(startIdx == s.length()) {
      return true;
    }
    for(int i = startIdx+1; i < s.length(); i++) {
      String subString = s.substring(startIdx, i);
      if(wordDict.contains(subString) && traverse(s, i, wordDict)) {
        return true;
      }
    }
    return false;
  }


  public static void main(String[] args) {
    WordBreak wordBreak = new WordBreak();
//    wordBreak.
  }

}
