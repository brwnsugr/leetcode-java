package written.leetcode.amazon.ArrayAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams49 {

  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> answers = new ArrayList<>();
    Map<String, List<String>> anagramMap = new HashMap<>();

    for(int i = 0; i < strs.length; i++) {
      String curr = strs[i];
      int[] chars = new int[26];
      for(int j = 0; j < curr.length(); j++) {
        chars[curr.charAt(j) - 'a']++;
      }
      StringBuilder strBuilder = new StringBuilder();
      for(int k = 0; k < 26; k++) {
        while(chars[k] > 0) {
          strBuilder.append(k + 'a');
          chars[k]--;
        }
      }
      String anagramWord = strBuilder.toString();
      if(!anagramMap.containsKey(anagramWord)) {
        anagramMap.put(anagramWord, new ArrayList<>());
      }
      anagramMap.get(anagramWord).add(curr);
    }

    for(List<String> value : anagramMap.values()) {
      answers.add(value);
    }
    return answers;
  }

  public static void main(String[] args) {
    String[] strs1 = new String[]{"eat","tea","tan","ate","nat","bat"};
    String[] strs2 = new String[]{""};
    String[] strs3 = new String[]{"a"};
    GroupAnagrams49 groupAnagrams49 = new GroupAnagrams49();
    groupAnagrams49.groupAnagrams(strs1);
  }

}
