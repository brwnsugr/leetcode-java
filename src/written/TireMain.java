package written;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class TrieMain {

  public static void main(String[] args) {
    Trie t = new Trie();

    t.add("jo");
    t.add("song");
    t.add("son");
    t.add("so");
    t.add("s");

    t.add("sperb");
    t.printall();
  }


  public static class Trie{
    TrieNode head;

    public Trie(){
      head = new TrieNode( ' ');
    }

    public void add(String val){
      TrieNode curr = head;
      for(char c : val.toCharArray()){
        //input if not containing
        if(!curr.children.containsKey(c)){
          curr.children.put(c, new TrieNode(c));
        }
        curr = curr.children.get(c);
      }
      curr.isEnd = true;
    }

    //Print all items
    public void printall(){
      Deque<Character> bufferDeque = new LinkedList<>();
      List<String> answer = new ArrayList<>();
      for(Map.Entry<Character, TrieNode> child : head.children.entrySet()){
        dfsHelper(child.getValue(), bufferDeque, answer);
      }

      for(String s : answer){
        System.out.println(s);
      }
    }

    //helper. making stirng
    private String helerBuildingStringFromDeque(Deque<Character> bufferDeque){
      StringBuilder sb = new StringBuilder();
      for(char c : bufferDeque){
        sb.append(c);
      }
      return sb.toString();
    }

    //dfs
    private void dfsHelper(TrieNode curr, Deque<Character> bufferDeque, List<String> answer){
      //when finished? if it is the last time
      bufferDeque.addLast(curr.ch);

      if(curr.isEnd){
        String keyword = helerBuildingStringFromDeque(bufferDeque);
        answer.add(keyword);
      }
      if(!curr.children.isEmpty()){
        //done.
        for(Map.Entry<Character, TrieNode> entry: curr.children.entrySet()){
          dfsHelper(entry.getValue(), bufferDeque, answer);
        }
      }
      //backtracking
      bufferDeque.removeLast();
    }

    //TrieNode
    public static class TrieNode{
      public Map<Character, TrieNode> children = new HashMap<>();
      public char ch;
      public boolean isEnd = false;
      public TrieNode(char ch){
        this.ch = ch;
      }
    }
  }

}
