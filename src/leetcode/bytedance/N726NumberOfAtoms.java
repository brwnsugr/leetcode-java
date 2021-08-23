package leetcode.bytedance;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class N726NumberOfAtoms {
  public String countOfAtoms(String formula) {

    int N = formula.length();
    Stack<Map<String, Integer>> stack = new Stack<>();
    stack.add(new TreeMap<>());

    for(int i = 0; i < N;) {
      if (formula.charAt(i) == '(') {
       stack.add(new TreeMap());
       i++;
      }
      else if(formula.charAt(i) == ')') {
        Map<String, Integer> top = stack.pop();
        int iStart = ++i;
        int multiplicity = 1;
        while(i < N && Character.isDigit(formula.charAt(i))) i++;
        if ( i > iStart) multiplicity = Integer.parseInt(formula.substring(iStart, i));
        for (String c : top.keySet()) {
          int v = top.get(c);
          stack.peek().put(c, stack.peek().getOrDefault(c, 0) + v * multiplicity);
        }
      }
      else{
        int iStart = i++;
        while(i < N && Character.isLowerCase(formula.charAt(i))) i++;
        String name = formula.substring(iStart, i);
        iStart = i;
        while(i < N && Character.isDigit(formula.charAt(i))) i++;
        int multiplicity = i > iStart ? Integer.parseInt(formula.substring(iStart, i)) : 1;
        stack.peek().put(name, stack.peek().getOrDefault(name, 0) + multiplicity);
      }
    }

    StringBuilder ans = new StringBuilder();

    Map<String, Integer> peek = stack.peek();

    for (String name : peek.keySet()) {
      ans.append(name);
      int multiplicity = peek.get(name);
      if(multiplicity > 1) ans.append(multiplicity);
    }
    return new String(ans);
  }

  public static void main(String[] args) {
    N726NumberOfAtoms sol = new N726NumberOfAtoms();

    String h2O = sol.countOfAtoms("H2O");

    System.out.println(h2O);
  }
}
