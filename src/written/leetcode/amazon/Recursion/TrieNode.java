package written.leetcode.amazon.Recursion;

import java.util.HashMap;

public class TrieNode {
  String word;
  HashMap<Character, TrieNode> children = new HashMap<>();
  public TrieNode() {}
}
