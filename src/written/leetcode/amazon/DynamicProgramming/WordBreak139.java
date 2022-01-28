package written.leetcode.amazon.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

public class WordBreak139 {

  public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] dp = new boolean[s.length()+1];
    Set<String> set = new HashSet<>();

    for(String word : wordDict) {
      set.add(word);
    }
    dp[0] = true;

    for(int i = 1; i <= s.length(); i++) {
      for(int j = 0; j < i; j++) {
        if(dp[j] && set.contains(s.substring(j,i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[s.length()];
  }


  public static void main(String[] args) {
    WordBreak139 wordBreak139 = new WordBreak139();
    List<String> arr1 = new ArrayList<>();
    arr1.add("a"); arr1.add("code");


    List<String> arr2 = new ArrayList<>();
    arr2.add("cats"); arr2.add("dog"); arr2.add("sand"); arr2.add("and"); arr2.add("cat");


    List<String> arr3 = new ArrayList<>();
    arr3.add("apple"); arr3.add("pen");
    boolean leetcode = wordBreak139.wordBreak("a", arr1);

    System.out.println("dddd is" + leetcode);

    String a = "abc";
    String substring = a.substring(0, 1);

    System.out.println("ddd is " + substring);
  }

}
