package written.leetcode.amazon.Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class GenerateParentheses22 {

  private List<String> res = new ArrayList<>();
  public List<String> generateParenthesis(int n) {
    Stack<Character> s = new Stack<>();
    Map<Character, Integer> m = new HashMap<>();
    m.put('(', 1);
    m.put(')', 0);
    s.add('(');
    dfs(m, "(", s, n);
    return res;
  }

  private void dfs(Map<Character, Integer> m,  String paren, Stack<Character> s, int n) {
    if(s.isEmpty() && m.get('(') == n && m.get(')') == n) {
      res.add(String.copyValueOf(paren.toCharArray()));
      return;
    } else {
      if(s.isEmpty()) {
        s.add('(');
        m.put('(', m.get('(')+1);
        dfs(m, paren + "(", s,n);
        s.pop();
        m.put('(', m.get('(')-1);
      }
      if(!s.isEmpty() && s.peek() == '(' && m.get(')') < n) {
        s.pop();
        m.put(')', m.get(')')+1);
        dfs(m, paren + ")", s, n);
        m.put(')', m.get(')')-1);
        s.add('(');
      }
      if(!s.isEmpty() && s.peek() == '(' && m.get('(') < n) {
        s.add('(');
        m.put('(', m.get('(')+1);
        dfs(m, paren + "(", s, n);
        m.put('(', m.get('(')-1);
        s.pop();
      }
    }
    return;
  }

  public static void main(String[] args) {
    GenerateParentheses22 generateParentheses22 = new GenerateParentheses22();
    generateParentheses22.generateParenthesis(3);
  }
}
