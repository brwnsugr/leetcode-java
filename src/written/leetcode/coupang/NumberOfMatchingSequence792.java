package written.leetcode.coupang;

import java.util.ArrayList;
import java.util.List;

public class NumberOfMatchingSequence792 {
  public int numMatchingSubseq(String s, String[] words) {
    int answer = 0;

    for(String word : words) {
      int wordIdx = 0;
      for(int i = 0; i < s.length(); i++) {
        if(s.charAt(i) == word.charAt(wordIdx)) wordIdx++;
        if(wordIdx == word.length()){
          answer++;
          break;
        }
      }
    }
    return answer;
  }

  class Node {
    int index;
    String value;

    public Node(String value, int index) {
      this.value = value;
      this.index = index;
    }
  }

  public int numMatchingSubseq2(String s, String[] words) {
    int answer = 0;

    List<Node>[] heads = new ArrayList[26];

    for(int i = 0; i < 26; i++) heads[i] = new ArrayList<>();
    for(String word : words) {
      char head = word.charAt(0);
      heads[head-'a'].add(new Node(word, 0));
    }

    for(int i = 0; i < s.length(); i++) {
      int currentChar = s.charAt(i) - 'a';
      List<Node> oldBucket = heads[currentChar];
      heads[currentChar] = new ArrayList<>();

      for(Node node : oldBucket) {
        node.index++;
        if(node.index == node.value.length()) {
          answer++;
        }
        else {
          heads[node.value.charAt(node.index)-'a'].add(node);
        }
      }
      oldBucket.clear();
    }
    return answer;
  }

  public static void main(String[] args) {
    NumberOfMatchingSequence792 numberOfMatchingSequence792 = new NumberOfMatchingSequence792();
    int abcde = numberOfMatchingSequence792
        .numMatchingSubseq2("abcde", new String[]{"a", "bb", "acd", "ace"});

    System.out.println("answer is" + abcde);

  }

}
