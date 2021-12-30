package written.leetcode.amazon.ArrayAndStrings;

import java.util.Stack;

public class ValidParentheses20 {
  public boolean isValid(String s) {
    if(s.length() ==1) return false;
    Stack<Character> stack = new Stack<>();
    for(int i = 0; i < s.length(); i++) {
      char curr = s.charAt(i);
      if(curr == '(' || curr == '{' || curr == '[') {
        stack.add(curr);
      }
      else {
        if(stack.isEmpty()) return false;
        else {
          Character lastChar = stack.pop();
          if((lastChar == '(' && curr == ')')
              ||(lastChar == '{' && curr == '}' )
              ||(lastChar == '[' && curr == ']')) {
            continue;
          }
          else {
            return false;
          }
        }
      }
    }
    return stack.size() == 0;
  }

  public static void main(String[] args) {
    ValidParentheses20 validParentheses20 = new ValidParentheses20();
    validParentheses20.isValid("()");
  }

}

