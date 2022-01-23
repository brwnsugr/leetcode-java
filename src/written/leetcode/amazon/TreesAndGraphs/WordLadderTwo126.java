package written.leetcode.amazon.TreesAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderTwo126 {

  List<List<String>> answer = new ArrayList<>();
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

    if(wordList.size() == 1) {
      if(endWord.equals(wordList.get(0))) {
        answer.add(Arrays.asList(endWord));
        return answer;
      }
      return answer;
    }
    if(!wordList.contains(beginWord)) wordList.add(beginWord);
    Map<String, List<String>> adjMap = new HashMap<>();
    int wordLen = wordList.get(0).length();

    for(int i = 0; i < wordList.size(); i++) {
      for(int j = 0; j < wordLen; j++) {
        String proto = makeProto(wordList.get(i), j);
        if(!adjMap.containsKey(proto)) adjMap.put(proto, new ArrayList<>());
        adjMap.get(proto).add(wordList.get(i));
      }
    }

    bfs(adjMap, beginWord, endWord);
    return answer;
  }

  private void bfs(Map<String, List<String>> adjMap, String beginWord, String target) {
    Set<String> visited = new HashSet<>();
    Queue<List<String>> q = new LinkedList<>();

    List<String> path = new ArrayList<>();

    path.add(beginWord);
    boolean found = false;
    q.add(path);

    while(!q.isEmpty() && !found) {
      int count = q.size();
      for(int i = 0; i < count; i++) {
        List<String> currPath = q.poll();
        if(currPath.get(currPath.size() -1).equals(target)) {
          found = true;
          answer.add(new ArrayList<>(currPath));
        }
        String currWord = currPath.get(currPath.size()-1);
        visited.add(currWord);
        for(int j = 0; j < currWord.length(); j++) {
          String proto = makeProto(currWord, j);
          List<String> nextWords = adjMap.get(proto);
          for(String nextWord : nextWords) {
            if(!visited.contains(nextWord)) {
              currPath.add(nextWord);
              q.add(new ArrayList<>(currPath));
              currPath.remove(currPath.size()-1);
            }
          }
        }
      }
    }
  }

//  private void dfs(Set<String> seen, Map<String, List<String>> adjMap, String curr, String target, List<String> path) {
//    if(curr.equals(target)) {
//      List<String> pathToAdd = List.copyOf(path);
//      if(answer.size() > 0) {
//        if (pathToAdd.size() < minLen) {
//          answer.clear();
//          answer.add(pathToAdd);
//          minLen = pathToAdd.size();
//        }
//        else if(pathToAdd.size() == minLen) {
//          answer.add(pathToAdd);
//        }
//      }
//      else {
//        answer.add(pathToAdd);
//        minLen = pathToAdd.size();
//      }
//      return;
//    }
//    else if (path.size() < minLen){
//      for(int i = 0; i < target.length(); i++) {
//        String proto = makeProto(curr, i);
//        List<String> nextWords = adjMap.get(proto);
//        for(String nextWord : nextWords) {
//          if(!seen.contains(nextWord)) {
//            seen.add(nextWord);
//            path.add(nextWord);
//            dfs(seen, adjMap, nextWord, target, path);
//            seen.remove(nextWord);
//            path.remove(path.size()-1);
//          }
//        }
//      }
//    }
//    return;
//  }

  public String makeProto(String word, int idx){
    return word.substring(0,idx) + "*" + word.substring(idx+1);
  }

  public static void main(String[] args) {
    WordLadderTwo126 wordLadderTwo126 = new WordLadderTwo126();
    List<String> wordList1 = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
    List<String> wordList2 = new ArrayList<>();
    List<String> wordList3 = new ArrayList<>();
    wordList3.add("hot"); wordList3.add("dog");
    wordList2.add("hot"); wordList2.add("dot"); wordList2.add("dog"); wordList2.add("lot"); wordList2.add("log"); wordList2.add("cog");

    List<String> wordList4 = new ArrayList<>();
    wordList4.add("lest");
    wordList4.add("leet");
    wordList4.add("lose");
    wordList4.add("code");
    wordList4.add("lode");
    wordList4.add("robe");
    wordList4.add("lost");
    List<List<String>> ladders = wordLadderTwo126.findLadders("leet", "code", wordList4);

    System.out.println("dddd");
  }

}
