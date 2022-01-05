package written.leetcode.amazon.TreesAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordLadderTwo126 {
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> answer = new ArrayList<>();
    if(wordList.size() == 1) {
      if(endWord.equals(wordList.get(0))) {
        answer.add(Arrays.asList(endWord));
        return answer;
      }
      return answer;
    }
    Map<String, List<String>> adjMap = new HashMap<>();
    int wordLen = wordList.get(0).length();

    for(int i = 0; i < wordList.size() - 1; i++) {
      for(int j = i + 1; j < wordList.size(); j++) {
        String firstWord = wordList.get(i);
        String secondWord = wordList.get(j);
        int[] chars = new int[26];
        for(int k = 0; k < wordLen; k++) {
          chars[firstWord.charAt(k) - 'a']++;
          chars[secondWord.charAt(k) - 'a']--;
        }
        int minusCount = 0; int plusCount = 0;
        for(int count : chars) {
          if(count == -1) minusCount++;
          if(count == 1) plusCount++;
        }
        if(minusCount == 1 && plusCount == 1) {
          if(!adjMap.containsKey(firstWord)) adjMap.put(firstWord, new ArrayList<>());
          if(!adjMap.containsKey(secondWord)) adjMap.put(secondWord, new ArrayList<>());
          adjMap.get(firstWord).add(secondWord);
          adjMap.get(secondWord).add(firstWord);
        }
      }
    }
    return null;
  }

  public static void main(String[] args) {
    WordLadderTwo126 wordLadderTwo126 = new WordLadderTwo126();
    List<String> wordList1 = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
    wordLadderTwo126.findLadders("hit", "cog", wordList1);
  }

}
