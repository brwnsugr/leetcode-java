package written.leetcode.amazon.ArrayAndStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MostCommonWord819 {
  public String mostCommonWord(String paragraph, String[] banned) {
    Set<String> bannedSet = new HashSet<>();
    Map<String, Integer> wordMap = new HashMap<>();
    String answer = "";
    for(String bannedWord : banned) bannedSet.add(bannedWord);

    String charRemovedParagraph = paragraph.replaceAll("[!?',;.]", " ");
    String[] words = charRemovedParagraph.trim().split("\\s+");

    for(String word : words) {
      if(bannedSet.contains(word.toLowerCase())) continue;
      else wordMap.put(word.toLowerCase(), wordMap.getOrDefault(word.toLowerCase(), 0)+1);
    }

    wordMap.entrySet();
    int maxWordCount = 0;

    for(Map.Entry<String, Integer> entry : wordMap.entrySet()) {
      if(entry.getValue().intValue() > maxWordCount) {
        answer = entry.getKey();
        maxWordCount = entry.getValue().intValue();
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    MostCommonWord819 mostCommonWord819 = new MostCommonWord819();
    String para1 = "Bob hit a ball, the hit BALL flew far after it was hit.";
    String para2 = "Bob. hIt, baLl";
    String para3 = "a, a, a, a, b,b,b,c, c";
    mostCommonWord819.mostCommonWord(para3, new String[]{"a"});
  }

}
