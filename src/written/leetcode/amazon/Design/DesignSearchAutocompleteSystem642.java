package written.leetcode.amazon.Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class DesignSearchAutocompleteSystem642 {

  private String prefix;
  private TrieNode root;
  public DesignSearchAutocompleteSystem642(String[] sentences, int[] times) {
    root = new TrieNode();
    prefix = "";
    for(int i = 0; i < sentences.length; i++) {
      add(sentences[i], times[i]);
    }
  }

  private void add(String input, int count) {
    TrieNode curr = root;
    for(char c : input.toCharArray()) {
      TrieNode next = curr.children.get(c);
      if(next == null) {
        next = new TrieNode();
        curr.children.put(c, next);
      }
      curr = next;
      curr.counts.put(input, curr.counts.getOrDefault(input, 0) + count);
    }
  }

  public List<String> input(char c) {
    if(c == '#') {
      add(prefix, 1);
      prefix ="";
      return new ArrayList<>();
    }
    prefix += c;

    TrieNode curr = root;

    for(char ch : prefix.toCharArray()) {
      TrieNode next = curr.children.get(ch);
      if(next == null) {
        return new ArrayList<>();
      }
      curr = next;
    }

    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.c == b.c ? a.s.compareTo(b.s) : b.c - a.c));

    List<String> res = new ArrayList<>();
    int n = 0;
    for(Entry<String, Integer> entry : curr.counts.entrySet()) {
      pq.add(new Pair(entry.getKey(), entry.getValue()));

    }

    while(!pq.isEmpty() && n < 3) {
      res.add(pq.poll().s);
      n++;
    }
    return res;
  }

  class Pair{
    int c;
    String s;
    public Pair(String s, int c) {
      this.c = c;
      this.s = s;
    }
  }


  public static void main(String[] args) {


    char c = 'a';

    String original = "abc";
    DesignSearchAutocompleteSystem642 designSearchAutocompleteSystem642 = new DesignSearchAutocompleteSystem642(
        new String[]{"i love you", "island", "iroman", "i love leetcode"}, new int[]{5, 3, 2, 2});

    List<String> i = designSearchAutocompleteSystem642.input('i');
    List<String> input = designSearchAutocompleteSystem642.input(' ');
    List<String> a = designSearchAutocompleteSystem642.input('a');
    designSearchAutocompleteSystem642.input('#');

    original = original.concat(String.valueOf(c));

    System.out.println(original);

  }
}
