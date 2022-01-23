package written.leetcode.amazon.Recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber17 {

  public static String[] DIGIT_LIST = {
      null,
      null,
      "abc",
      "def",
      "ghi",
      "jkl",
      "mno",
      "pqrs",
      "tuv",
      "wxyz"
  };

  private List<String> res = new ArrayList<>();

  public List<String> letterCombinations(String digits) {
    if(digits.length() == 0) return res;
    dfs(0, "", digits);

    return res;
  }

  private void dfs(int digitOrder, String letter, String digits) {
    if(digitOrder == digits.length()) {
      res.add(String.copyValueOf(letter.toCharArray()));
      return;
    }
    else {
      String digit = DIGIT_LIST[Integer.valueOf(digits.charAt(digitOrder)-'0')];
      for(int i = 0; i < digit.length(); i++) {
        dfs(digitOrder+1, letter + digit.substring(i, i+1), digits);
      }
    }
    return;
  }

  public static void main(String[] args) {
    LetterCombinationOfPhoneNumber17 letterCombinationOfPhoneNumber17 = new LetterCombinationOfPhoneNumber17();
    letterCombinationOfPhoneNumber17.letterCombinations("7");
  }
}
