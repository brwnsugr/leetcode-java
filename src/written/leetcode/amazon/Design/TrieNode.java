package written.leetcode.amazon.Design;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

  Map<String, Integer> counts;
  Map<Character, TrieNode> children;
  public TrieNode() {
    children = new HashMap<>();
    counts = new HashMap<>();
  }

}
